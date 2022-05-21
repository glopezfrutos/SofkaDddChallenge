package com.sofkau.dddtourismagancy.tourismagancy;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.Tour;
import com.sofkau.dddtourismagancy.tourismagancy.events.*;
import com.sofkau.dddtourismagancy.tourismagancy.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class TourismAgency extends AggregateEvent<TourismAgencyId> {
    protected Name agencyName;
    protected AgencyAddress agencyAddress;
    protected AgencyOfficeHours agencyOfficeHours;
    protected Set<Tourist> tourists;
    protected Set<Agent> agents;


    public TourismAgency(TourismAgencyId entityId, Name agencyName, AgencyAddress agencyAddress, AgencyOfficeHours agencyOfficeHours) {
        super(entityId);
        appendChange(new TourismAgencyCreated(agencyName, agencyAddress, agencyOfficeHours)).apply();
    }

    private TourismAgency(TourismAgencyId tourismAgencyId) {
        super(tourismAgencyId);
        subscribe(new TourismAgencyChange(this));
    }

    public static TourismAgency from(TourismAgencyId tourismAgencyId, List<DomainEvent> events) {
        var agency = new TourismAgency(tourismAgencyId);
        events.forEach(agency::applyEvent);
        return agency;
    }


    public void updateAgencyName(Name agencyName) {
        appendChange(new AgencyNameUpdated(agencyName)).apply();
    }

    public void updateAgencyAddress(AgencyAddress agencyAddress) {
        appendChange(new AgencyAddressUpdated(agencyAddress)).apply();
    }

    public void updateAgencyOfficeHours(AgencyOfficeHours agencyOfficeHours) {
        appendChange(new AgencyOfficeHoursUpdated(agencyOfficeHours)).apply();
    }

    public void addTourist(TouristId entityId, Name touristName, Set<Tour> listOfTours, Set<RentalPackage> listOfRentalPackage) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(touristName);
        Objects.requireNonNull(listOfTours);
        Objects.requireNonNull(listOfRentalPackage);
        appendChange(new TouristAdded(entityId, touristName, listOfTours, listOfRentalPackage)).apply();
    }

    public void updateTouristName(TouristId touristId, Name name) {
        appendChange(new TouristNameUpdated(touristId, name)).apply();
    }

    public void updateListOfTours(TouristId touristId, Set<Tour> listOfTours) {
        appendChange(new ListOfToursUpdated(touristId, listOfTours)).apply();
    }

    public void updateListOfRentalPackages(TouristId touristId, Set<RentalPackage> listOfRentalPackage) {
        appendChange(new ListOfRentalPackageUpdated(touristId, listOfRentalPackage)).apply();
    }

    public void addAgent(AgentId entityId, Name agentName, Set<Tourist> listOfTouristInCharge) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(agentName);
        Objects.requireNonNull(listOfTouristInCharge);
        appendChange(new AgentAdded(entityId, agentName, listOfTouristInCharge)).apply();
    }

    public void updateAgentName(AgentId agentId, Name name) {
        appendChange(new AgentNameUpdated(agentId, name)).apply();
    }

    public void updateListOfTouristsInCharge(AgentId agentId, Set<Tourist> listOfTouristsInCharge) {
        appendChange(new ListOfTouristsInChargeUpdated(agentId, listOfTouristsInCharge)).apply();
    }


    public Optional<Agent> getAgentById(AgentId agentId) {
        return agents()
                .stream()
                .filter(agent -> agent.identity().equals(agentId))
                .findFirst();
    }

    public Optional<Tourist> getTouristById(TouristId touristId) {
        return tourists()
                .stream()
                .filter(tourist -> tourist.identity().equals(touristId))
                .findFirst();
    }


    public Name agencyName() {
        return agencyName;
    }

    public AgencyAddress agencyAddress() {
        return agencyAddress;
    }

    public AgencyOfficeHours agencyOfficeHours() {
        return agencyOfficeHours;
    }

    public Set<Tourist> tourists() {
        return tourists;
    }

    public Set<Agent> agents() {
        return agents;
    }
}

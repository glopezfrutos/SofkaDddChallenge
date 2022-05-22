package com.sofkau.dddtourismagancy.domain.tourismagancy;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.*;

import java.util.HashSet;

public class TourismAgencyChange extends EventChange {
    public TourismAgencyChange(TourismAgency tourismAgency) {
        apply((TourismAgencyCreated event) -> {
            tourismAgency.agencyName = event.getAgencyName();
            tourismAgency.agencyAddress = event.getAgencyAddress();
            tourismAgency.agencyOfficeHours = event.getAgencyOfficeHours();
            tourismAgency.tourists = new HashSet<>();
            tourismAgency.agents = new HashSet<>();
        } );

        apply((AgencyNameUpdated event) -> {
            tourismAgency.agencyName = event.getAgencyName();
        } );

        apply((AgencyAddressUpdated event) -> {
            tourismAgency.agencyAddress = event.getAgencyAddress();
        } );

        apply((AgencyOfficeHoursUpdated event) -> {
            tourismAgency.agencyOfficeHours = event.getAgencyOfficeHours();
        } );

        apply((TouristAdded event) -> {
            tourismAgency.tourists.add(new Tourist(
                    event.getEntityId(),
                    event.getTouristName(),
                    event.getListOfTours(),
                    event.getListOfRentalPackage()
            ));
        });

        apply((TouristNameUpdated event) -> {
            var tourist = tourismAgency.getTouristById(event.getTouristId())
                    .orElseThrow(() -> new IllegalArgumentException("Tourist not found."));
            tourist.updateTouristName(event.getName());
        });

        apply((ListOfToursUpdated event) -> {
            var tourist = tourismAgency.getTouristById(event.getTouristId())
                    .orElseThrow(() -> new IllegalArgumentException("Tourist not found."));
            tourist.updateListOfTours(event.getListOfTours());
        });

        apply((ListOfRentalPackageUpdated event) -> {
            var tourist = tourismAgency.getTouristById(event.getTouristId())
                    .orElseThrow(() -> new IllegalArgumentException("Tourist not found."));
            tourist.updateListOfRentalPackages(event.getListOfRentalPackage());
        });

        apply((AgentAdded event) -> {
            tourismAgency.agents.add(new Agent(
                    event.getEntityId(),
                    event.getAgentName(),
                    event.getListOfTouristInCharge()
            ));
        });

        apply((AgentNameUpdated event) -> {
            var agent = tourismAgency.getAgentById(event.getAgentId())
                    .orElseThrow(() -> new IllegalArgumentException("Agent not found."));
            agent.updateAgentName(event.getName());
        });

        apply((ListOfTouristsInChargeUpdated event) -> {
            var agent = tourismAgency.getAgentById(event.getAgentId())
                    .orElseThrow(() -> new IllegalArgumentException("Agent not found."));
            agent.updateListOfTouristInCharge(event.getListOfTouristsInCharge());
        });
    }
}

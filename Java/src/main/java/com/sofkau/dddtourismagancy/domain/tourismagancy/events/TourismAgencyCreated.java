package com.sofkau.dddtourismagancy.domain.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;

public class TourismAgencyCreated extends DomainEvent {
    private final Name agencyName;
    private final AgencyAddress agencyAddress;
    private final AgencyOfficeHours agencyOfficeHours;

    public TourismAgencyCreated(Name agencyName, AgencyAddress agencyAddress, AgencyOfficeHours agencyOfficeHours) {
        super("sofkau.tourismagancy.tourismagancycreated");
        this.agencyName = agencyName;
        this.agencyAddress = agencyAddress;
        this.agencyOfficeHours = agencyOfficeHours;
    }

    public Name getAgencyName() {
        return agencyName;
    }

    public AgencyAddress getAgencyAddress() {
        return agencyAddress;
    }

    public AgencyOfficeHours getAgencyOfficeHours() {
        return agencyOfficeHours;
    }
}

package com.sofkau.dddtourismagancy.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgencyOfficeHours;

public class AgencyOfficeHoursUpdated extends DomainEvent {
    private final AgencyOfficeHours agencyOfficeHours;

    public AgencyOfficeHoursUpdated(AgencyOfficeHours agencyOfficeHours) {
        super("sofkau.dddtourismagancy.tourismagancy.AgencyOfficeHoursUpdated");
        this.agencyOfficeHours = agencyOfficeHours;
    }

    public AgencyOfficeHours getAgencyOfficeHours() {
        return agencyOfficeHours;
    }
}

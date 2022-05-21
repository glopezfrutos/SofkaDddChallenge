package com.sofkau.dddtourismagancy.domain.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

public class AgencyNameUpdated extends DomainEvent {
    private final Name agencyName;

    public AgencyNameUpdated(Name agencyName) {
        super("sofkau.dddtourismagancy.tourismagancy.AgencyNameUpdated");
        this.agencyName = agencyName;
    }

    public Name getAgencyName() {
        return agencyName;
    }
}

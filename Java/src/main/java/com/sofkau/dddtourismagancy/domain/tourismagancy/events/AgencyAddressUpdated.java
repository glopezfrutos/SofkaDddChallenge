package com.sofkau.dddtourismagancy.domain.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;

public class AgencyAddressUpdated extends DomainEvent {
    private final AgencyAddress agencyAddress;

    public AgencyAddressUpdated(AgencyAddress agencyAddress) {
        super("sofkau.dddtourismagancy.tourismagancy.AgencyAddressUpdated");
        this.agencyAddress = agencyAddress;
    }

    public AgencyAddress getAgencyAddress() {
        return agencyAddress;
    }
}

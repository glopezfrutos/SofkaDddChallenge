package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

public class CreateTourismAgency extends Command {
    private final TourismAgencyId entityId;
    private final Name agencyName;
    private final AgencyAddress agencyAddress;
    private final AgencyOfficeHours agencyOfficeHours;

    public CreateTourismAgency(TourismAgencyId entityId, Name agencyName, AgencyAddress agencyAddress, AgencyOfficeHours agencyOfficeHours) {
        this.entityId = entityId;
        this.agencyName = agencyName;
        this.agencyAddress = agencyAddress;
        this.agencyOfficeHours = agencyOfficeHours;
    }

    public TourismAgencyId getEntityId() {
        return entityId;
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

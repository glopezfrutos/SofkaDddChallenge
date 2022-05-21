package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;

public class UpdateAgencyAddress extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final AgencyAddress agencyAddress;

    public UpdateAgencyAddress(TourismAgencyId tourismAgencyId, AgencyAddress agencyAddress) {
        this.tourismAgencyId = tourismAgencyId;
        this.agencyAddress = agencyAddress;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public AgencyAddress getAgencyAddress() {
        return agencyAddress;
    }
}

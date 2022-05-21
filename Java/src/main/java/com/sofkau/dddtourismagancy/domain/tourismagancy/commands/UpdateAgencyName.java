package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class UpdateAgencyName extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final Name agencyName;

    public UpdateAgencyName(TourismAgencyId tourismAgencyId, Name agencyName) {
        this.tourismAgencyId = tourismAgencyId;
        this.agencyName = agencyName;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public Name getAgencyName() {
        return agencyName;
    }
}

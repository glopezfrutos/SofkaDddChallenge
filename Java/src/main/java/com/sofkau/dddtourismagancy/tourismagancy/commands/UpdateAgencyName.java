package com.sofkau.dddtourismagancy.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.values.TourismAgencyId;

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

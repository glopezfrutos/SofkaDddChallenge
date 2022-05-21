package com.sofkau.dddtourismagancy.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.tourismagancy.values.TouristId;

public class UpdateTouristName extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final TouristId touristId;
    private final Name name;

    public UpdateTouristName(TourismAgencyId tourismAgencyId, TouristId touristId, Name name) {
        this.tourismAgencyId = tourismAgencyId;
        this.touristId = touristId;
        this.name = name;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public TouristId getTouristId() {
        return touristId;
    }

    public Name getName() {
        return name;
    }
}

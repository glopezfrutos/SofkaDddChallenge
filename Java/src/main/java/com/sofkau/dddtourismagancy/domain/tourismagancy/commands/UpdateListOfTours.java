package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TouristId;

import java.util.Set;

public class UpdateListOfTours extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final TouristId touristId;
    private final Set<Tour> listOfTours;

    public UpdateListOfTours(TourismAgencyId tourismAgencyId, TouristId touristId, Set<Tour> listOfTours) {
        this.tourismAgencyId = tourismAgencyId;
        this.touristId = touristId;
        this.listOfTours = listOfTours;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public TouristId getTouristId() {
        return touristId;
    }

    public Set<Tour> getListOfTours() {
        return listOfTours;
    }
}

package com.sofkau.dddtourismagancy.domain.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class UpdateTourName extends Command {
    private final TourId tourId;
    private final Name tourName;

    public UpdateTourName(TourId tourId, Name tourName) {
        this.tourId = tourId;
        this.tourName = tourName;
    }

    public TourId getTourId() {
        return tourId;
    }

    public Name getTourName() {
        return tourName;
    }
}

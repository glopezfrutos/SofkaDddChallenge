package com.sofkau.dddtourismagancy.domain.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class CreateTour extends Command {
    private final TourId entityId;
    private final Name tourName;

    public CreateTour(TourId entityId, Name tourName) {
        this.entityId = entityId;
        this.tourName = tourName;
    }

    public TourId getEntityId() {
        return entityId;
    }

    public Name getTourName() {
        return tourName;
    }
}

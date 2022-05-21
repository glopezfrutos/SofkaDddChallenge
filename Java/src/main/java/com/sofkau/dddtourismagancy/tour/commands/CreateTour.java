package com.sofkau.dddtourismagancy.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.values.TourId;

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

package com.sofkau.dddtourismagancy.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.tour.values.DestinationId;
import com.sofkau.dddtourismagancy.tour.values.TourId;

public class AddDestination extends Command {
    private final TourId tourId;
    private final DestinationId entityId;
    private final Name destinationName;
    private final DestinationDistance destinationDistance;

    public AddDestination(TourId tourId, DestinationId entityId, Name destinationName, DestinationDistance destinationDistance) {
        this.tourId = tourId;
        this.entityId = entityId;
        this.destinationName = destinationName;
        this.destinationDistance = destinationDistance;
    }

    public TourId getTourId() {
        return tourId;
    }

    public DestinationId getEntityId() {
        return entityId;
    }

    public Name getDestinationName() {
        return destinationName;
    }

    public DestinationDistance getDestinationDistance() {
        return destinationDistance;
    }
}

package com.sofkau.dddtourismagancy.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.tour.values.DestinationId;
import com.sofkau.dddtourismagancy.tour.values.TourId;

public class UpdateDestinationDistance extends Command {
    private final TourId tourId;
    private final DestinationId destinationId;
    private final DestinationDistance destinationDistance;

    public UpdateDestinationDistance(TourId tourId, DestinationId destinationId, DestinationDistance destinationDistance) {
        this.tourId = tourId;
        this.destinationId = destinationId;
        this.destinationDistance = destinationDistance;
    }

    public TourId getTourId() {
        return tourId;
    }

    public DestinationId getDestinationId() {
        return destinationId;
    }

    public DestinationDistance getDestinationDistance() {
        return destinationDistance;
    }
}

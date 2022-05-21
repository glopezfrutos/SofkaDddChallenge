package com.sofkau.dddtourismagancy.domain.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationId;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class UpdateDestinationName extends Command {
    private final TourId tourId;
    private final DestinationId destinationId;
    private final Name name;

    public UpdateDestinationName(TourId tourId, DestinationId destinationId, Name name) {
        this.tourId = tourId;
        this.destinationId = destinationId;
        this.name = name;
    }

    public TourId getTourId() {
        return tourId;
    }

    public DestinationId getDestinationId() {
        return destinationId;
    }

    public Name getName() {
        return name;
    }
}

package com.sofkau.dddtourismagancy.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.values.DestinationId;
import com.sofkau.dddtourismagancy.tour.values.TourId;

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

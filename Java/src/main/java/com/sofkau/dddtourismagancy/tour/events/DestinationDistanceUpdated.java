package com.sofkau.dddtourismagancy.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.tour.values.DestinationId;

public class DestinationDistanceUpdated extends DomainEvent {
    private final DestinationId destinationId;
    private final DestinationDistance destinationDistance;

    public DestinationDistanceUpdated(DestinationId destinationId, DestinationDistance destinationDistance) {
        super("sofkau.dddtourismagancy.tour.DestinationDistanceUpdated");
        this.destinationId = destinationId;
        this.destinationDistance = destinationDistance;
    }

    public DestinationId getDestinationId() {
        return destinationId;
    }

    public DestinationDistance getDestinationDistance() {
        return destinationDistance;
    }
}

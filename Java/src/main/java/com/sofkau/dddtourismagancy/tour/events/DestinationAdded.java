package com.sofkau.dddtourismagancy.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.tour.values.DestinationId;

public class DestinationAdded extends DomainEvent {
    private final DestinationId entityId;
    private final Name destinationName;
    private final DestinationDistance destinationDistance;


    public DestinationAdded(DestinationId entityId, Name destinationName, DestinationDistance destinationDistance) {
        super("sofkau.dddtourismagancy.tour.DestinationAdded");
        this.entityId = entityId;
        this.destinationName = destinationName;
        this.destinationDistance = destinationDistance;
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

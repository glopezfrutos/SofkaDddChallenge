package com.sofkau.dddtourismagancy.domain.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationId;

public class DestinationNameUpdated extends DomainEvent {
    private final DestinationId destinationId;
    private final Name name;

    public DestinationNameUpdated(DestinationId destinationId, Name name) {
        super("sofkau.dddtourismagancy.tour.DestinationNameUpdated");
        this.destinationId = destinationId;
        this.name = name;
    }

    public DestinationId getDestinationId() {
        return destinationId;
    }

    public Name getName() {
        return name;
    }
}

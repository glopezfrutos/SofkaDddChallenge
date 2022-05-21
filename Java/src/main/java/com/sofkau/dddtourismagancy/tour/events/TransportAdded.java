package com.sofkau.dddtourismagancy.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.tour.values.TransportId;
import com.sofkau.dddtourismagancy.tour.values.TransportType;
import com.sofkau.dddtourismagancy.tour.values.TripDuration;

public class TransportAdded extends DomainEvent {
    private final TransportId entityId;
    private final TransportType transportType;
    private final TripDuration tripDuration;

    public TransportAdded(TransportId entityId, TransportType transportType, TripDuration tripDuration) {
        super("sofkau.dddtourismagancy.tour.TransportAdded");
        this.entityId = entityId;
        this.transportType = transportType;
        this.tripDuration = tripDuration;
    }

    public TransportId getEntityId() {
        return entityId;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public TripDuration getTripDuration() {
        return tripDuration;
    }
}

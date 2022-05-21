package com.sofkau.dddtourismagancy.domain.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportId;
import com.sofkau.dddtourismagancy.domain.tour.values.TripDuration;

public class TripDurationUpdated extends DomainEvent {
    private final TransportId transportId;
    private final TripDuration tripDuration;


    public TripDurationUpdated(TransportId transportId, TripDuration tripDuration) {
        super("sofkau.dddtourismagancy.tour.TripDurationUpdated");
        this.transportId = transportId;
        this.tripDuration = tripDuration;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TripDuration getTripDuration() {
        return tripDuration;
    }
}

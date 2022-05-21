package com.sofkau.dddtourismagancy.domain.tour;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportType;
import com.sofkau.dddtourismagancy.domain.tour.values.TripDuration;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportId;

public class Transport extends Entity<TransportId> {
    private TransportType transportType;
    private TripDuration tripDuration;


    public Transport(TransportId entityId, TransportType transportType, TripDuration tripDuration) {
        super(entityId);
        this.transportType = transportType;
        this.tripDuration = tripDuration;
    }


    public void updateTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public void updateTripDuration(TripDuration tripDuration) {
        this.tripDuration = tripDuration;
    }


    public TransportType transportType() {
        return transportType;
    }

    public TripDuration tripDuration() {
        return tripDuration;
    }
}

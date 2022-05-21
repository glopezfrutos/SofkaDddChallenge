package com.sofkau.dddtourismagancy.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.tour.values.TourId;
import com.sofkau.dddtourismagancy.tour.values.TransportId;
import com.sofkau.dddtourismagancy.tour.values.TransportType;
import com.sofkau.dddtourismagancy.tour.values.TripDuration;

public class AddTransport extends Command {
    private final TourId tourId;
    private final TransportId entityId;
    private final TransportType transportType;
    private final TripDuration tripDuration;

    public AddTransport(TourId tourId, TransportId entityId, TransportType transportType, TripDuration tripDuration) {
        this.tourId = tourId;
        this.entityId = entityId;
        this.transportType = transportType;
        this.tripDuration = tripDuration;
    }

    public TourId getTourId() {
        return tourId;
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

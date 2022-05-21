package com.sofkau.dddtourismagancy.domain.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportId;
import com.sofkau.dddtourismagancy.domain.tour.values.TripDuration;

public class UpdateTripDuration extends Command {
    private final TourId tourId;
    private final TransportId transportId;
    private final TripDuration tripDuration;

    public UpdateTripDuration(TourId tourId, TransportId transportId, TripDuration tripDuration) {
        this.tourId = tourId;
        this.transportId = transportId;
        this.tripDuration = tripDuration;
    }

    public TourId getTourId() {
        return tourId;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TripDuration getTripDuration() {
        return tripDuration;
    }
}

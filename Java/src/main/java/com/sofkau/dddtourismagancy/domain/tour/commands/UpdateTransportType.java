package com.sofkau.dddtourismagancy.domain.tour.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportId;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportType;

public class UpdateTransportType extends Command {
    private final TourId tourId;
    private final TransportId transportId;
    private final TransportType transportType;

    public UpdateTransportType(TourId tourId, TransportId transportId, TransportType transportType) {
        this.tourId = tourId;
        this.transportId = transportId;
        this.transportType = transportType;
    }

    public TourId getTourId() {
        return tourId;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}

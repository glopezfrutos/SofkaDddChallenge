package com.sofkau.dddtourismagancy.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.tour.values.TransportId;
import com.sofkau.dddtourismagancy.tour.values.TransportType;

public class TransportTypeUpdated extends DomainEvent {
    private final TransportId transportId;
    private final TransportType transportType;

    public TransportTypeUpdated(TransportId transportId, TransportType transportType) {
        super("sofkau.dddtourismagancy.tour.TransportTypeUpdated");
        this.transportId = transportId;
        this.transportType = transportType;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public TransportType getTransportType() {
        return transportType;
    }
}

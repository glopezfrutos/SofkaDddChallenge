package com.sofkau.dddtourismagancy.tour;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.values.TourId;

import java.util.Set;

public class Tour extends AggregateEvent<TourId> {
    protected Name tourName;
    protected Set<Destination> destinations;
    protected Set<Transport> transports;

    public Tour(TourId entityId, Name tourName) {
        super(entityId);
    }
}

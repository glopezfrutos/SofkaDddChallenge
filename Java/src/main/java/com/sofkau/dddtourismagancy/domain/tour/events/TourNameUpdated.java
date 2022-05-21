package com.sofkau.dddtourismagancy.domain.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

public class TourNameUpdated extends DomainEvent {
    private final Name tourName;

    public TourNameUpdated(Name tourName) {
        super("sofkau.dddtourismagancy.tour.TourNameUpdated");
        this.tourName = tourName;
    }

    public Name getTourName() {
        return tourName;
    }
}

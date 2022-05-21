package com.sofkau.dddtourismagancy.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;

public class TourCreated extends DomainEvent {
    private final Name tourName;

    public TourCreated(Name name) {
        super("sofkau.tour.tourcreated");
        this.tourName = name;
    }

    public Name getTourName() {
        return tourName;
    }
}

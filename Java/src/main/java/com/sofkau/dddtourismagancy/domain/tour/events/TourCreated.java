package com.sofkau.dddtourismagancy.domain.tour.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

public class TourCreated extends DomainEvent {
    private final Name tourName;

    public TourCreated(Name name) {
        super("sofkau.dddtourismagancy.tour.tourcreated");
        this.tourName = name;
    }

    public Name getTourName() {
        return tourName;
    }
}

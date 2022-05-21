package com.sofkau.dddtourismagancy.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.values.TouristId;

public class TouristNameUpdated extends DomainEvent {
    private final TouristId touristId;
    private final Name name;

    public TouristNameUpdated(TouristId touristId, Name name) {
        super("sofkau.dddtourismagancy.tourismagancy.AgencyNameUpdated");
        this.touristId = touristId;
        this.name = name;
    }

    public TouristId getTouristId() {
        return touristId;
    }

    public Name getName() {
        return name;
    }
}

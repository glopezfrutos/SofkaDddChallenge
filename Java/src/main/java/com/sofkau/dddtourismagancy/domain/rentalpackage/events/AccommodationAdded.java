package com.sofkau.dddtourismagancy.domain.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationType;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class AccommodationAdded extends DomainEvent {
    private final AccommodationId entityId;
    private final AccommodationType accommodationType;
    private final Name accommodationName;

    public AccommodationAdded(AccommodationId entityId, AccommodationType accommodationType, Name accommodationName) {
        super("sofkau.dddtourismagancy.rentalpackage.AccommodationAdded");
        this.entityId = entityId;
        this.accommodationType = accommodationType;
        this.accommodationName = accommodationName;
    }


    public AccommodationId getEntityId() {
        return entityId;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public Name getAccommodationName() {
        return accommodationName;
    }
}

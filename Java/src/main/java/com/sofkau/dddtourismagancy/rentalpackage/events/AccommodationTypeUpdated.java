package com.sofkau.dddtourismagancy.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationType;

public class AccommodationTypeUpdated extends DomainEvent {
    private final AccommodationId accommodationId;
    private final AccommodationType accommodationType;

    public AccommodationTypeUpdated(AccommodationId accommodationId, AccommodationType accommodationType) {
        super("sofkau.dddtourismagancy.rentalpackage.AccommodationTypeUpdated");
        this.accommodationId = accommodationId;
        this.accommodationType = accommodationType;
    }


    public AccommodationId getAccommodationId() {
        return accommodationId;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }
}

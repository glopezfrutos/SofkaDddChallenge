package com.sofkau.dddtourismagancy.domain.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class AccommodationNameAdded extends DomainEvent {
    private final AccommodationId accommodationId;
    private final Name accomodationName;

    public AccommodationNameAdded(AccommodationId accommodationId, Name accomodationName) {
        super("sofkau.dddtourismagancy.rentalpackage.AccommodationNameAdded");
        this.accommodationId = accommodationId;
        this.accomodationName = accomodationName;
    }


    public AccommodationId getAccommodationId() {
        return accommodationId;
    }

    public Name getAccomodationName() {
        return accomodationName;
    }
}

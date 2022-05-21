package com.sofkau.dddtourismagancy.rentalpackage;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationType;
import com.sofkau.dddtourismagancy.shared.values.Name;

public class Accomodation extends Entity<AccommodationId> {
    private AccommodationType accommodationType;
    private Name accommodationName;


    public Accomodation(AccommodationId entityId, AccommodationType accommodationType, Name accommodationName) {
        super(entityId);
        this.accommodationType = accommodationType;
        this.accommodationName = accommodationName;
    }


    public void updateAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public void updateAccommodationName(Name accommodationName) {
        this.accommodationName = accommodationName;
    }


    public AccommodationType accommodationType() {
        return accommodationType;
    }

    public Name accommodationName() {
        return accommodationName;
    }
}

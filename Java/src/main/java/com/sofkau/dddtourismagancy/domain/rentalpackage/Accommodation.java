package com.sofkau.dddtourismagancy.domain.rentalpackage;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationType;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

public class Accommodation extends Entity<AccommodationId> {
    private AccommodationType accommodationType;
    private Name accommodationName;


    public Accommodation(AccommodationId entityId, AccommodationType accommodationType, Name accommodationName) {
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

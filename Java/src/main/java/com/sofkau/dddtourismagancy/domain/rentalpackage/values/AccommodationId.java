package com.sofkau.dddtourismagancy.domain.rentalpackage.values;

import co.com.sofka.domain.generic.Identity;

public class AccommodationId extends Identity {
    public AccommodationId() {
    }

    public AccommodationId(String id) {
        super(id);
    }

    public static AccommodationId of(String id) {
        return new AccommodationId(id);
    }
}

package com.sofkau.dddtourismagancy.domain.tour.values;

import co.com.sofka.domain.generic.Identity;

public class TourId extends Identity {
    public TourId() {
    }

    public TourId(String id) {
        super(id);
    }

    public static TourId of(String id) {
        return new TourId(id);
    }
}

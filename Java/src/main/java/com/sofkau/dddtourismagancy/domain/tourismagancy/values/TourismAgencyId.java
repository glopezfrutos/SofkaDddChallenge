package com.sofkau.dddtourismagancy.domain.tourismagancy.values;

import co.com.sofka.domain.generic.Identity;

public class TourismAgencyId extends Identity {
    public TourismAgencyId() {
    }

    public TourismAgencyId(String id) {
        super(id);
    }

    public static TourismAgencyId of(String id) {
        return new TourismAgencyId(id);
    }
}

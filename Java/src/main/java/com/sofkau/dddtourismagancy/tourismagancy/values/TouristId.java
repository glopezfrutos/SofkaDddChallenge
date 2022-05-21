package com.sofkau.dddtourismagancy.tourismagancy.values;

import co.com.sofka.domain.generic.Identity;

public class TouristId extends Identity {
    public TouristId() {
    }

    public TouristId(String id) {
        super(id);
    }

    public static TouristId of(String id) {
        return new TouristId(id);
    }
}

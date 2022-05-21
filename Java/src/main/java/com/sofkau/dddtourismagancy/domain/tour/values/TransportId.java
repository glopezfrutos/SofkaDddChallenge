package com.sofkau.dddtourismagancy.domain.tour.values;

import co.com.sofka.domain.generic.Identity;

public class TransportId extends Identity {
    public TransportId() {
    }

    public TransportId(String id) {
        super(id);
    }

    public static TransportId of(String id) {
        return new TransportId(id);
    }
}

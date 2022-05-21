package com.sofkau.dddtourismagancy.tour.values;

import co.com.sofka.domain.generic.Identity;

public class DestinationId extends Identity {
    public DestinationId() {
    }

    public DestinationId(String id) {
        super(id);
    }

    public static DestinationId of(String id) {
        return new DestinationId(id);
    }
}

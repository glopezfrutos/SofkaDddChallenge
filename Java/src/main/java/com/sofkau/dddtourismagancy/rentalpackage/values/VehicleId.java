package com.sofkau.dddtourismagancy.rentalpackage.values;

import co.com.sofka.domain.generic.Identity;

public class VehicleId extends Identity {
    public VehicleId() {
    }

    public VehicleId(String id) {
        super(id);
    }

    public static VehicleId of(String id) {
        return new VehicleId(id);
    }
}

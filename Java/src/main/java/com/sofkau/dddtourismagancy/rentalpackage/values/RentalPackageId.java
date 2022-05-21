package com.sofkau.dddtourismagancy.rentalpackage.values;

import co.com.sofka.domain.generic.Identity;

public class RentalPackageId extends Identity {
    public RentalPackageId() {
    }

    public RentalPackageId(String id) {
        super(id);
    }

    public static RentalPackageId of(String id) {
        return new RentalPackageId(id);
    }
}

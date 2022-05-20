package com.sofkau.dddtourismagancy.rentalpackage;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.dddtourismagancy.rentalpackage.values.RentalPackageId;

import java.util.Set;

public class RentalPackage extends AggregateEvent<RentalPackageId> {
    protected Set<Vehicle> vehicles;
    protected Set<Accomodation> accomodations;

    public RentalPackage(RentalPackageId entityId) {
        super(entityId);
    }
}

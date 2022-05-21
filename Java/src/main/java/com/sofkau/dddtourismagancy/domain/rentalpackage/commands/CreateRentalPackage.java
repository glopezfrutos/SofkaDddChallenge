package com.sofkau.dddtourismagancy.domain.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.rentalpackage.Accommodation;
import com.sofkau.dddtourismagancy.domain.rentalpackage.Vehicle;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RentalPackageId;

import java.util.Set;

public class CreateRentalPackage extends Command {
    private final RentalPackageId entityId;
    private final Set<Vehicle> vehicles;
    private final Set<Accommodation> accommodations;

    public CreateRentalPackage(RentalPackageId entityId, Set<Vehicle> vehicles, Set<Accommodation> accommodations) {
        this.entityId = entityId;
        this.vehicles = vehicles;
        this.accommodations = accommodations;
    }

    public RentalPackageId getEntityId() {
        return entityId;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }
}

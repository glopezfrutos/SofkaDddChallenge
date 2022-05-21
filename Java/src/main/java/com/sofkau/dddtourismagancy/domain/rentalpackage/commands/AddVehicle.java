package com.sofkau.dddtourismagancy.domain.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RegistrationPlate;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleType;

public class AddVehicle extends Command {
    private final RentalPackageId rentalPackageId;
    private final VehicleId entityId;
    private final VehicleType vehicleType;
    private final RegistrationPlate registrationPlate;

    public AddVehicle(RentalPackageId rentalPackageId, VehicleId entityId, VehicleType vehicleType, RegistrationPlate registrationPlate) {
        this.rentalPackageId = rentalPackageId;
        this.entityId = entityId;
        this.vehicleType = vehicleType;
        this.registrationPlate = registrationPlate;
    }

    public RentalPackageId getRentalPackageId() {
        return rentalPackageId;
    }

    public VehicleId getEntityId() {
        return entityId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public RegistrationPlate getRegistrationPlate() {
        return registrationPlate;
    }
}

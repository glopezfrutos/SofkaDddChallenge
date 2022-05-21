package com.sofkau.dddtourismagancy.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.rentalpackage.values.RegistrationPlate;
import com.sofkau.dddtourismagancy.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.rentalpackage.values.VehicleId;

public class UpdateRegistrationPlate extends Command {
    private final RentalPackageId rentalPackageId;
    private final VehicleId vehicleId;
    private final RegistrationPlate registrationPlate;

    public UpdateRegistrationPlate(RentalPackageId rentalPackageId, VehicleId vehicleId, RegistrationPlate registrationPlate) {
        this.rentalPackageId = rentalPackageId;
        this.vehicleId = vehicleId;
        this.registrationPlate = registrationPlate;
    }

    public RentalPackageId getRentalPackageId() {
        return rentalPackageId;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public RegistrationPlate getRegistrationPlate() {
        return registrationPlate;
    }
}

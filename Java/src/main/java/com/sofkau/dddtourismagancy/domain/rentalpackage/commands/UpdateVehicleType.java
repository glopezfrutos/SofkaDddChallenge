package com.sofkau.dddtourismagancy.domain.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleType;

public class UpdateVehicleType extends Command {
    private final RentalPackageId rentalPackageId;
    private final VehicleId vehicleId;
    private final VehicleType vehicleType;

    public UpdateVehicleType(RentalPackageId rentalPackageId, VehicleId vehicleId, VehicleType vehicleType) {
        this.rentalPackageId = rentalPackageId;
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public RentalPackageId getRentalPackageId() {
        return rentalPackageId;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

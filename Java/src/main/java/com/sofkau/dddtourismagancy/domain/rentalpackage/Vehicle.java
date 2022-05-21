package com.sofkau.dddtourismagancy.domain.rentalpackage;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RegistrationPlate;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleType;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleId;

public class Vehicle extends Entity<VehicleId> {
    private VehicleType vehicleType;
    private RegistrationPlate registrationPlate;


    public Vehicle(VehicleId entityId, VehicleType vehicleType, RegistrationPlate registrationPlate) {
        super(entityId);
        this.vehicleType = vehicleType;
        this.registrationPlate = registrationPlate;
    }


    public void updateVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void updateRegistrationPlate(RegistrationPlate registrationPlate) {
        this.registrationPlate = registrationPlate;
    }


    public VehicleType vehicleType() {
        return vehicleType;
    }

    public RegistrationPlate registrationPlate() {
        return registrationPlate;
    }
}

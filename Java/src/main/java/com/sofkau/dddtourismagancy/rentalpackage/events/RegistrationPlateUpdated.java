package com.sofkau.dddtourismagancy.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.rentalpackage.values.RegistrationPlate;
import com.sofkau.dddtourismagancy.rentalpackage.values.VehicleId;

public class RegistrationPlateUpdated extends DomainEvent {
    private final VehicleId vehicleId;
    private final RegistrationPlate registrationPlate;

    public RegistrationPlateUpdated(VehicleId vehicleId, RegistrationPlate registrationPlate) {
        super("sofkau.dddtourismagancy.rentalpackage.RegistrationPlateUpdated");
        this.vehicleId = vehicleId;
        this.registrationPlate = registrationPlate;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public RegistrationPlate getRegistrationPlate() {
        return registrationPlate;
    }
}

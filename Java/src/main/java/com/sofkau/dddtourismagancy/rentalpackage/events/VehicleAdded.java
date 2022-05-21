package com.sofkau.dddtourismagancy.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.rentalpackage.values.RegistrationPlate;
import com.sofkau.dddtourismagancy.rentalpackage.values.VehicleId;
import com.sofkau.dddtourismagancy.rentalpackage.values.VehicleType;

public class VehicleAdded extends DomainEvent {
    private final VehicleType vehicleType;
    private final RegistrationPlate registrationPlate;
    private final VehicleId entityId;

    public VehicleAdded(VehicleId entityId, VehicleType vehicleType, RegistrationPlate registrationPlate) {
        super("sofkau.dddtourismagancy.rentalpackage.rentalpackagecreated");
        this.entityId = entityId;
        this.vehicleType = vehicleType;
        this.registrationPlate = registrationPlate;
    }


    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public RegistrationPlate getRegistrationPlate() {
        return registrationPlate;
    }

    public VehicleId getEntityId() {
        return entityId;
    }
}

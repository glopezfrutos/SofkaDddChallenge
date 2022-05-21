package com.sofkau.dddtourismagancy.domain.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleType;

public class VehicleTypeUpdated extends DomainEvent {
    private final VehicleId vehicleId;
    private final VehicleType vehicleType;

    public VehicleTypeUpdated(VehicleId vehicleId, VehicleType vehicleType) {
        super("sofkau.dddtourismagancy.rentalpackage.VehicleTypeUpdated");
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}

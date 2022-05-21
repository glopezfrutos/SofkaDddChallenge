package com.sofkau.dddtourismagancy.rentalpackage.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.rentalpackage.Accommodation;
import com.sofkau.dddtourismagancy.rentalpackage.Vehicle;

import java.util.Set;

public class RentalPackageCreated extends DomainEvent {
    private final Set<Vehicle> vehicles;
    private final Set<Accommodation> accommodations;

    public RentalPackageCreated(Set<Vehicle> vehicles, Set<Accommodation> accommodations) {
        super("sofkau.rentalpackage.rentalpackagecreated");
        this.vehicles = vehicles;
        this.accommodations = accommodations;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }
}

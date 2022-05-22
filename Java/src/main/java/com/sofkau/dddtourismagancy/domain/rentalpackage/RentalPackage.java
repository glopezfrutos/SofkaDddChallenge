package com.sofkau.dddtourismagancy.domain.rentalpackage;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.*;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.*;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RentalPackage extends AggregateEvent<RentalPackageId> {
    protected Set<Vehicle> vehicles;
    protected Set<Accommodation> accommodations;

    public RentalPackage(RentalPackageId entityId, Set<Vehicle> vehicles, Set<Accommodation> accommodations) {
        super(entityId);
        appendChange(new RentalPackageCreated(vehicles, accommodations)).apply();
    }

    private RentalPackage(RentalPackageId entityId) {
        super(entityId);
        subscribe(new RentalPackageChange(this));
    }

    public static RentalPackage from(RentalPackageId entityId, List<DomainEvent> events) {
        var rentalPackage = new RentalPackage(entityId);
        events.forEach(rentalPackage::applyEvent);
        return rentalPackage;
    }

    public void addVehicle(VehicleId entityId, VehicleType vehicleType, RegistrationPlate registrationPlate) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(vehicleType);
        Objects.requireNonNull(registrationPlate);
        appendChange(new VehicleAdded(entityId, vehicleType, registrationPlate)).apply();
    }

    public void updateVehicleType(VehicleId vehicleId, VehicleType vehicleType) {
        appendChange(new VehicleTypeUpdated(vehicleId, vehicleType)).apply();
    }

    public void updateRegistrationPlate(VehicleId vehicleId, RegistrationPlate registrationPlate) {
        appendChange(new RegistrationPlateUpdated(vehicleId, registrationPlate)).apply();
    }

    public void addAccommodation(AccommodationId entityId, AccommodationType accommodationType, Name accommodationName) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(accommodationType);
        Objects.requireNonNull(accommodationName);
        appendChange(new AccommodationAdded(entityId, accommodationType, accommodationName)).apply();
    }

    public void updateAccommodationType(AccommodationId accommodationId, AccommodationType accommodationType) {
        appendChange(new AccommodationTypeUpdated(accommodationId, accommodationType)).apply();
    }

    public void updateAccommodationName(AccommodationId accommodationId, Name accomodationName) {
        appendChange(new AccommodationNameAdded(accommodationId, accomodationName)).apply();
    }


    protected Optional<Vehicle> getVehicleById(VehicleId vehicleId) {
        return vehicles()
                .stream()
                .filter(vehicle -> vehicle.identity().equals(vehicleId))
                .findFirst();
    }

    protected Optional<Accommodation> getAccommodationById(AccommodationId accommodationId) {
        return accomodations()
                .stream()
                .filter(accommodation -> accommodation.identity().equals(accommodationId))
                .findFirst();
    }


    public Set<Vehicle> vehicles() {
        return vehicles;
    }

    public Set<Accommodation> accomodations() {
        return accommodations;
    }
}

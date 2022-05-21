package com.sofkau.dddtourismagancy.rentalpackage;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.dddtourismagancy.rentalpackage.values.*;
import com.sofkau.dddtourismagancy.shared.values.Name;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class RentalPackage extends AggregateEvent<RentalPackageId> {
    protected Set<Vehicle> vehicles;
    protected Set<Accomodation> accomodations;

    public RentalPackage(RentalPackageId entityId, Set<Vehicle> vehicles, Set<Accomodation> accomodations) {
        super(entityId);
        appendChange(new RentalPackageCreated(entityId, vehicles, accomodations)).apply();
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


    public Optional<Vehicle> getVehicleById(VehicleId vehicleId) {
        return vehicles()
                .stream()
                .filter(vehicle -> vehicle.identity().equals(vehicleId))
                .findFirst();
    }

    public Optional<Accomodation> getAccommodationById(AccommodationId accommodationId) {
        return accomodations()
                .stream()
                .filter(accomodation -> accomodation.identity().equals(accommodationId))
                .findFirst();
    }


    public Set<Vehicle> vehicles() {
        return vehicles;
    }

    public Set<Accomodation> accomodations() {
        return accomodations;
    }
}

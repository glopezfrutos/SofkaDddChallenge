package com.sofkau.dddtourismagancy.domain.rentalpackage;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.*;

public class RentalPackageChange extends EventChange {
    public RentalPackageChange(RentalPackage rentalPackage) {
        apply((RentalPackageCreated event) -> {
            rentalPackage.vehicles = event.getVehicles();
            rentalPackage.accommodations = event.getAccommodations();
        } );

        apply((VehicleAdded event) -> {
            rentalPackage.vehicles.add(new Vehicle(
                    event.getEntityId(),
                    event.getVehicleType(),
                    event.getRegistrationPlate()
            ));
        });

        apply((VehicleTypeUpdated event) -> {
            var vehicle = rentalPackage.getVehicleById(event.getVehicleId())
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle not found."));
            vehicle.updateVehicleType(event.getVehicleType());
        });

        apply((RegistrationPlateUpdated event) -> {
            var vehicle = rentalPackage.getVehicleById(event.getVehicleId())
                    .orElseThrow(() -> new IllegalArgumentException("Vehicle not found."));
            vehicle.updateRegistrationPlate(event.getRegistrationPlate());
        });

        apply((AccommodationAdded event) -> {
            rentalPackage.accommodations.add(new Accommodation(
                    event.getEntityId(),
                    event.getAccommodationType(),
                    event.getAccommodationName()
            ));
        });

        apply((AccommodationTypeUpdated event) -> {
            var accommodation = rentalPackage.getAccommodationById(event.getAccommodationId())
                    .orElseThrow(() -> new IllegalArgumentException("Accommodation not found."));
            accommodation.updateAccommodationType(event.getAccommodationType());
        });

        apply((AccommodationNameAdded event) -> {
            var accommodation = rentalPackage.getAccommodationById(event.getAccommodationId())
                    .orElseThrow(() -> new IllegalArgumentException("Accommodation not found."));
            accommodation.updateAccommodationName(event.getAccomodationName());
        });
    }
}

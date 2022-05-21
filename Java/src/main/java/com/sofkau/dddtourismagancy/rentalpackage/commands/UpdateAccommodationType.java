package com.sofkau.dddtourismagancy.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationType;
import com.sofkau.dddtourismagancy.rentalpackage.values.RentalPackageId;

public class UpdateAccommodationType extends Command {
    private final RentalPackageId rentalPackageId;
    private final AccommodationId accommodationId;
    private final AccommodationType accommodationType;

    public UpdateAccommodationType(RentalPackageId rentalPackageId, AccommodationId accommodationId, AccommodationType accommodationType) {
        this.rentalPackageId = rentalPackageId;
        this.accommodationId = accommodationId;
        this.accommodationType = accommodationType;
    }

    public RentalPackageId getRentalPackageId() {
        return rentalPackageId;
    }

    public AccommodationId getAccommodationId() {
        return accommodationId;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }
}

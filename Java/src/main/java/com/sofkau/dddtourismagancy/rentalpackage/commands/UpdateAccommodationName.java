package com.sofkau.dddtourismagancy.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.shared.values.Name;

public class UpdateAccommodationName extends Command {
    private final RentalPackageId rentalPackageId;
    private final AccommodationId accommodationId;
    private final Name accomodationName;

    public UpdateAccommodationName(RentalPackageId rentalPackageId, AccommodationId accommodationId, Name accomodationName) {
        this.rentalPackageId = rentalPackageId;
        this.accommodationId = accommodationId;
        this.accomodationName = accomodationName;
    }

    public RentalPackageId getRentalPackageId() {
        return rentalPackageId;
    }

    public AccommodationId getAccommodationId() {
        return accommodationId;
    }

    public Name getAccomodationName() {
        return accomodationName;
    }
}

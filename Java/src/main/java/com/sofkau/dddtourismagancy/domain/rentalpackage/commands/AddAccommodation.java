package com.sofkau.dddtourismagancy.domain.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.AccommodationType;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.domain.values.Name;

public class AddAccommodation extends Command {
    private final RentalPackageId rentalPackageId;
    private final AccommodationId entityId;
    private final AccommodationType accommodationType;
    private final Name accommodationName;

    public AddAccommodation(RentalPackageId rentalPackageId, AccommodationId entityId, AccommodationType accommodationType, Name accommodationName) {
        this.rentalPackageId = rentalPackageId;
        this.entityId = entityId;
        this.accommodationType = accommodationType;
        this.accommodationName = accommodationName;
    }

    public RentalPackageId getRentalPackageId() {
        return rentalPackageId;
    }

    public AccommodationId getEntityId() {
        return entityId;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public Name getAccommodationName() {
        return accommodationName;
    }
}

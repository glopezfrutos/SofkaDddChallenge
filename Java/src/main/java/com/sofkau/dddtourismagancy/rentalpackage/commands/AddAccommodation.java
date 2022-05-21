package com.sofkau.dddtourismagancy.rentalpackage.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationId;
import com.sofkau.dddtourismagancy.rentalpackage.values.AccommodationType;
import com.sofkau.dddtourismagancy.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.shared.values.Name;

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

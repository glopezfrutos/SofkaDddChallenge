package com.sofkau.dddtourismagancy.domain.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TouristId;

import java.util.Set;

public class ListOfRentalPackageUpdated extends DomainEvent {
    private final TouristId touristId;
    private final Set<RentalPackage> listOfRentalPackage;

    public ListOfRentalPackageUpdated(TouristId touristId, Set<RentalPackage> listOfRentalPackage) {
        super("sofkau.dddtourismagancy.tourismagancy.AgencyNameUpdated");
        this.touristId = touristId;
        this.listOfRentalPackage = listOfRentalPackage;
    }

    public TouristId getTouristId() {
        return touristId;
    }

    public Set<RentalPackage> getListOfRentalPackage() {
        return listOfRentalPackage;
    }
}

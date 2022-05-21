package com.sofkau.dddtourismagancy.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.tourismagancy.values.TouristId;

import java.util.Set;

public class UpdateListOfRentalPackages extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final TouristId touristId;
    private final Set<RentalPackage> listOfRentalPackage;

    public UpdateListOfRentalPackages(TourismAgencyId tourismAgencyId, TouristId touristId, Set<RentalPackage> listOfRentalPackage) {
        this.tourismAgencyId = tourismAgencyId;
        this.touristId = touristId;
        this.listOfRentalPackage = listOfRentalPackage;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public TouristId getTouristId() {
        return touristId;
    }

    public Set<RentalPackage> getListOfRentalPackage() {
        return listOfRentalPackage;
    }
}

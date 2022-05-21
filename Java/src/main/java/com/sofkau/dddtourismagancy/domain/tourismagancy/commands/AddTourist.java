package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TouristId;
import com.sofkau.dddtourismagancy.domain.values.Name;

import java.util.Set;

public class AddTourist extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final TouristId entityId;
    private final Name touristName;
    private final Set<Tour> listOfTours;
    private final Set<RentalPackage> listOfRentalPackage;

    public AddTourist(TourismAgencyId tourismAgencyId, TouristId entityId, Name touristName, Set<Tour> listOfTours, Set<RentalPackage> listOfRentalPackage) {
        this.tourismAgencyId = tourismAgencyId;
        this.entityId = entityId;
        this.touristName = touristName;
        this.listOfTours = listOfTours;
        this.listOfRentalPackage = listOfRentalPackage;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public TouristId getEntityId() {
        return entityId;
    }

    public Name getTouristName() {
        return touristName;
    }

    public Set<Tour> getListOfTours() {
        return listOfTours;
    }

    public Set<RentalPackage> getListOfRentalPackage() {
        return listOfRentalPackage;
    }
}

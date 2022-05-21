package com.sofkau.dddtourismagancy.domain.tourismagancy;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.domain.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TouristId;

import java.util.Objects;
import java.util.Set;

public class Tourist extends Entity<TouristId> {
    private Name touristName;
    private Set<Tour> listOfTours;
    private Set<RentalPackage> listOfRentalPackage;


    public Tourist(TouristId entityId, Name touristName, Set<Tour> listOfTours, Set<RentalPackage> listOfRentalPackage) {
        super(entityId);
        this.touristName = touristName;
        this.listOfTours = listOfTours;
        this.listOfRentalPackage = listOfRentalPackage;
    }


    public void updateTouristName(Name touristName) {
        this.touristName = Objects.requireNonNull(touristName);
    }

    public void updateListOfTours(Set<Tour> listOfTours) {
        this.listOfTours = Objects.requireNonNull(listOfTours);
    }

    public void updateListOfRentalPackages(Set<RentalPackage> listOfRentalPackage) {
        this.listOfRentalPackage = Objects.requireNonNull(listOfRentalPackage);
    }


    public Name touristName() {
        return touristName;
    }

    public Set<Tour> listOfTours() {
        return listOfTours;
    }

    public Set<RentalPackage> listOfRentalPackage() {
        return listOfRentalPackage;
    }
}

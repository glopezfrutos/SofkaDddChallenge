package com.sofkau.dddtourismagancy.domain.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.domain.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TouristId;

import java.util.Set;

public class TouristAdded extends DomainEvent {
    private final TouristId entityId;
    private final Name touristName;
    private final Set<Tour> listOfTours;
    private final Set<RentalPackage> listOfRentalPackage;

    public TouristAdded(TouristId entityId, Name touristName, Set<Tour> listOfTours, Set<RentalPackage> listOfRentalPackage) {
        super("sofkau.dddtourismagancy.tourismagancy.TouristAdded");
        this.entityId = entityId;
        this.touristName = touristName;
        this.listOfTours = listOfTours;
        this.listOfRentalPackage = listOfRentalPackage;
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

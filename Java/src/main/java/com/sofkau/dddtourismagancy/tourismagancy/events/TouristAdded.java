package com.sofkau.dddtourismagancy.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.Tour;
import com.sofkau.dddtourismagancy.tourismagancy.values.TouristId;

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

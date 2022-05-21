package com.sofkau.dddtourismagancy.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.tour.Tour;
import com.sofkau.dddtourismagancy.tourismagancy.values.TouristId;

import java.util.Set;

public class ListOfToursUpdated extends DomainEvent {
    private final TouristId touristId;
    private final Set<Tour> listOfTours;

    public ListOfToursUpdated(TouristId touristId, Set<Tour> listOfTours) {
        super("sofkau.dddtourismagancy.tourismagancy.ListOfToursUpdated");
        this.touristId = touristId;
        this.listOfTours = listOfTours;
    }

    public TouristId getTouristId() {
        return touristId;
    }

    public Set<Tour> getListOfTours() {
        return listOfTours;
    }
}

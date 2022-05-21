package com.sofkau.dddtourismagancy.domain.tour;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationId;

public class Destination extends Entity<DestinationId> {
    private Name destinationName;
    private DestinationDistance destinationDistance;


    public Destination(DestinationId entityId, Name destinationName, DestinationDistance destinationDistance) {
        super(entityId);
        this.destinationName = destinationName;
        this.destinationDistance = destinationDistance;
    }


    public void updateDestinationName(Name destinationName) {
        this.destinationName = destinationName;
    }

    public void updateDestinationDistance(DestinationDistance destinationDistance) {
        this.destinationDistance = destinationDistance;
    }



    public Name destinationName() {
        return destinationName;
    }

    public DestinationDistance destinationDistance() {
        return destinationDistance;
    }
}

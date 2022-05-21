package com.sofkau.dddtourismagancy.tour;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tour.events.*;
import com.sofkau.dddtourismagancy.tour.values.*;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Tour extends AggregateEvent<TourId> {
    protected Name tourName;
    protected Set<Destination> destinations;
    protected Set<Transport> transports;


    public Tour(TourId entityId, Name tourName) {
        super(entityId);
        appendChange(new TourCreated(tourName)).apply();
    }


    public void updateTourName(Name tourName) {
        appendChange(new TourNameUpdated(tourName)).apply();
    }

    public void addDestination(DestinationId entityId, Name destinationName, DestinationDistance destinationDistance) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(destinationName);
        Objects.requireNonNull(destinationDistance);
        appendChange(new DestinationAdded(entityId, destinationName, destinationDistance)).apply();
    }

    public void updateDestinationName(DestinationId destinationId, Name name) {
        appendChange(new DestinationNameUpdated(destinationId, name)).apply();
    }

    public void updateDestinationDistance(DestinationId destinationId, DestinationDistance destinationDistance) {
        appendChange(new DestinationDistanceUpdated(destinationId, destinationDistance)).apply();
    }

    public void addTransport(TransportId entityId, TransportType transportType, TripDuration tripDuration) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(transportType);
        Objects.requireNonNull(tripDuration);
        appendChange(new TransportAdded(entityId, transportType, tripDuration)).apply();
    }

    public void updateTransportType(TransportId transportId, TransportType transportType) {
        appendChange(new TransportTypeUpdated(transportId, transportType)).apply();
    }

    public void updateTripDuration(TransportId transportId, TripDuration tripDuration) {
        appendChange(new TripDurationUpdated(transportId, tripDuration)).apply();
    }


    public Optional<Destination> getDestinationById(DestinationId destinationId) {
        return destinations()
                .stream()
                .filter(destination -> destination.identity().equals(destinationId))
                .findFirst();
    }

    public Optional<Transport> getTransportById(TransportId transportId) {
        return transports()
                .stream()
                .filter(transport -> transport.identity().equals(transportId))
                .findFirst();
    }


    public Name tourName() {
        return tourName;
    }

    public Set<Destination> destinations() {
        return destinations;
    }

    public Set<Transport> transports() {
        return transports;
    }
}

package com.sofkau.dddtourismagancy.tour;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddtourismagancy.tour.events.*;

public class TourChange extends EventChange {
    public TourChange(Tour tour) {
        apply((TourCreated event) -> {
            tour.tourName = event.getTourName();
        } );

        apply((TourNameUpdated event) -> {
            tour.tourName = event.getTourName();
        } );

        apply((DestinationAdded event) -> {
            tour.destinations.add(new Destination(
                    event.getEntityId(),
                    event.getDestinationName(),
                    event.getDestinationDistance()
            ));
        });

        apply((DestinationNameUpdated event) -> {
            var destination = tour.getDestinationById(event.getDestinationId())
                    .orElseThrow(() -> new IllegalArgumentException("Destination not found."));
            destination.updateDestinationName(event.getName());
        });

        apply((DestinationDistanceUpdated event) -> {
            var destination = tour.getDestinationById(event.getDestinationId())
                    .orElseThrow(() -> new IllegalArgumentException("Destination not found."));
            destination.updateDestinationDistance(event.getDestinationDistance());
        });

        apply((TransportAdded event) -> {
            tour.transports.add(new Transport(
                    event.getEntityId(),
                    event.getTransportType(),
                    event.getTripDuration()
                    ));
        });

        apply((TransportTypeUpdated event) -> {
            var transport = tour.getTransportById(event.getTransportId())
                    .orElseThrow(() -> new IllegalArgumentException("Transport not found."));
            transport.updateTransportType(event.getTransportType());
        });

        apply((TripDurationUpdated event) -> {
            var transport = tour.getTransportById(event.getTransportId())
                    .orElseThrow(() -> new IllegalArgumentException("Transport not found."));
            transport.updateTripDuration(event.getTripDuration());
        });
    }
}

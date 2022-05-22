package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tour.events.TourCreated;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationId;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;

public class TEAddDestinationUseCase extends UseCase<TriggeredEvent<TourCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TourCreated> tourCreatedTriggeredEvent) {
        var event = tourCreatedTriggeredEvent.getDomainEvent();
        var tour = Tour.from(TourId.of(event.aggregateRootId()), this.retrieveEvents());
        tour.addDestination(new DestinationId(), new Name("Starting point"), new DestinationDistance("Km 0"));

        emit().onResponse(new ResponseEvents(tour.getUncommittedChanges()));
    }
}

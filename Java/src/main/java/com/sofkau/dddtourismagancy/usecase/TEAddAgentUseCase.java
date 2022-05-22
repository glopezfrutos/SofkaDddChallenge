package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgentId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;

import java.util.HashSet;

public class TEAddAgentUseCase extends UseCase<TriggeredEvent<TourismAgencyCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<TourismAgencyCreated> tourismAgencyCreatedTriggeredEvent) {
        var event = tourismAgencyCreatedTriggeredEvent.getDomainEvent();
        var tourismAgency = TourismAgency.from(TourismAgencyId.of(event.aggregateRootId()), this.retrieveEvents());
        tourismAgency.addAgent(new AgentId("0"), new Name("The Boss"), new HashSet<>());

        emit().onResponse(new ResponseEvents(tourismAgency.getUncommittedChanges()));
    }
}

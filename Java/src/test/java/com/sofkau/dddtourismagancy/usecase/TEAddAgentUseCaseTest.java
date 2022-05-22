package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.AgentAdded;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class TEAddAgentUseCaseTest {
    private final String ROOTID = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var event = new TourismAgencyCreated(
                new Name("Central Patagonia"),
                new AgencyAddress("Lakes road 123"),
                new AgencyOfficeHours("24 hours open")
        );
        event.setAggregateRootId(ROOTID);

        var useCase = new TEAddAgentUseCase();
        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                event
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var result = (AgentAdded)events.get(0);
        Assertions.assertEquals("The Boss", result.getAgentName().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}
package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.events.DestinationAdded;
import com.sofkau.dddtourismagancy.domain.tour.events.TourCreated;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class TEAddDestinationUseCaseTest {
    private final String ROOTID = "test123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDestination(){
        var event = new TourCreated(
                new Name("Victoria Island")
        );
        event.setAggregateRootId(ROOTID);

        var useCase = new TEAddDestinationUseCase();
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

        var result = (DestinationAdded)events.get(0);
        Assertions.assertEquals("Starting point", result.getDestinationName().value());
        Assertions.assertEquals("Km 0", result.getDestinationDistance().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}
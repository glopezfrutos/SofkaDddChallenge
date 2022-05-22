package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.commands.AddDestination;
import com.sofkau.dddtourismagancy.domain.tour.events.DestinationAdded;
import com.sofkau.dddtourismagancy.domain.tour.events.TourCreated;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationDistance;
import com.sofkau.dddtourismagancy.domain.tour.values.DestinationId;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddDestinationUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDestination(){
        var command = new AddDestination(TourId.of(ROOTID), DestinationId.of("123"), new Name("Pañuelos Port"), new DestinationDistance("15 km."));
        var useCase = new AddDestinationUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new TourCreated(
                        new Name("Blest Lake")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong adding a destination."))
                .getDomainEvents();

        var event = (DestinationAdded)events.get(0);
        Assertions.assertEquals(command.getDestinationName().value(), event.getDestinationName().value());
        Assertions.assertEquals(command.getDestinationDistance().value(), event.getDestinationDistance().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.commands.AddTransport;
import com.sofkau.dddtourismagancy.domain.tour.events.TourCreated;
import com.sofkau.dddtourismagancy.domain.tour.events.TransportAdded;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportId;
import com.sofkau.dddtourismagancy.domain.tour.values.TransportType;
import com.sofkau.dddtourismagancy.domain.tour.values.TripDuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddTransportUseCaseTest {

    private final String ROOTID = "xxxx";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var command = new AddTransport(TourId.of(ROOTID), TransportId.of("123"), new TransportType("Car"), new TripDuration("20 minutes"));
        var useCase = new AddTransportUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong adding a transpor."))
                .getDomainEvents();

        var event = (TransportAdded)events.get(0);
        Assertions.assertEquals(command.getTransportType().value(), event.getTransportType().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

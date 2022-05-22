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
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddTourist;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TouristAdded;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TouristId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddTouristUseCaseTest {

    private final String ROOTID = "touristTest";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var command = new AddTourist(TourismAgencyId.of(ROOTID), TouristId.of("Test123"), new Name("Jonh Doe"), new HashSet<>(), new HashSet<>());
        var useCase = new AddTouristUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new TourismAgencyCreated(
                        new Name("Agency 2"),
                        new AgencyAddress("Main road 123"),
                        new AgencyOfficeHours("From sun to sun")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong adding a tourist"))
                .getDomainEvents();

        var event = (TouristAdded)events.get(0);
        Assertions.assertEquals(command.getTouristName().value(), event.getTouristName().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

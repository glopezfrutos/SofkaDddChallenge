package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.rentalpackage.commands.AddAccommodation;
import com.sofkau.dddtourismagancy.domain.rentalpackage.commands.AddVehicle;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.AccommodationAdded;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.RentalPackageCreated;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.VehicleAdded;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.*;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddAccommodationUseCaseTest {

    private final String ROOTID = "testAccommodation";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var command = new AddAccommodation(RentalPackageId.of(ROOTID), AccommodationId.of("Hotel01"), new AccommodationType("5 stars Hotel"), new Name("Hilton"));
        var useCase = new AddAccommodationUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new RentalPackageCreated(
                        new HashSet<>(),
                        new HashSet<>()
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong adding an accommodation."))
                .getDomainEvents();

        var event = (AccommodationAdded)events.get(0);
        Assertions.assertEquals(command.getAccommodationName().value(), event.getAccommodationName().value());
        Assertions.assertEquals(command.getAccommodationType().value(), event.getAccommodationType().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

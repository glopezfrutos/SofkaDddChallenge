package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.rentalpackage.commands.AddVehicle;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.RentalPackageCreated;
import com.sofkau.dddtourismagancy.domain.rentalpackage.events.VehicleAdded;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RegistrationPlate;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.RentalPackageId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleId;
import com.sofkau.dddtourismagancy.domain.rentalpackage.values.VehicleType;
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

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddVehicleUseCaseTest {

    private final String ROOTID = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDestination(){
        var command = new AddVehicle(RentalPackageId.of(ROOTID), VehicleId.of("x"), new VehicleType("Car"), new RegistrationPlate("abc 123"));
        var useCase = new AddVehicleUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong adding a vehicle."))
                .getDomainEvents();

        var event = (VehicleAdded)events.get(0);
        Assertions.assertEquals(command.getVehicleType().value(), event.getVehicleType().value());
        Assertions.assertEquals(command.getRegistrationPlate().value(), event.getRegistrationPlate().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

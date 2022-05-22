package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tour.commands.CreateTour;
import com.sofkau.dddtourismagancy.domain.tour.events.TourCreated;
import com.sofkau.dddtourismagancy.domain.tour.values.TourId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateTourUseCaseTest {
    @Test
    void createTour(){
        var command = new CreateTour(
                new TourId(),
                new Name("Small circuit")
        );

        var useCase = new CreateTourUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating the Tour."))
                .getDomainEvents();

        var event = (TourCreated)events.get(0);
        Assertions.assertEquals(command.getTourName().value(), event.getTourName().value());
    }
}
package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.CreateTourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateTourismAgencyUseCaseTest {


    @Test
    void CreateTourismAgency(){
        var command = new CreateTourismAgency(
                TourismAgencyId.of("xxxx"),
                new Name("Central"),
                new AgencyAddress("Los Prunus 1080"),
                new AgencyOfficeHours("De 8 a 12 y de 16 a 20 hs.")
        );

        var useCase = new CreateTourismAgencyUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong creating the Tourism Agency."))
                .getDomainEvents();

        var event = (TourismAgencyCreated)events.get(0);
        Assertions.assertEquals(command.getAgencyName().value(), event.getAgencyName().value());
        Assertions.assertEquals(command.getAgencyAddress().value(), event.getAgencyAddress().value());
        Assertions.assertEquals(command.getAgencyOfficeHours().value(), event.getAgencyOfficeHours().value());
    }
}
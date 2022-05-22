package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.UpdateAgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.UpdateAgencyName;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.AgencyAddressUpdated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.AgencyNameUpdated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class UpdateAgencyAddressUseCaseTest {

    private final String ROOTID = "updateAddress";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var command = new UpdateAgencyAddress(TourismAgencyId.of(ROOTID), new AgencyAddress("42nd Street"));
        var useCase = new UpdateAgencyAddressUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong updating the agency address"))
                .getDomainEvents();

        var event = (AgencyAddressUpdated)events.get(0);
        Assertions.assertEquals(command.getAgencyAddress().value(), event.getAgencyAddress().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

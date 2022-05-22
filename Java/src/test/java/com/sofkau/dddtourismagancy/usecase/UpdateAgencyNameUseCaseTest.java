package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddAgent;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.UpdateAgencyName;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.AgencyNameUpdated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.AgentAdded;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgentId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UpdateAgencyNameUseCaseTest {

    private final String ROOTID = "updateName";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var command = new UpdateAgencyName(TourismAgencyId.of(ROOTID), new Name("New great agency"));
        var useCase = new UpdateAgencyNameUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong updating the agency name"))
                .getDomainEvents();

        var event = (AgencyNameUpdated)events.get(0);
        Assertions.assertEquals(command.getAgencyName().value(), event.getAgencyName().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

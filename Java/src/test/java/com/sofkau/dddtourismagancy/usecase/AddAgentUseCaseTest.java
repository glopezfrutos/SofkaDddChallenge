package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddAgent;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddTourist;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.AgentAdded;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TourismAgencyCreated;
import com.sofkau.dddtourismagancy.domain.tourismagancy.events.TouristAdded;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddAgentUseCaseTest {

    private final String ROOTID = "agentTest";

    @Mock
    private DomainEventRepository repository;

    @Test
    void test(){
        var command = new AddAgent(TourismAgencyId.of(ROOTID), AgentId.of("Test123"), new Name("Sherlock"), new HashSet<>());
        var useCase = new AddAgentUseCase();

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
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong adding an agent"))
                .getDomainEvents();

        var event = (AgentAdded)events.get(0);
        Assertions.assertEquals(command.getAgentName().value(), event.getAgentName().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}

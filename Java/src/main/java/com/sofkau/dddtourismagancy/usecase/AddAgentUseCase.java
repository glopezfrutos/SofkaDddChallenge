package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddAgent;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddTourist;

public class AddAgentUseCase extends UseCase<RequestCommand<AddAgent>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAgent> addAgentRequestCommand) {
        var command = addAgentRequestCommand.getCommand();
        var agency = TourismAgency.from(command.getTourismAgencyId(), retrieveEvents(command.getTourismAgencyId().value()));
        agency.addAgent(command.getEntityId(), command.getAgentName(), command.getListOfTouristInCharge());

        emit().onResponse(new ResponseEvents(agency.getUncommittedChanges()));
    }
}

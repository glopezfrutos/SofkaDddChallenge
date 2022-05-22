package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddAgent;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.UpdateAgencyName;

public class UpdateAgencyNameUseCase extends UseCase<RequestCommand<UpdateAgencyName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateAgencyName> updateAgencyNameRequestCommand) {
        var command = updateAgencyNameRequestCommand.getCommand();
        var agency = TourismAgency.from(command.getTourismAgencyId(), retrieveEvents(command.getTourismAgencyId().value()));
        agency.updateAgencyName(command.getAgencyName());

        emit().onResponse(new ResponseEvents(agency.getUncommittedChanges()));
    }
}

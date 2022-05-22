package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.UpdateAgencyAddress;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.UpdateAgencyName;

public class UpdateAgencyAddressUseCase extends UseCase<RequestCommand<UpdateAgencyAddress>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateAgencyAddress> updateAgencyAddressRequestCommand) {
        var command = updateAgencyAddressRequestCommand.getCommand();
        var agency = TourismAgency.from(command.getTourismAgencyId(), retrieveEvents(command.getTourismAgencyId().value()));
        agency.updateAgencyAddress(command.getAgencyAddress());

        emit().onResponse(new ResponseEvents(agency.getUncommittedChanges()));
    }
}

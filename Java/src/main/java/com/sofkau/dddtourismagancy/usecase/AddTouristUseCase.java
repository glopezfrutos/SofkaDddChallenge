package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.AddTourist;

public class AddTouristUseCase extends UseCase<RequestCommand<AddTourist>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTourist> addTouristRequestCommand) {
        var command = addTouristRequestCommand.getCommand();
        var agency = TourismAgency.from(command.getTourismAgencyId(), retrieveEvents(command.getTourismAgencyId().value()));
        agency.addTourist(command.getEntityId(), command.getTouristName(), command.getListOfTours(), command.getListOfRentalPackage());

        emit().onResponse(new ResponseEvents(agency.getUncommittedChanges()));
    }
}

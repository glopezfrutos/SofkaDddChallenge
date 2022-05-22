package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.CreateTourismAgency;

public class CreateTourismAgencyUseCase extends UseCase<RequestCommand<CreateTourismAgency>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateTourismAgency> createTourismAgencyRequestCommand) {
        var command = createTourismAgencyRequestCommand.getCommand();
        var tourismAgency = new TourismAgency(
                command.getEntityId(),
                command.getAgencyName(),
                command.getAgencyAddress(),
                command.getAgencyOfficeHours()
        );
        emit().onResponse(new ResponseEvents(tourismAgency.getUncommittedChanges()));
    }
}

package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tour.commands.AddDestination;

public class AddDestinationUseCase extends UseCase<RequestCommand<AddDestination>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddDestination> addDestinationRequestCommand) {
        var command = addDestinationRequestCommand.getCommand();
        var tour = Tour.from(command.getTourId(), retrieveEvents(command.getTourId().value()));
        tour.addDestination(command.getEntityId(), command.getDestinationName(), command.getDestinationDistance());

        emit().onResponse(new ResponseEvents(tour.getUncommittedChanges()));
    }
}

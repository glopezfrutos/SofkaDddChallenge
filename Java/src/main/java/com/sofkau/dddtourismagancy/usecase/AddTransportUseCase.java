package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tour.commands.AddDestination;
import com.sofkau.dddtourismagancy.domain.tour.commands.AddTransport;

public class AddTransportUseCase extends UseCase<RequestCommand<AddTransport>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddTransport> addTransportRequestCommand) {
        var command = addTransportRequestCommand.getCommand();
        var tour = Tour.from(command.getTourId(), retrieveEvents(command.getTourId().value()));
        tour.addTransport(command.getEntityId(), command.getTransportType(), command.getTripDuration());

        emit().onResponse(new ResponseEvents(tour.getUncommittedChanges()));
    }
}

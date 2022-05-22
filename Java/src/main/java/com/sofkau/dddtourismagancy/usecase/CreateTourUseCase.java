package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tour.commands.CreateTour;
import com.sofkau.dddtourismagancy.domain.tourismagancy.TourismAgency;
import com.sofkau.dddtourismagancy.domain.tourismagancy.commands.CreateTourismAgency;

public class CreateTourUseCase extends UseCase<RequestCommand<CreateTour>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateTour> createTourRequestCommand) {
        var command = createTourRequestCommand.getCommand();
        var tour = new Tour(
                command.getEntityId(),
                command.getTourName()
        );
        emit().onResponse(new ResponseEvents(tour.getUncommittedChanges()));
    }
}

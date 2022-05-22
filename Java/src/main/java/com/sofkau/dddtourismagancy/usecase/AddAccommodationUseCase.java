package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.domain.rentalpackage.commands.AddAccommodation;
import com.sofkau.dddtourismagancy.domain.rentalpackage.commands.AddVehicle;

public class AddAccommodationUseCase extends UseCase<RequestCommand<AddAccommodation>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddAccommodation> AddAccommodationRequestCommand) {
        var command = AddAccommodationRequestCommand.getCommand();
        var rentalPackage = RentalPackage.from(command.getRentalPackageId(), retrieveEvents(command.getRentalPackageId().value()));
        rentalPackage.addAccommodation(command.getEntityId(), command.getAccommodationType(), command.getAccommodationName());

        emit().onResponse(new ResponseEvents(rentalPackage.getUncommittedChanges()));
    }
}

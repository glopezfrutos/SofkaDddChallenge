package com.sofkau.dddtourismagancy.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkau.dddtourismagancy.domain.rentalpackage.RentalPackage;
import com.sofkau.dddtourismagancy.domain.rentalpackage.commands.AddVehicle;
import com.sofkau.dddtourismagancy.domain.tour.Tour;
import com.sofkau.dddtourismagancy.domain.tour.commands.AddDestination;

public class AddVehicleUseCase extends UseCase<RequestCommand<AddVehicle>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddVehicle> addVehicleRequestCommand) {
        var command = addVehicleRequestCommand.getCommand();
        var rentalPackage = RentalPackage.from(command.getRentalPackageId(), retrieveEvents(command.getRentalPackageId().value()));
        rentalPackage.addVehicle(command.getEntityId(), command.getVehicleType(), command.getRegistrationPlate());

        emit().onResponse(new ResponseEvents(rentalPackage.getUncommittedChanges()));
    }
}

package com.sofkau.dddtourismagancy.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.tourismagancy.values.TourismAgencyId;

public class UpdateAgencyOfficeHours extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final AgencyOfficeHours agencyOfficeHours;

    public UpdateAgencyOfficeHours(TourismAgencyId tourismAgencyId, AgencyOfficeHours agencyOfficeHours) {
        this.tourismAgencyId = tourismAgencyId;
        this.agencyOfficeHours = agencyOfficeHours;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public AgencyOfficeHours getAgencyOfficeHours() {
        return agencyOfficeHours;
    }
}

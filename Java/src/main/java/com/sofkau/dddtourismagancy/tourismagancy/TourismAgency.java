package com.sofkau.dddtourismagancy.tourismagancy;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgencyAddress;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgencyOfficeHours;
import com.sofkau.dddtourismagancy.tourismagancy.values.TourismAgencyId;

import java.util.Set;

public class TourismAgency extends AggregateEvent<TourismAgencyId> {
    protected Name agencyName;
    protected AgencyAddress agencyAddress;
    protected AgencyOfficeHours agencyOfficeHours;
    protected Set<Tourist> tourists;
    protected Set<Agent> agents;

    public TourismAgency(TourismAgencyId entityId,
                         Name agencyName,
                         AgencyAddress agencyAddress,
                         AgencyOfficeHours agencyOfficeHours) {
        super(entityId);
    }
}

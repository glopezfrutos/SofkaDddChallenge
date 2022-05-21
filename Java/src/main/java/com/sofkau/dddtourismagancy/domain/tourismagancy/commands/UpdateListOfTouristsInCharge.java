package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tourismagancy.Tourist;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgentId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;

import java.util.Set;

public class UpdateListOfTouristsInCharge extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final AgentId agentId;
    private final Set<Tourist> listOfTouristsInCharge;

    public UpdateListOfTouristsInCharge(TourismAgencyId tourismAgencyId, AgentId agentId, Set<Tourist> listOfTouristsInCharge) {
        this.tourismAgencyId = tourismAgencyId;
        this.agentId = agentId;
        this.listOfTouristsInCharge = listOfTouristsInCharge;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public Set<Tourist> getListOfTouristsInCharge() {
        return listOfTouristsInCharge;
    }
}

package com.sofkau.dddtourismagancy.domain.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.domain.tourismagancy.Tourist;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgentId;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.TourismAgencyId;
import com.sofkau.dddtourismagancy.domain.shared.values.Name;

import java.util.Set;

public class AddAgent extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final AgentId entityId;
    private final Name agentName;
    private final Set<Tourist> listOfTouristInCharge;

    public AddAgent(TourismAgencyId tourismAgencyId, AgentId entityId, Name agentName, Set<Tourist> listOfTouristInCharge) {
        this.tourismAgencyId = tourismAgencyId;
        this.entityId = entityId;
        this.agentName = agentName;
        this.listOfTouristInCharge = listOfTouristInCharge;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public AgentId getEntityId() {
        return entityId;
    }

    public Name getAgentName() {
        return agentName;
    }

    public Set<Tourist> getListOfTouristInCharge() {
        return listOfTouristInCharge;
    }
}

package com.sofkau.dddtourismagancy.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.tourismagancy.Tourist;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgentId;

import java.util.Set;

public class ListOfTouristsInChargeUpdated extends DomainEvent {
    private final AgentId agentId;
    private final Set<Tourist> listOfTouristsInCharge;


    public ListOfTouristsInChargeUpdated(AgentId agentId, Set<Tourist> listOfTouristsInCharge) {
        super("sofkau.dddtourismagancy.tourismagancy.AgencyNameUpdated");
        this.agentId = agentId;
        this.listOfTouristsInCharge = listOfTouristsInCharge;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public Set<Tourist> getListOfTouristsInCharge() {
        return listOfTouristsInCharge;
    }
}

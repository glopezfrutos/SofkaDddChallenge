package com.sofkau.dddtourismagancy.tourismagancy;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgentId;

import java.util.Set;

public class Agent extends Entity<AgentId> {
    private Name agentName;
    private Set<Tourist> listOfTouristsInCharge;

    public Agent(AgentId entityId, Name agentName, Set<Tourist> listOfTouristsInCharge) {
        super(entityId);
        this.agentName = agentName;
        this.listOfTouristsInCharge = listOfTouristsInCharge;
    }


    public void updateAgentName(Name agentName) {
        this.agentName = agentName;
    }

    public void updateListOfTouristInCharge(Set<Tourist> listOfTouristInCharge) {
        this.listOfTouristsInCharge = listOfTouristInCharge;
    }


    public Name agentName() {
        return agentName;
    }

    public Set<Tourist> listOfTouristsInCharge() {
        return listOfTouristsInCharge;
    }
}

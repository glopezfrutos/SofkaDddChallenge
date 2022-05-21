package com.sofkau.dddtourismagancy.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.Tourist;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgentId;

import java.util.Set;

public class AgentAdded extends DomainEvent {
    private final AgentId entityId;
    private final Name agentName;
    private final Set<Tourist> listOfTouristInCharge;

    public AgentAdded(AgentId entityId, Name agentName, Set<Tourist> listOfTouristInCharge) {
        super("sofkau.dddtourismagancy.tourismagancy.AgentAdded");
        this.entityId = entityId;
        this.agentName = agentName;
        this.listOfTouristInCharge = listOfTouristInCharge;
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

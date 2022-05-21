package com.sofkau.dddtourismagancy.domain.tourismagancy.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddtourismagancy.domain.values.Name;
import com.sofkau.dddtourismagancy.domain.tourismagancy.values.AgentId;

public class AgentNameUpdated extends DomainEvent {
    private final AgentId agentId;
    private final Name name;

    public AgentNameUpdated(AgentId agentId, Name name) {
        super("sofkau.dddtourismagancy.tourismagancy.AgentNameUpdated");
        this.agentId = agentId;
        this.name = name;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public Name getName() {
        return name;
    }
}

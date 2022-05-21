package com.sofkau.dddtourismagancy.domain.tourismagancy.values;

import co.com.sofka.domain.generic.Identity;

public class AgentId extends Identity {
    public AgentId() {
    }

    public AgentId(String id) {
        super(id);
    }

    public static AgentId of(String id) {
        return new AgentId(id);
    }
}

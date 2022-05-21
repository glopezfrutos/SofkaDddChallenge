package com.sofkau.dddtourismagancy.tourismagancy.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddtourismagancy.shared.values.Name;
import com.sofkau.dddtourismagancy.tourismagancy.values.AgentId;
import com.sofkau.dddtourismagancy.tourismagancy.values.TourismAgencyId;

public class UpdateAgentName extends Command {
    private final TourismAgencyId tourismAgencyId;
    private final AgentId agentId;
    private final Name name;

    public UpdateAgentName(TourismAgencyId tourismAgencyId, AgentId agentId, Name name) {
        this.tourismAgencyId = tourismAgencyId;
        this.agentId = agentId;
        this.name = name;
    }

    public TourismAgencyId getTourismAgencyId() {
        return tourismAgencyId;
    }

    public AgentId getAgentId() {
        return agentId;
    }

    public Name getName() {
        return name;
    }
}

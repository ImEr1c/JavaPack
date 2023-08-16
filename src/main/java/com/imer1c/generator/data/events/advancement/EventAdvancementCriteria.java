package com.imer1c.generator.data.events.advancement;

public class EventAdvancementCriteria {
    public final EventAdvancementTrigger event;

    public EventAdvancementCriteria(String id, IAdvancementEventCondition condition)
    {
        this.event = new EventAdvancementTrigger(id, condition);
    }

    public EventAdvancementTrigger getEvent()
    {
        return event;
    }
}

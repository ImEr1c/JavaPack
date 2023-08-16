package com.imer1c.generator.data.events.advancement;

public class EventAdvancementTrigger {
    private final String trigger;
    public final IAdvancementEventCondition condition;

    public EventAdvancementTrigger(String trigger, IAdvancementEventCondition condition)
    {
        this.trigger = trigger;
        this.condition = condition;
    }

    public IAdvancementEventCondition getCondition()
    {
        return condition;
    }

    public String getTrigger()
    {
        return trigger;
    }
}

package com.imer1c.generator.data.events.advancement;

import com.imer1c.generator.data.events.advancement.breed.AdvancementEventType;

public class EventAdvancement {
    public final EventAdvancementCriteria criteria;

    public EventAdvancement(AdvancementEventType type)
    {
        criteria = new EventAdvancementCriteria(type.getId(), type.buildCondition());
    }
}

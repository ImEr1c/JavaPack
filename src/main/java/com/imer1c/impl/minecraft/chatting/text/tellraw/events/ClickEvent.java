package com.imer1c.impl.minecraft.chatting.text.tellraw.events;

import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawComponentBase;
import com.imer1c.generator.formatter.Formatters;

public class ClickEvent {
    private final String action;
    private final String value;

    public ClickEvent(ITellrawComponentBase.ClickEventType action, String value)
    {
        this.action = Formatters.format(action);
        this.value = value;
    }

    public String getAction()
    {
        return action;
    }

    public String getValue()
    {
        return value;
    }
}

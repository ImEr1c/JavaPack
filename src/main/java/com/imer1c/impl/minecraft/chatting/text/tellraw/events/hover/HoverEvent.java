package com.imer1c.impl.minecraft.chatting.text.tellraw.events.hover;

import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawComponentBase;
import com.imer1c.generator.formatter.Formatters;

public class HoverEvent implements IHoverEvent<String> {
    private final String action;
    private final String contents;

    public HoverEvent(ITellrawComponentBase.HoverEventType action, String contents)
    {
        this.action = Formatters.format(action);
        this.contents = contents;
    }

    public String getAction()
    {
        return action;
    }

    public String getContents()
    {
        return contents;
    }
}

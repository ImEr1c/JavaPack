package com.imer1c.impl.minecraft.chatting.text.tellraw.events.hover;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawComponentBase;
import com.imer1c.generator.formatter.Formatters;

public class TextHoverEvent implements IHoverEvent<ITextComponent[]> {
    private final String action;
    private final ITextComponent[] contents;

    public TextHoverEvent(ITellrawComponentBase.HoverEventType action, ITextComponent[] contents)
    {
        this.action = Formatters.format(action);
        this.contents = contents;
    }

    public ITextComponent[] getContents()
    {
        return contents;
    }

    public String getAction()
    {
        return action;
    }
}

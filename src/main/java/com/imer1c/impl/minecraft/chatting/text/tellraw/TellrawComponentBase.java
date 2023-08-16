package com.imer1c.impl.minecraft.chatting.text.tellraw;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawComponentBase;
import com.imer1c.impl.minecraft.chatting.text.TextComponent;
import com.imer1c.impl.minecraft.chatting.text.tellraw.events.ClickEvent;
import com.imer1c.impl.minecraft.chatting.text.tellraw.events.hover.HoverEvent;
import com.imer1c.impl.minecraft.chatting.text.tellraw.events.hover.IHoverEvent;
import com.imer1c.impl.minecraft.chatting.text.tellraw.events.hover.TextHoverEvent;

public class TellrawComponentBase extends TextComponent implements ITellrawComponentBase {

    private ClickEvent clickEvent;
    private IHoverEvent hoverEvent;

    public TellrawComponentBase(String text)
    {
        super(text);
    }

    @Override
    public void clickEvent(ClickEventType type, String value)
    {
        this.clickEvent = new ClickEvent(type, value);
    }

    @Override
    public void hoverEvent(ITextComponent... text)
    {
        this.hoverEvent = new TextHoverEvent(HoverEventType.SHOW_TEXT, text);
    }

    @Override
    public void hoverEvent(HoverEventType type, String value)
    {
        this.hoverEvent = new HoverEvent(type, value);
    }
}

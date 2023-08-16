package com.imer1c.impl.minecraft.chatting.text.tellraw;

import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawSelectorTextComponent;

public class TellrawSelectorTextComponent extends TellrawComponentBase implements ITellrawSelectorTextComponent {

    private final String selector;

    public TellrawSelectorTextComponent(String selector)
    {
        super(null);
        this.selector = selector;
    }
}

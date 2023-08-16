package com.imer1c.impl.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.ISelectorTextComponent;

public class SelectorTextComponent extends TextComponent implements ISelectorTextComponent {

    private final String selector;

    public SelectorTextComponent(String selector)
    {
        super(null);
        this.selector = selector;
    }
}

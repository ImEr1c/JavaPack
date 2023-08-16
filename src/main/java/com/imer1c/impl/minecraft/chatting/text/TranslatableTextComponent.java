package com.imer1c.impl.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.ITranslatableTextComponent;

public class TranslatableTextComponent extends TextComponent implements ITranslatableTextComponent {

    private final String translate;
    private String fallback;
    private String[] with;

    public TranslatableTextComponent(String translate)
    {
        super(null);
        this.translate = translate;
    }

    @Override
    public void fallback(String fallback)
    {
        this.fallback = fallback;
    }

    @Override
    public String getFallback()
    {
        return this.fallback;
    }

    @Override
    public void with(String... with)
    {
        this.with = with;
    }

    @Override
    public String[] getWith()
    {
        return this.with;
    }
}

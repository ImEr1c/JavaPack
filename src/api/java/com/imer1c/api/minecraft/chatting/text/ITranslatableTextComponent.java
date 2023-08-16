package com.imer1c.api.minecraft.chatting.text;

public interface ITranslatableTextComponent extends ITextComponent {
    void fallback(String fallback);

    String getFallback();

    void with(String... args);

    String[] getWith();
}

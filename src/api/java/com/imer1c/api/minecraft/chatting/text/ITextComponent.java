package com.imer1c.api.minecraft.chatting.text;

public interface ITextComponent {
    String getText();

    void color(TextComponentColor color);

    TextComponentColor getColor();

    void bold(boolean bold);

    boolean isBold();

    void italic(boolean italic);

    boolean isItalic();

    void underlined(boolean underlined);

    boolean isUnderlined();

    void strikethrough(boolean strikethrough);

    boolean isStrikethrough();

    void obfuscated(boolean obfuscated);

    boolean isObfuscated();

    //Font
}

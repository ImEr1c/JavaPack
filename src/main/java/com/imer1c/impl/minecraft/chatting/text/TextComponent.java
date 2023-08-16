package com.imer1c.impl.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.chatting.text.TextComponentColor;
import com.imer1c.generator.Generator;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.UnSetBoolean;

public class TextComponent implements ITextComponent {
    private final String text;
    private String color;
    private UnSetBoolean italic, bold, underlined, strikethrough, obfuscated;

    public TextComponent(String text)
    {
        this.text = text;
    }

    @Override
    public String getText()
    {
        return this.text;
    }

    @Override
    public void color(TextComponentColor color)
    {
        this.color = Formatters.format(color);
    }

    @Override
    public TextComponentColor getColor()
    {
        if (this.color == null)
        {
            return null;
        }

        return TextComponentColor.valueOf(this.color.toUpperCase());
    }

    @Override
    public void bold(boolean bold)
    {
        this.bold = new UnSetBoolean(bold);
    }

    @Override
    public boolean isBold()
    {
        return this.bold.value;
    }

    @Override
    public void italic(boolean italic)
    {
        this.italic = new UnSetBoolean(italic);
    }

    @Override
    public boolean isItalic()
    {
        return this.italic.value;
    }

    @Override
    public void underlined(boolean underlined)
    {
        this.underlined = new UnSetBoolean(underlined);
    }

    @Override
    public boolean isUnderlined()
    {
        return this.underlined.value;
    }

    @Override
    public void strikethrough(boolean strikethrough)
    {
        this.strikethrough = new UnSetBoolean(strikethrough);
    }

    @Override
    public boolean isStrikethrough()
    {
        return this.strikethrough.value;
    }

    @Override
    public void obfuscated(boolean obfuscated)
    {
        this.obfuscated = new UnSetBoolean(obfuscated);
    }

    @Override
    public boolean isObfuscated()
    {
        return this.obfuscated.value;
    }

    @Override
    public String toString()
    {
        return Generator.ONE_LINE_GSON.toJson(this);
    }
}

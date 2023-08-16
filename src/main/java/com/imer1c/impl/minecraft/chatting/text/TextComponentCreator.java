package com.imer1c.impl.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.*;
import com.imer1c.api.minecraft.chatting.text.tellraw.*;
import com.imer1c.impl.minecraft.chatting.text.tellraw.*;

public class TextComponentCreator implements ITextComponentCreator {

    @Override
    public ITextComponent text(String text)
    {
        return new TextComponent(text);
    }

    @Override
    public ITranslatableTextComponent translate(String translate)
    {
        return new TranslatableTextComponent(translate);
    }

    @Override
    public INBTTextComponent nbt(String nbt)
    {
        return new NBTTextComponent(nbt);
    }

    @Override
    public IScoreTextComponent score(IScoreTextComponent.Score score)
    {
        return new ScoreTextComponent(score);
    }

    @Override
    public ISelectorTextComponent selector(String selector)
    {
        return new SelectorTextComponent(selector);
    }

    @Override
    public IKeybindTextComponent keybind(String keybind)
    {
        return new KeybindTextComponent(keybind);
    }

    @Override
    public ITellrawComponentBase tellrawText(String text)
    {
        return new TellrawComponentBase(text);
    }

    @Override
    public ITellrawTranslatableTextComponent tellrawTranslate(String translate)
    {
        return new TellrawTranslatableTextComponent(translate);
    }

    @Override
    public ITellrawNBTTextComponent tellrawNBT(String nbt)
    {
        return new TellrawNBTTextComponent(nbt);
    }

    @Override
    public ITellrawScoreTextComponent tellrawScore(IScoreTextComponent.Score score)
    {
        return new TellrawScoreTextComponent(score);
    }

    @Override
    public ITellrawSelectorTextComponent tellrawSelector(String selector)
    {
        return new TellrawSelectorTextComponent(selector);
    }

    @Override
    public ITellrawKeybindTextComponent tellrawKeybind(String keybind)
    {
        return new TellrawKeybindTextComponent(keybind);
    }
}

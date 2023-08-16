package com.imer1c.api.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.tellraw.*;

public interface ITextComponentCreator {
    ITextComponent text(String text);

    ITranslatableTextComponent translate(String translate);

    INBTTextComponent nbt(String nbt);

    IScoreTextComponent score(IScoreTextComponent.Score score);

    default IScoreTextComponent score(String name, String objective) {
        return this.score(new IScoreTextComponent.Score(name, objective));
    }

    ISelectorTextComponent selector(String selector);

    IKeybindTextComponent keybind(String keybind);

    ITellrawComponentBase tellrawText(String text);

    ITellrawTranslatableTextComponent tellrawTranslate(String translate);

    ITellrawNBTTextComponent tellrawNBT(String nbt);

    ITellrawScoreTextComponent tellrawScore(IScoreTextComponent.Score score);

    default ITellrawScoreTextComponent tellrawScore(String name, String objective)
    {
        return this.tellrawScore(new IScoreTextComponent.Score(name, objective));
    }

    ITellrawSelectorTextComponent tellrawSelector(String selector);

    ITellrawKeybindTextComponent tellrawKeybind(String keybind);
}

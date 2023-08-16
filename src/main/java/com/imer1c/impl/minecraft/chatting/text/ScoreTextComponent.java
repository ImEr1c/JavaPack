package com.imer1c.impl.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.IScoreTextComponent;

public class ScoreTextComponent extends TextComponent implements IScoreTextComponent {

    private final Score score;

    public ScoreTextComponent(Score score)
    {
        super(null);
        this.score = score;
    }

    @Override
    public Score getScore()
    {
        return this.score;
    }
}

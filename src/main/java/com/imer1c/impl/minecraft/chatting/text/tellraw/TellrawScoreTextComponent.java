package com.imer1c.impl.minecraft.chatting.text.tellraw;

import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawScoreTextComponent;

public class TellrawScoreTextComponent extends TellrawComponentBase implements ITellrawScoreTextComponent {

    private final Score score;

    public TellrawScoreTextComponent(Score score)
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

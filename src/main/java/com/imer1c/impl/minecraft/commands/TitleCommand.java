package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.utils.Times;

public class TitleCommand extends AbstractCommand {

    private static final int CLEAR_INDEX = 0;
    private static final int RESET_INDEX = 1;
    private static final int TITLE_INDEX = 2;
    private static final int ACTIONBAR_INDEX = 3;
    private static final int SUBTITLE_INDEX = 4;
    private static final int TIMES_INDEX = 5;

    @Override
    public String getId()
    {
        return "title";
    }

    public void clear(IPlayer player)
    {
        this.write(CLEAR_INDEX, player);
    }

    public void reset(IPlayer player)
    {
        this.write(RESET_INDEX, player);
    }

    public void title(IPlayer player, ITextComponent component)
    {
        this.write(TITLE_INDEX, player, component);
    }

    public void actionbar(IPlayer player, ITextComponent component)
    {
        this.write(ACTIONBAR_INDEX, player, component);
    }

    public void subtitle(IPlayer player, ITextComponent component)
    {
        this.write(SUBTITLE_INDEX, player, component);
    }

    public void times(IPlayer player, Times fadeInTime, Times stayTime, Times fadeOutTime)
    {
        this.write(TIMES_INDEX, player, fadeInTime, stayTime, fadeOutTime);
    }
}

package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.world.bossbar.BossbarColor;
import com.imer1c.api.minecraft.world.bossbar.BossbarStyle;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.ValueImpl;

public class BossbarCommand extends AbstractCommand {

    private static final int ADD_INDEX = 0;
    private static final int REMOVE_INDEX = 1;
    private static final int GET_MAX_INDEX = 2;
    private static final int GET_PLAYERS_INDEX = 3;
    private static final int GET_VALUE_INDEX = 4;
    private static final int GET_VISIBLE_INDEX = 5;
    private static final int SET_COLOR_INDEX = 6;
    private static final int SET_MAX_INDEX = 7;
    private static final int SET_NAME_INDEX = 8;
    private static final int SET_PLAYERS_INDEX = 9;
    private static final int SET_STYLE_INDEX = 10;
    private static final int SET_VALUE_INDEX = 11;
    private static final int SET_VISIBLE_INDEX = 12;

    @Override
    public String getId()
    {
        return "bossbar";
    }

    public void add(String id, ITextComponent component)
    {
        this.write(ADD_INDEX, id, component);
    }

    public void remove(String id)
    {
        this.write(REMOVE_INDEX, id);
    }

    //GETTERS

    public void setColor(String id, BossbarColor color)
    {
        this.write(SET_COLOR_INDEX, id, Formatters.format(color));
    }

    public void setMax(String id, int max)
    {
        this.write(SET_MAX_INDEX, id, max);
    }

    public void setName(String id, ITextComponent name)
    {
        this.write(SET_NAME_INDEX, id, name);
    }

    public void setPlayers(String id, IPlayer player)
    {
        this.write(SET_PLAYERS_INDEX, id, player);
    }

    public void setStyle(String id, BossbarStyle style)
    {
        this.write(SET_STYLE_INDEX, id, Formatters.format(style));
    }

    public void setValue(String id, int value)
    {
        this.write(SET_VALUE_INDEX, id, value);
    }

    public void setVisible(String id, boolean visible)
    {
        this.write(SET_VISIBLE_INDEX, id, visible);
    }

    public ValueImpl getMax(String id)
    {
        return new ValueImpl(this.getCommand(GET_MAX_INDEX, id));
    }

    public ValueImpl getPlayersCount(String id)
    {
        return new ValueImpl(this.getCommand(GET_PLAYERS_INDEX, id));
    }

    public ValueImpl getValue(String id)
    {
        return new ValueImpl(this.getCommand(GET_VALUE_INDEX, id));
    }

    public ValueImpl isVisible(String id)
    {
        return new ValueImpl(this.getCommand(GET_VISIBLE_INDEX, id));
    }
}

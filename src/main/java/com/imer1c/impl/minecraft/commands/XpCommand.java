package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.utils.Utils;
import com.imer1c.utils.ValueImpl;

public class XpCommand extends AbstractCommand {

    private static final int ADD_POINTS_INDEX = 0;
    private static final int ADD_LEVELS_INDEX = 1;
    private static final int SET_POINTS_INDEX = 2;
    private static final int SET_LEVELS_INDEX = 3;
    private static final int QUERY_POINTS_INDEX = 4;
    private static final int QUERY_LEVELS_INDEX = 5;

    @Override
    public String getId()
    {
        return "xp";
    }

    public void addPoints(IPlayer player, int xp)
    {
        this.write(ADD_POINTS_INDEX, player, xp);
    }

    public void addLevels(IPlayer player, int levels)
    {
        this.write(ADD_LEVELS_INDEX, player, levels);
    }

    public void setPoints(IPlayer player, int xp)
    {
        this.write(SET_POINTS_INDEX, player, xp);
    }

    public void setLevels(IPlayer player, int levels)
    {
        this.write(SET_LEVELS_INDEX, player, levels);
    }

    public Value getLevels(IPlayer player)
    {
        return new ValueImpl(this.getCommand(QUERY_LEVELS_INDEX, Utils.checkForMultipleEntities(player)));
    }

    public Value getPoints(IPlayer player)
    {
        return new ValueImpl(this.getCommand(QUERY_POINTS_INDEX, Utils.checkForMultipleEntities(player)));
    }
}

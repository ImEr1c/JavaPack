package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.utils.ValueImpl;

public class ClearCommand extends AbstractCommand {

    private static final int CLEAR_ALL_INDEX = 0;
    private static final int CLEAR_ALL_ITEMS_INDEX = 1;
    private static final int CLEAR_ITEMS_COUNT_INDEX = 2;

    @Override
    public String getId()
    {
        return "clear";
    }

    public void clear(IPlayer player)
    {
        this.write(CLEAR_ALL_INDEX, player);
    }

    public void clear(IPlayer player, String itemId)
    {
        this.write(CLEAR_ALL_ITEMS_INDEX, player, itemId);
    }

    public void clear(IPlayer player, String itemId, int maxCount)
    {
        this.write(CLEAR_ITEMS_COUNT_INDEX, player, itemId, maxCount);
    }

    public Value detect(IPlayer player)
    {
        return new ValueImpl(this.getCommand(CLEAR_ALL_INDEX, player));
    }

    public Value detect(IPlayer player, String itemId)
    {
        return new ValueImpl(this.getCommand(CLEAR_ALL_ITEMS_INDEX, player, itemId));
    }

    public Value detect(IPlayer player, String itemId, int maxCount)
    {
        return new ValueImpl(this.getCommand(CLEAR_ITEMS_COUNT_INDEX, player, itemId, maxCount));
    }
}

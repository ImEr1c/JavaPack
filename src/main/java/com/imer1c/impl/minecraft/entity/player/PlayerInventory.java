package com.imer1c.impl.minecraft.entity.player;

import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.player.inventory.IPlayerInventory;
import com.imer1c.impl.minecraft.commands.CommandManager;

public class PlayerInventory implements IPlayerInventory {
    private final IPlayer player;

    public PlayerInventory(IPlayer player)
    {
        this.player = player;
    }

    @Override
    public void clear()
    {
        CommandManager.clear.clear(this.player);
    }

    @Override
    public void clear(String itemId)
    {
        CommandManager.clear.clear(this.player, itemId);
    }

    @Override
    public void clear(String itemId, int count)
    {
        CommandManager.clear.clear(this.player, itemId, count);
    }
}

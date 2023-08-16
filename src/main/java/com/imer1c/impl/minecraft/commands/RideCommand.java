package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.IPlayer;

public class RideCommand extends AbstractCommand {

    private static final int MOUNT_INDEX = 0;
    private static final int STOP_RIDING_INDEX = 1;

    @Override
    public String getId()
    {
        return "ride";
    }

    public void ride(IPlayer player, ILivingEntity entity)
    {
        this.write(MOUNT_INDEX, player, entity);
    }

    public void stopRiding(IPlayer player)
    {
        this.write(STOP_RIDING_INDEX, player);
    }
}

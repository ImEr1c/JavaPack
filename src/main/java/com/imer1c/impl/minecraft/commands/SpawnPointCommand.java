package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.generator.formatter.Formatters;

public class SpawnPointCommand extends AbstractCommand {

    private static final int NORMAL_INDEX = 0;
    private static final int POS_INDEX = 1;
    private static final int POS_AND_ANGLE_INDEX = 2;

    @Override
    public String getId()
    {
        return "spawnpoint";
    }

    public void setSpawnPoint(IPlayer player)
    {
        this.write(NORMAL_INDEX, player);
    }

    public void setSpawnPoint(IPlayer player, BlockPos pos)
    {
        this.write(POS_INDEX, player, Formatters.format(pos));
    }

    public void setSpawnPoint(IPlayer player, BlockPos pos, Angle angle)
    {
        this.write(POS_AND_ANGLE_INDEX, player, Formatters.format(pos),
                Formatters.format(angle));
    }
}

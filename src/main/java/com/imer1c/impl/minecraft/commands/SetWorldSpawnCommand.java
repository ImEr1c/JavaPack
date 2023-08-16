package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.generator.formatter.Formatters;

public class SetWorldSpawnCommand extends AbstractCommand {
    private static final int WITH_POS_INDEX = 0;
    private static final int POS_AND_ANGLE_INDEX = 1;

    @Override
    public String getId()
    {
        return "setworldspawn";
    }

    public void setWorldSpawn(BlockPos pos)
    {
        this.write(WITH_POS_INDEX,
                Formatters.format(pos));
    }

    public void setWorldSpawn(BlockPos pos, Angle angle)
    {
        this.write(POS_AND_ANGLE_INDEX,
                Formatters.format(pos),
                Formatters.format(angle));
    }
}

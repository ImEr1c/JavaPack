package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.EntityAnchor;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.Rotation;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.pos.Vec3;
import com.imer1c.generator.formatter.Formatters;

public class TeleportCommand extends AbstractCommand {

    private static final int ENTITY_TO_ENTITY_INDEX = 0;
    private static final int ENTITY_TO_POS_INDEX = 1;
    private static final int ENTITY_TO_POS_WITH_ROTATION_INDEX = 2;
    private static final int ENTITY_TO_POS_WITH_FACING_INDEX = 3;
    private static final int ENTITY_TO_POS_WITH_FACING_ENTITY_INDEX = 4;

    @Override
    public String getId()
    {
        return "tp";
    }

    public void tp(ILivingEntity from, ILivingEntity to)
    {
        this.write(ENTITY_TO_ENTITY_INDEX, from, to);
    }

    public void tp(ILivingEntity entity, BlockPos pos)
    {
        this.write(ENTITY_TO_POS_INDEX, entity, pos);
    }

    public void tp(ILivingEntity entity, BlockPos pos, Rotation rotation)
    {
        this.write(ENTITY_TO_POS_WITH_ROTATION_INDEX, entity, pos, Formatters.format(rotation));
    }

    public void tp(ILivingEntity entity, BlockPos pos, Vec3 facing)
    {
        this.write(ENTITY_TO_POS_WITH_FACING_INDEX, entity, pos, facing);
    }

    public void tp(ILivingEntity entity, BlockPos pos, ILivingEntity facingEntity, EntityAnchor anchor)
    {
        this.write(ENTITY_TO_POS_WITH_FACING_ENTITY_INDEX, entity, pos, facingEntity, Formatters.format(anchor));
    }
}

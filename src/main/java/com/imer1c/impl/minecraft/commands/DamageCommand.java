package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.world.DamageType;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.Utils;

public class DamageCommand extends AbstractCommand {
    private static final int NORMAL_INDEX = 0;
    private static final int DAMAGE_WITH_TYPE_INDEX = 1;
    private static final int DAMAGE_AT_LOCATION_INDEX = 2;
    private static final int DAMAGE_BY_ENTITY_INDEX = 3;
    private static final int DAMAGE_WITH_CAUSE_INDEX = 4;

    @Override
    public String getId()
    {
        return "damage";
    }

    public void normal(ILivingEntity target, float damage)
    {
        this.write(NORMAL_INDEX, Utils.checkForMultipleEntities(target), damage);
    }

    public void withType(ILivingEntity target, float damage, DamageType damageType)
    {
        this.write(DAMAGE_WITH_TYPE_INDEX, Utils.checkForMultipleEntities(target),
                damage, Formatters.format(damageType));
    }

    public void atLocation(ILivingEntity target, float damage, DamageType damageType, BlockPos pos)
    {
        this.write(DAMAGE_AT_LOCATION_INDEX, Utils.checkForMultipleEntities(target),
                damage, Formatters.format(damageType), Formatters.format(pos));
    }

    public void byEntity(ILivingEntity target, float damage, DamageType damageType, ILivingEntity entity)
    {
        this.write(DAMAGE_BY_ENTITY_INDEX, Utils.checkForMultipleEntities(target),
                damage, Formatters.format(damageType), Utils.checkForMultipleEntities(entity));
    }

    public void byEntityWithCause(ILivingEntity target, float damage, DamageType damageType, ILivingEntity entity, ILivingEntity cause)
    {
        this.write(DAMAGE_WITH_CAUSE_INDEX, Utils.checkForMultipleEntities(target),
                damage, Formatters.format(damageType), Utils.checkForMultipleEntities(entity),
                Utils.checkForMultipleEntities(cause));
    }
}

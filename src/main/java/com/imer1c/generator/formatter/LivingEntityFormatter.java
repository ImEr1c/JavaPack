package com.imer1c.generator.formatter;

import com.imer1c.impl.minecraft.entity.LivingEntity;

public class LivingEntityFormatter implements IFormatter<LivingEntity> {
    @Override
    public String format(LivingEntity livingEntity)
    {
        if (livingEntity.getTarget() != null)
        {
            return livingEntity.getTarget().toString();
        }
        else if (livingEntity.getUuid() != null)
        {
            return livingEntity.getUuid().toString();
        }

        return null;
    }
}

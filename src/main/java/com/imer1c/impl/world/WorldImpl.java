package com.imer1c.impl.world;

import com.imer1c.api.minecraft.entity.target.Target;
import com.imer1c.api.minecraft.world.World;
import com.imer1c.impl.entity.TargetSelector;

public class WorldImpl implements World {
    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector target(Target target)
    {
        return new TargetSelector(target);
    }
}

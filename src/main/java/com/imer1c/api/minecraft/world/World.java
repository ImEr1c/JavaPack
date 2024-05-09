package com.imer1c.api.minecraft.world;

import com.imer1c.api.minecraft.entity.target.Target;
import com.imer1c.api.minecraft.entity.target.TargetSelector;

public interface World {

    /**
     * Create a TargetSelector builder for the given target
     * @return TargetSelector
     */
    TargetSelector target(Target target);

}

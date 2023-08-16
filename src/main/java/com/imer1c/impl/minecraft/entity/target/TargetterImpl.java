package com.imer1c.impl.minecraft.entity.target;

import com.imer1c.api.minecraft.entity.target.Target;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.entity.target.Targetter;

public class TargetterImpl implements Targetter {
    @Override
    public TargetSelector select(Target target)
    {
        return new TargetSelectorImpl(target);
    }
}

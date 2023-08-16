package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.utils.ValueImpl;

public class KillCommand extends AbstractCommand {
    @Override
    public String getId()
    {
        return "kill";
    }

    public void kill(ILivingEntity entity)
    {
        this.write(0, entity);
    }

    public Value killAndCount(ILivingEntity entity)
    {
        return new ValueImpl(this.getCommand(0, entity));
    }
}

package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.utils.ValueImpl;

public class TagCommand extends AbstractCommand {

    private static final int ADD_INDEX = 0;
    private static final int LIST_INDEX = 1;
    private static final int REMOVE_INDEX = 2;

    @Override
    public String getId()
    {
        return "tag";
    }

    public void add(ILivingEntity entity, String tag)
    {
        this.write(ADD_INDEX, entity, tag);
    }

    public Value count(ILivingEntity entity)
    {
        return new ValueImpl(this.getCommand(LIST_INDEX, entity));
    }

    public void remove(ILivingEntity entity, String tag)
    {
        this.write(REMOVE_INDEX, entity, tag);
    }
}

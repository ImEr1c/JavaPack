package com.imer1c.impl.minecraft.chatting.text.tellraw;

import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawNBTTextComponent;
import com.imer1c.utils.UnSetBoolean;

public class TellrawNBTTextComponent extends TellrawComponentBase implements ITellrawNBTTextComponent {

    private final String nbt;
    private String entity, block, storage;
    private UnSetBoolean interpret;

    public TellrawNBTTextComponent(String nbt)
    {
        super(null);
        this.nbt = nbt;
    }

    @Override
    public void entity(String entity)
    {
        this.checkAndThrowException();
        this.entity = entity;
    }

    @Override
    public String getEntity()
    {
        return this.entity;
    }

    @Override
    public void blockCoordinates(String blockCoordinates)
    {
        this.checkAndThrowException();
        this.block = blockCoordinates;
    }

    @Override
    public String getBlockCoordinates()
    {
        return this.block;
    }

    @Override
    public void storage(String storage)
    {
        this.checkAndThrowException();
        this.storage = storage;
    }

    @Override
    public String getStorage()
    {
        return this.storage;
    }

    @Override
    public void interpret(boolean interpret)
    {
        this.interpret = new UnSetBoolean(interpret);
    }

    @Override
    public boolean isInterpreting()
    {
        return this.interpret.value;
    }

    private void checkAndThrowException() {
        if (this.entity != null || this.block != null || this.storage != null)
        {
            throw new RuntimeException("Can only have values for one of the three: Entity, Block or Storage");
        }
    }
}

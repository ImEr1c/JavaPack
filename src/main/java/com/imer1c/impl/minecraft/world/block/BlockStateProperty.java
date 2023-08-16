package com.imer1c.impl.minecraft.world.block;

public class BlockStateProperty<B> {
    protected final String id;
    private B value;

    public BlockStateProperty(String id)
    {
        this.id = id;
    }

    public void setValue(B value)
    {
        this.value = value;
    }

    public B getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return String.format("%s=%s", this.id, this.value);
    }
}

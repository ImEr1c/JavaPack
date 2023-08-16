package com.imer1c.impl.minecraft.world.block;

public class IntegerBlockStateProperty extends BlockStateProperty<Integer> {

    private final int min, max;

    public IntegerBlockStateProperty(String id, int min, int max)
    {
        super(id);
        this.min = min;
        this.max = max;
    }

    @Override
    public void setValue(Integer value)
    {
        if (value < this.min || value > this.max)
        {
            throw new IllegalArgumentException("Integer value must be between " + this.min + " and "  + this.max + " for block property " + this.id);
        }

        super.setValue(value);
    }
}

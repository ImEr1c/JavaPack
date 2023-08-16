package com.imer1c.impl.minecraft.world.block;

public class IntegerBlockStatePropertyHandler extends BlockPropertyHandler<Integer> {

    private final int min, max;

    public IntegerBlockStatePropertyHandler(String id, int min, int max)
    {
        super(id);
        this.min = min;
        this.max = max;
    }

    @Override
    public BlockStateProperty<Integer> create()
    {
        return new IntegerBlockStateProperty(this.getId(), this.min, this.max);
    }
}

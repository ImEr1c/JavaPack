package com.imer1c.impl.minecraft.world.block;

import com.imer1c.api.minecraft.world.block.IBlockPropertyHandler;

public class BlockPropertyHandler<B> implements IBlockPropertyHandler<B> {
    private final String id;

    public BlockPropertyHandler(String id)
    {
        this.id = id;
    }

    public BlockStateProperty<B> create()
    {
        return new BlockStateProperty<>(this.id);
    }

    public String getId()
    {
        return id;
    }
}

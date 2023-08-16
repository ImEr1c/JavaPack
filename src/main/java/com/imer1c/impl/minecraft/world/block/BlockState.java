package com.imer1c.impl.minecraft.world.block;

import com.imer1c.api.minecraft.world.block.IBlockState;
import com.imer1c.api.minecraft.world.block.IBlockPropertyHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockState implements IBlockState {

    private final Map<String, BlockStateProperty<?>> properties = new HashMap<>();
    private final Block block;

    public BlockState(Block block)
    {
        this.block = block;
    }

    @Override
    public <B> IBlockState withProperty(IBlockPropertyHandler<B> property, B value)
    {
        BlockPropertyHandler<B> propertyHandler = (BlockPropertyHandler<B>) property;
        String id = propertyHandler.getId();

        if (!this.block.containsProperty(property))
        {
            throw new IllegalArgumentException("Block " + this.block.getId() + " does not contain the property " + id);
        }

        if (this.properties.containsKey(id))
        {
            throw new IllegalArgumentException("Property " + id + " is already implemented");
        }

        BlockStateProperty<B> prop = propertyHandler.create();
        prop.setValue(value);
        this.properties.put(id, prop);

        return this;
    }

    public <B> B getValue(IBlockPropertyHandler<B> property)
    {
        BlockPropertyHandler<B> propertyHandler = (BlockPropertyHandler<B>) property;

        return (B) this.properties.get(propertyHandler.getId()).getValue();
    }
}

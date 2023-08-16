package com.imer1c.impl.minecraft.world.block;

import com.imer1c.api.minecraft.utils.ResourceLocation;
import com.imer1c.api.minecraft.world.block.IBlockPropertyHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Block implements com.imer1c.api.minecraft.world.block.Block {
    private final List<IBlockPropertyHandler<?>> properties = new ArrayList<>();
    private final ResourceLocation id;

    public Block(String id)
    {
        this(ResourceLocation.minecraft(id));
    }

    public Block(ResourceLocation id)
    {
        this.id = id;
        this.addBlockProperties(propertyHandlers -> Collections.addAll(this.properties, propertyHandlers));
    }

    public ResourceLocation getId()
    {
        return id;
    }

    public List<IBlockPropertyHandler<?>> getProperties()
    {
        return properties;
    }

    public boolean containsProperty(IBlockPropertyHandler<?> property)
    {
        return this.properties.contains(property);
    }

    public void addBlockProperties(Consumer<IBlockPropertyHandler<?>[]> consumer)
    {
    }
}

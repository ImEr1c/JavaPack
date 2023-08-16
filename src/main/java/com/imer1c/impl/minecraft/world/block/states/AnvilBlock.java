package com.imer1c.impl.minecraft.world.block.states;

import com.imer1c.api.minecraft.utils.ResourceLocation;
import com.imer1c.api.minecraft.world.block.IBlockPropertyHandler;
import com.imer1c.impl.minecraft.world.block.Block;
import com.imer1c.impl.minecraft.world.block.BlockStateProperties;

import java.util.function.Consumer;

public class AnvilBlock extends Block {
    public AnvilBlock(String id)
    {
        super(id);
    }

    public AnvilBlock(ResourceLocation id)
    {
        super(id);
    }

    @Override
    public void addBlockProperties(Consumer<IBlockPropertyHandler<?>[]> consumer)
    {
        consumer.accept(new IBlockPropertyHandler[]{BlockStateProperties.HORIZONTAL_FACING});
    }
}

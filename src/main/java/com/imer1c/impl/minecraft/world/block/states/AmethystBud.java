package com.imer1c.impl.minecraft.world.block.states;

import com.imer1c.api.minecraft.utils.ResourceLocation;
import com.imer1c.api.minecraft.world.block.IBlockPropertyHandler;
import com.imer1c.impl.minecraft.world.block.Block;
import com.imer1c.impl.minecraft.world.block.BlockPropertyHandler;
import com.imer1c.impl.minecraft.world.block.BlockStateProperties;

import java.util.function.Consumer;

public class AmethystBud extends Block {
    public AmethystBud(String id)
    {
        super(id);
    }

    public AmethystBud(ResourceLocation id)
    {
        super(id);
    }

    @Override
    public void addBlockProperties(Consumer<IBlockPropertyHandler<?>[]> consumer)
    {
        consumer.accept(new IBlockPropertyHandler[]{BlockStateProperties.FACING, BlockStateProperties.WATERLOGGED});
    }
}

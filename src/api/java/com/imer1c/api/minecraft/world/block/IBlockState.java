package com.imer1c.api.minecraft.world.block;

public interface IBlockState {
    <B> IBlockState withProperty(IBlockPropertyHandler<B> property, B value);
}

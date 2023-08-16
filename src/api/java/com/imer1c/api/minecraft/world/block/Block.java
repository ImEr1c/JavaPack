package com.imer1c.api.minecraft.world.block;

import java.util.List;

public interface Block {
    List<IBlockPropertyHandler<?>> getProperties();

    boolean containsProperty(IBlockPropertyHandler<?> property);
}

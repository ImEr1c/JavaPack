package com.imer1c.api;

import com.imer1c.api.minecraft.world.block.Block;
import com.imer1c.api.minecraft.world.block.IBlockPropertyHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class APIData {
    private static final Map<String, Object> data = new HashMap<>();

    public static void registerData(String s, Object o)
    {
        data.put(s, o);
    }

    public static <T> T get(String s)
    {
        return (T) data.get(s);
    }

    public static Block getBlock(String s, IBlockPropertyHandler<?>... propertyHandlers)
    {
        return ((BiFunction<String, IBlockPropertyHandler<?>[], Block>)data.get("block_builder")).apply(s, propertyHandlers);
    }
}

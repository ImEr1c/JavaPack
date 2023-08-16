package com.imer1c.generator.data;

import com.imer1c.api.minecraft.utils.ResourceLocation;

import java.util.Arrays;

public class TagFunction {
    private final String[] values;

    public TagFunction(ResourceLocation... values)
    {
        this.values = Arrays.asList(values).stream().map(ResourceLocation::toString).toArray(String[]::new);
    }
}

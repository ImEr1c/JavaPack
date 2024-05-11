package com.imer1c.impl.util;

public class MinecraftTag {
    private final boolean replace;
    private final String[] values;

    public MinecraftTag(boolean replace, String[] values)
    {
        this.replace = replace;
        this.values = values;
    }

    public String[] getValues()
    {
        return values;
    }

    public boolean isReplace()
    {
        return replace;
    }
}

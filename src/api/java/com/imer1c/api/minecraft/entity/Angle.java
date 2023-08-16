package com.imer1c.api.minecraft.entity;

public class Angle {
    private final float value;
    private final boolean relative;

    private Angle(float value, boolean relative)
    {
        this.value = value;
        this.relative = relative;
    }

    public static Angle relative(float value)
    {
        return new Angle(value, true);
    }

    public static Angle absolute(float value)
    {
        return new Angle(value, false);
    }

    public float getValue()
    {
        return value;
    }

    public boolean isRelative()
    {
        return relative;
    }
}

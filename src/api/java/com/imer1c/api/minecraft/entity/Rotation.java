package com.imer1c.api.minecraft.entity;

public class Rotation {
    private final float yaw;
    private final float pitch;
    private final boolean relative;

    public Rotation(float yaw, float pitch, boolean relative)
    {
        this.yaw = yaw;
        this.pitch = pitch;
        this.relative = relative;
    }

    public static Rotation absolute(float yaw, float pitch)
    {
        return new Rotation(yaw, pitch, false);
    }

    public static Rotation relative(float yaw, float pitch)
    {
        return new Rotation(yaw, pitch, true);
    }

    public boolean isRelative()
    {
        return relative;
    }

    public float getYaw()
    {
        return yaw;
    }

    public float getPitch()
    {
        return pitch;
    }
}

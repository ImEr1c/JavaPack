package com.imer1c.api.minecraft.world.pos;

public class Vec2 {
    private final float x;
    private final float z;
    private final boolean relative, vector;

    private Vec2(float x, float z, boolean relative, boolean vector)
    {
        this.x = x;
        this.z = z;
        this.relative = relative;
        this.vector = vector;
    }

    public static Vec2 relative(float x, float z)
    {
        return new Vec2(x, z, true, false);
    }

    public static Vec2 relativeVector(float x, float z)
    {
        return new Vec2(x, z, true, true);
    }

    public static Vec2 vector(float x, float z)
    {
        return new Vec2(x, z, false, true);
    }

    public float getX()
    {
        return x;
    }

    public float getZ()
    {
        return z;
    }

    public boolean isVector()
    {
        return vector;
    }

    public boolean isRelative()
    {
        return relative;
    }
}

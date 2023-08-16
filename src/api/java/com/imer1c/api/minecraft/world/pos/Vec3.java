package com.imer1c.api.minecraft.world.pos;

public class Vec3 {
    private final double x;
    private final double y;
    private final double z;
    private boolean relative, vector;

    private Vec3(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vec3 relative(double x, double y, double z)
    {
        Vec3 pos = new Vec3(x, y, z);
        pos.relative = true;
        return pos;
    }

    public static Vec3 vector(double x, double y, double z)
    {
        Vec3 pos = new Vec3(x, y, z);
        pos.vector = true;
        return pos;
    }

    public static Vec3 vectorRelative(double x, double y, double z)
    {
        Vec3 pos = new Vec3(x, y, z);
        pos.vector = true;
        pos.relative = true;
        return pos;
    }

    public void setRelative(boolean relative)
    {
        this.relative = relative;
    }

    public void setVector(boolean vector)
    {
        this.vector = vector;
    }

    public boolean isRelative()
    {
        return relative;
    }

    public boolean isVector()
    {
        return vector;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }
}

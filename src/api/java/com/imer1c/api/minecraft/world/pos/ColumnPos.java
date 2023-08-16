package com.imer1c.api.minecraft.world.pos;

public class ColumnPos {
    private final int x;
    private final int z;
    private final boolean relative;

    private ColumnPos(int x, int z, boolean relative)
    {
        this.x = x;
        this.z = z;
        this.relative = relative;
    }

    public static ColumnPos relative(int x, int y)
    {
        return new ColumnPos(x, y, true);
    }

    public static ColumnPos absolute(int x, int y)
    {
        return new ColumnPos(x, y, false);
    }

    public boolean isRelative()
    {
        return relative;
    }

    public int getX()
    {
        return x;
    }

    public int getZ()
    {
        return z;
    }
}

package com.imer1c.api.minecraft.world.pos;

import com.imer1c.api.APIData;

public class BlockPos {
    private final int x;
    private final int y;
    private final int z;
    private boolean relative, vector;

    private BlockPos(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static BlockPos relative(int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        pos.relative = true;
        return pos;
    }

    public static BlockPos vector(int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        pos.vector = true;
        return pos;
    }

    public static BlockPos vectorRelative(int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
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

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }
}

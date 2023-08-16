package com.imer1c.utils;

public class FixedRange {
    private final int min;
    private final int max;

    public FixedRange(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    public int getMin()
    {
        return min;
    }

    public int getMax()
    {
        return max;
    }

    @Override
    public String toString()
    {
        if (this.min == 0)
        {
            return ".." + this.max;
        }

        if (this.max == 0)
        {
            return this.min + "..";
        }

        return this.min + ".." + this.max;
    }
}

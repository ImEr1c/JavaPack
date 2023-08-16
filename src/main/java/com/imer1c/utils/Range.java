package com.imer1c.utils;

public class Range {
    private final double min;
    private final double max;

    public Range(double min, double max)
    {
        this.min = min;
        this.max = max;
    }

    public double getMin()
    {
        return min;
    }

    public double getMax()
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

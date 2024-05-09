package com.imer1c.api.util;

/**
 * Represents a range of values
 * Used in distances, rotations and much more.
 */
public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    public int getMin()
    {
        return this.min;
    }

    public int getMax()
    {
        return this.max;
    }

    @Override
    public String toString()
    {
        if (this.min == this.max)
        {
            return String.valueOf(this.min);
        }

        return this.min + ".." + this.max;
    }

    public static Range of(int min, int max)
    {
        return new Range(min, max);
    }
}

package com.imer1c.generator.data.events.advancement.breed.data;

public class AdvancementRange {
    private final int min, max;

    public AdvancementRange(int min, int max)
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
}

package com.imer1c.api.minecraft.utils;

public class Times {
    private final MinecraftTimeUnit timeUnit;
    private final int time;

    public Times(MinecraftTimeUnit timeUnit, int time)
    {
        this.timeUnit = timeUnit;
        this.time = time;
    }

    public int getTime()
    {
        return time;
    }

    public MinecraftTimeUnit getTimeUnit()
    {
        return timeUnit;
    }
}

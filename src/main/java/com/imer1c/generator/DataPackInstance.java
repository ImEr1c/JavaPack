package com.imer1c.generator;

public class DataPackInstance {
    private final String name;
    private final String description;
    private final int format;

    public DataPackInstance(String name, String description, int format)
    {
        this.name = name;
        this.description = description;
        this.format = format;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getFormat()
    {
        return format;
    }
}

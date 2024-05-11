package com.imer1c.generator;

import java.util.Map;

public class DataPackInstance {
    private final String name;
    private final String description;
    private final int format;
    private final String mainPath;
    private Map<Class<?>, Object> eventClasses;

    public DataPackInstance(String name, String description, int format, String mainPath)
    {
        this.name = name;
        this.description = description;
        this.format = format;
        this.mainPath = mainPath;
    }

    public void setEventClasses(Map<Class<?>, Object> eventClasses)
    {
        this.eventClasses = eventClasses;
    }

    public Map<Class<?>, Object> getEventClasses()
    {
        return eventClasses;
    }

    public String getMainPath()
    {
        return mainPath;
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

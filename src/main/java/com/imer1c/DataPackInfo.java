package com.imer1c;

public class DataPackInfo {
    private final String name, description, main;
    private final int version;

    public DataPackInfo(String name, String description, String main, int version)
    {
        this.name = name;
        this.description = description;
        this.main = main;
        this.version = version;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getMain()
    {
        return main;
    }

    public int getVersion()
    {
        return version;
    }
}

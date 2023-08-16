package com.imer1c;

import com.imer1c.api.JavaDataPack;
import com.imer1c.api.minecraft.IServer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataPack {
    private final Map<String, File> idToPath = new HashMap<>();
    private final DataPackEventListener eventListener;
    private final String name;
    private final String description;
    private final String id;
    private final int version;
    private final JavaDataPack javaDataPack;
    private final JavaPackWriter writer;
    private File path;

    public DataPack(String name, String description, String id, int version, JavaDataPack javaDataPack)
    {
        this.name = name;
        this.description = description;
        this.id = id;
        this.version = version;
        this.javaDataPack = javaDataPack;
        this.writer = new JavaPackWriter(this);
        this.eventListener = new DataPackEventListener();
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public int getVersion()
    {
        return version;
    }

    public JavaDataPack getJavaDataPack()
    {
        return javaDataPack;
    }

    public void putPathData(String id, File path)
    {
        this.idToPath.put(id, path);
    }

    public File getPathById(String id)
    {
        return this.idToPath.get(id);
    }

    public IServer getServer()
    {
        return this.javaDataPack.getServer();
    }

    public JavaPackWriter getWriter()
    {
        return writer;
    }

    public void setPath(File path)
    {
        this.path = path;
    }

    public File getPath()
    {
        return path;
    }

    public DataPackEventListener getEventListener()
    {
        return eventListener;
    }
}

package com.imer1c.generator;

import com.imer1c.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataPackGenerator {
    private final DataPackInstance instance;
    private final File folder;

    public DataPackGenerator(DataPackInstance instance, File folder)
    {
        this.instance = instance;
        this.folder = new File(folder, instance.getName());
    }

    public void generate()
    {
        this.generatePackMeta();


    }

    private void generateMinecraftHooks(boolean setup, boolean tick)
    {

    }

    private void generateFunctions()
    {
        
    }

    private void generatePackMeta()
    {
        File packMcMeta = new File(this.folder, "pack.mcmeta");

        try
        {
            PackMeta meta = PackMeta.generateMetaData(this.instance);

            FileWriter writer = new FileWriter(packMcMeta);
            Constants.PRETTY_GSON.toJson(meta, writer);
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

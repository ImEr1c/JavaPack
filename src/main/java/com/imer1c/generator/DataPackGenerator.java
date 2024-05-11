package com.imer1c.generator;

import com.imer1c.Constants;
import com.imer1c.api.annotation.EventClass;
import com.imer1c.api.annotation.EventListener;
import com.imer1c.api.events.EventType;
import com.imer1c.util.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataPackGenerator {
    private final DataPackInstance instance;
    private final File folder;
    private FileWriter writer;
    private boolean setup, tick;

    public DataPackGenerator(DataPackInstance instance, File folder)
    {
        this.instance = instance;
        this.folder = new File(folder, instance.getName());
    }

    public void generate()
    {
        this.generatePackMeta();
        this.generateFunctions();
        this.generateMinecraftHooks();
    }

    private void generateMinecraftHooks()
    {
        File tagFunctions = new File(this.folder, Constants.MINECRAFT_TAG_FUNCTIONS_FOLDER);

        if (this.setup)
        {

        }
    }

    private void generateFunctions()
    {
        String mainPath = this.instance.getMainPath();
        File functionsFolder = new File(this.folder, "data/" + this.instance.getName() + "/functions");

        this.instance.getEventClasses().forEach((c, instance) -> {
            Method[] methods = c.getDeclaredMethods();
            EventClass ann = c.getAnnotation(EventClass.class);
            String classPath = ann.path();

            for (Method method : methods)
            {
                if (method.isAnnotationPresent(EventListener.class))
                {
                    EventListener annotation = method.getAnnotation(EventListener.class);
                    EventType type = annotation.value();

                    if (type == EventType.TICK)
                    {
                        this.tick = true;
                    }
                    else if (type == EventType.SETUP)
                    {
                        this.setup = true;
                    }

                    File folder = new File(functionsFolder, classPath.isEmpty() ? c.getName().replace(mainPath + ".", "").replace(".", "/") : classPath);
                    Utils.checkFolderExistance(folder);

                    File f = new File(folder, Utils.camelToSnake(method.getName()) + ".mcfunction");

                    try
                    {
                        if (this.writer != null)
                        {
                            this.writer.close();
                        }

                        this.writer = new FileWriter(f);

                        method.invoke(instance);
                    }
                    catch (InvocationTargetException | IllegalAccessException | IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    public void writeFunc(String s)
    {
        try
        {
            this.writer.write(s);
            this.writer.write("\n");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void generatePackMeta()
    {
        File packMcMeta = new File(this.folder, "pack.mcmeta");
        Utils.checkParent(packMcMeta);

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

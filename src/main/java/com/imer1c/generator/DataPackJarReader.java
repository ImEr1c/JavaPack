package com.imer1c.generator;

import com.imer1c.api.JavaDataPack;
import com.imer1c.api.annotation.DataPack;
import com.imer1c.api.annotation.EventClass;
import com.imer1c.api.exceptions.DataPackException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class DataPackJarReader {

    private final File jarFile;

    public DataPackJarReader(File jarFile)
    {
        this.jarFile = jarFile;
    }

    public DataPackInstance read()
    {

        Map<Class<?>, Object> eventClasses = new HashMap<>();
        DataPackInstance instance = null;

        try (JarFile jar = new JarFile(this.jarFile))
        {
            Enumeration<JarEntry> entries = jar.entries();

            URLClassLoader classLoader = new URLClassLoader(new URL[]{this.jarFile.toURI().toURL()});

            while (entries.hasMoreElements())
            {
                JarEntry jarEntry = entries.nextElement();

                if (jarEntry.isDirectory())
                {
                    continue;
                }

                String className = jarEntry.getName();

                if (!className.endsWith(".class"))
                {
                    continue;
                }

                className = className.substring(0, className.length() - 6).replace("/", ".");

                Class<?> c = classLoader.loadClass(className);

                if (JavaDataPack.class.isAssignableFrom(c))
                {
                    instance = handleJavaPackClass(c);
                }

                if (c.isAnnotationPresent(EventClass.class))
                {
                    eventClasses.put(c, c.getConstructor().newInstance());
                }
            }
        }
        catch (IOException | ClassNotFoundException | InvocationTargetException | InstantiationException |
               IllegalAccessException | NoSuchMethodException e)
        {
            throw new RuntimeException(e);
        }

        instance.setEventClasses(eventClasses);

        return instance;
    }

    private DataPackInstance handleJavaPackClass(Class<?> c)
    {
        if (!c.isAnnotationPresent(DataPack.class))
        {
            throw new DataPackException("DataPack annotation not present");
        }

        DataPack dataPack = c.getAnnotation(DataPack.class);

        return new DataPackInstance(dataPack.id(), dataPack.description(), dataPack.version(), c.getPackageName());
    }
}

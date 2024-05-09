package com.imer1c.generator;

import com.imer1c.api.JavaDataPack;
import com.imer1c.api.annotation.DataPack;
import com.imer1c.api.exceptions.DataPackException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class DataPackCompiler {

    private final File jarFile;

    public DataPackCompiler(File jarFile)
    {
        this.jarFile = jarFile;
    }

    public void compile(File jarFile)
    {
        try
        {
            JarFile jar = new JarFile(jarFile);
            Enumeration<JarEntry> entries = jar.entries();

            URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()});

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
                    if (!c.isAnnotationPresent(DataPack.class))
                    {
                        throw new DataPackException("DataPack annotation not present");
                    }

                    DataPack dataPack = c.getAnnotation(DataPack.class);
                }
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}

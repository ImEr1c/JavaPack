package com.imer1c;

import com.imer1c.api.JavaDataPack;
import com.imer1c.api.annotations.DataPackMain;
import com.imer1c.api.minecraft.IServer;
import com.imer1c.generator.Generator;
import com.imer1c.impl.minecraft.Server;
import com.imer1c.utils.Utils;
import com.imer1c.utils.VersionLimitUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarReader {
    public static DataPack read(File f) throws IOException, ClassNotFoundException
    {
        JarFile jar = new JarFile(f);

        URLClassLoader classLoader = new URLClassLoader(new URL[]{new URL("jar:file:" + f.getPath() + "!/")});

        Iterator<JarEntry> iter = jar.entries().asIterator();

        DataPack dataPack = null;

        while (iter.hasNext())
        {
            JarEntry entry = iter.next();

            String name = entry.getName();

            if (name.equals("dp.json"))
            {
                InputStream inputStream = jar.getInputStream(entry);

                String json = new String(inputStream.readAllBytes());

                DataPackInfo info = Generator.GSON.fromJson(json, DataPackInfo.class);

                VersionLimitUtils.setVersion(info.getVersion());

                Class<?> c = classLoader.loadClass(info.getMain());

                try
                {
                    dataPack = readMainClass(c, info);
                }
                catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                       IllegalAccessException | NoSuchFieldException e)
                {
                    throw new RuntimeException(e);
                }

                break;
            }
        }

        if (dataPack == null)
        {
            throw new RuntimeException("Couldn't find a class that has the DataPackInfo annotation");
        }

        return dataPack;
    }

    private static DataPack readMainClass(Class<?> c, DataPackInfo info) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException
    {
        if (!Utils.isClassExtending(c, JavaDataPack.class))
        {
            throw new RuntimeException("Class " + c + " has the DataPackInfo annotation but isn't extending the " + JavaDataPack.class);
        }

        JavaDataPack javaDataPack = (JavaDataPack) c.getConstructor().newInstance();
        setupDataPack(javaDataPack);

        DataPackMain annotation = c.getAnnotation(DataPackMain.class);

        String name = info.getName();
        String id = annotation.id();
        String description = info.getDescription();
        int version = info.getVersion();

        return new DataPack(name, description, id, version, javaDataPack);
    }

    private static void setupDataPack(JavaDataPack pack) throws NoSuchFieldException, IllegalAccessException
    {
        IServer server = new Server();

        Field field = JavaDataPack.class.getDeclaredField("server");
        field.setAccessible(true);
        field.set(pack, server);

        pack.onSetup();
    }
}

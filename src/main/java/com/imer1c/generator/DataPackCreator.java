package com.imer1c.generator;

import com.imer1c.Constants;

import java.io.File;
import java.io.FileWriter;

public class DataPackCreator {
    private static DataPackGenerator generator;

    public static void init(File f)
    {
        DataPackInstance instance = new DataPackJarReader(f).read();

        generator = new DataPackGenerator(instance, Constants.OUT_FOLDER);
        generator.generate();
    }

    public static void writeFunction(String s)
    {
        generator.writeFunc(s);
    }
}

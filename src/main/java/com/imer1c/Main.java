package com.imer1c;

import com.imer1c.generator.DataPackCreator;

import java.io.File;

public class Main {
    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            throw new RuntimeException("No file argument");
        }

        String filePath = args[0];
        File file = new File(filePath);

        DataPackCreator.init(file);
    }
}
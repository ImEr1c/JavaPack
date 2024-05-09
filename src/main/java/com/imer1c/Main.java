package com.imer1c;

import com.imer1c.api.exceptions.DataPackException;
import com.imer1c.generator.DataPackCompiler;

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


    }
}
package com.imer1c.util;

import com.imer1c.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static String camelToSnake(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i);

            if (Character.isUpperCase(currentChar))
            {
                if (i > 0)
                {
                    result.append('_');
                }

                result.append(Character.toLowerCase(currentChar));
            }
            else
            {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static void checkFolderExistance(File folder)
    {
        if (!folder.exists())
        {
            folder.mkdirs();
        }
    }

    public static void writeJsonFile(File f, Object obj)
    {
        try (FileWriter writer = new FileWriter(f))
        {
            Constants.GSON.toJson(obj, writer);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }



    public static void checkParent(File packMcMeta)
    {
        checkFolderExistance(packMcMeta.getParentFile());
    }
}

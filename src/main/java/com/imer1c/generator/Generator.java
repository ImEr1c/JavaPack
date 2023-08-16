package com.imer1c.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imer1c.DataPack;
import com.imer1c.generator.formatter.json.TrueBooleanSerializer;
import com.imer1c.utils.Utils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Generator {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static final Gson ONE_LINE_GSON = new GsonBuilder().registerTypeAdapter(Boolean.class, new TrueBooleanSerializer()).create();
    private static final File OUTPUT_FOLDER = new File("out");

    private static DataPack dataPack;
    private static DatapackDataGenerator dataGenerator;
    private static MainFunctionsGenerator mainFunctionsGenerator;

    public static void init(DataPack dataPack)
    {
        Generator.dataPack = dataPack;

        Utils.getOrCreateDir(OUTPUT_FOLDER);

        File dataPackFolder = new File(OUTPUT_FOLDER, dataPack.getName());

        dataPack.setPath(dataPackFolder);

        dataGenerator = new DatapackDataGenerator(dataPack);
        mainFunctionsGenerator = new MainFunctionsGenerator(dataPack);

        clearAndInitBasicData(dataPackFolder);
    }

    private static void clearAndInitBasicData(File dataPackFolder)
    {
        if (Generator.OUTPUT_FOLDER.exists())
        {
            try
            {
                FileUtils.deleteDirectory(Generator.OUTPUT_FOLDER);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

        dataPackFolder.mkdirs();

        dataGenerator.generateDataPack();
        mainFunctionsGenerator.generateMainFunctions();
    }

    public static DataPack getDataPack()
    {
        return dataPack;
    }
}

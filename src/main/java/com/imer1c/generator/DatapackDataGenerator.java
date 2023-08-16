package com.imer1c.generator;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.imer1c.DataPack;
import com.imer1c.generator.data.Pack;
import com.imer1c.generator.data.TagFunction;
import com.imer1c.api.minecraft.utils.ResourceLocation;
import com.imer1c.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DatapackDataGenerator {

    private final DataPack dataPack;
    private final File path;

    public DatapackDataGenerator(DataPack dataPack)
    {
        this.dataPack = dataPack;
        this.path = this.dataPack.getPath();
    }

    public void generateDataPack()
    {
        try
        {
            this.generatePackMCMeta();
            this.generateFolderStructure();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void generatePackMCMeta() throws IOException
    {
        File mcMeta = new File(this.path, "pack.mcmeta");
        FileWriter writer = new FileWriter(mcMeta);

        Pack pack = new Pack(this.dataPack.getVersion(), this.dataPack.getDescription());
        Map<String, Pack> map = ImmutableMap.of("pack", pack);
        Gson gson = Generator.GSON;

        gson.toJson(map, writer);

        writer.close();
    }

    public void generateFolderStructure() throws IOException
    {
        File data = Utils.getOrCreateDir(this.path, "data");

        File minecraft = Utils.getOrCreateDir(data, "minecraft");

        File tags = Utils.getOrCreateDir(minecraft, "tags");
        this.dataPack.putPathData("minecraft/tags", tags);

        File functions = Utils.getOrCreateDir(tags, "functions");
        this.dataPack.putPathData("minecraft/tags/functions", functions);

        this.generateLoadAndTickJSONs(functions);

        File nameSpace = Utils.getOrCreateDir(data, this.dataPack.getId());
        this.dataPack.putPathData("namespace", nameSpace);

        File dpFunctions = Utils.getOrCreateDir(nameSpace, "functions");
        this.dataPack.putPathData("functions", dpFunctions);

        Utils.createFile(dpFunctions, "load.mcfunction");
        Utils.createFile(dpFunctions, "tick.mcfunction");
    }

    public void generateLoadAndTickJSONs(File functions) throws IOException
    {
        File loadJson = new File(functions, "load.json");
        File tickJson = new File(functions, "tick.json");

        FileWriter loadJsonWriter = new FileWriter(loadJson);
        FileWriter tickJsonWriter = new FileWriter(tickJson);

        TagFunction load = new TagFunction(new ResourceLocation(this.dataPack.getId(), "load"));
        TagFunction tick = new TagFunction(new ResourceLocation(this.dataPack.getId(), "tick"));

        Gson gson = Generator.GSON;
        gson.toJson(load, loadJsonWriter);
        gson.toJson(tick, tickJsonWriter);

        loadJsonWriter.close();
        tickJsonWriter.close();
    }
}

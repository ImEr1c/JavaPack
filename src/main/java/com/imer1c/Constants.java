package com.imer1c;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class Constants {
    public static final Gson GSON = new Gson();
    public static final Gson PRETTY_GSON = new GsonBuilder().setPrettyPrinting().create();

    public static final File OUT_FOLDER = new File("out");
    public static final String FUNCTIONS_FOLDER = "data/%s/functions";
    public static final String MINECRAFT_TAG_FUNCTIONS_FOLDER = "data/minecraft/tags/functions";
}

package com.imer1c;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class Constants {
    public static final Gson GSON = new Gson();
    public static final Gson PRETTY_GSON = new GsonBuilder().setPrettyPrinting().create();

    public static final File OUT_FOLDER = new File("out");
}

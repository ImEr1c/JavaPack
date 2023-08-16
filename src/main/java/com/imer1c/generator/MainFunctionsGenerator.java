package com.imer1c.generator;

import com.imer1c.DataPack;
import com.imer1c.JavaPackWriter;
import com.imer1c.api.JavaDataPack;

public class MainFunctionsGenerator {

    private final DataPack dataPack;

    public MainFunctionsGenerator(DataPack dataPack)
    {
        this.dataPack = dataPack;
    }

    public void generateMainFunctions()
    {
        JavaPackWriter writer = this.dataPack.getWriter();
        JavaDataPack javaDataPack = this.dataPack.getJavaDataPack();

        generateTickFunction(writer, javaDataPack);
        generateLoadFunction(writer, javaDataPack);
    }

    private void generateTickFunction(JavaPackWriter writer, JavaDataPack javaDataPack)
    {
        writer.changeFunction("tick");
        javaDataPack.onTick();
    }

    private void generateLoadFunction(JavaPackWriter writer, JavaDataPack javaDataPack)
    {
        writer.changeFunction("load");
        javaDataPack.onLoad();
    }
}

package com.imer1c;

import com.imer1c.generator.formatter.Formatters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JavaPackWriter {

    private static JavaPackWriter instance;

    public static JavaPackWriter getInstance()
    {
        return instance;
    }

    private final DataPack dataPack;
    private FileWriter writer;

    public JavaPackWriter(DataPack dataPack)
    {
        this.dataPack = dataPack;

        instance = this;
    }

    public<T> void write(T obj)
    {
        this.write(Formatters.format(obj));
    }

    public void write(String s)
    {
        try
        {
            this.writer.write(s);
            this.writer.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void changeFunction(String f)
    {
        File function = this.findFunction(f);

        this.changeFunction(function);
    }

    public void changeFunction(File f)
    {
        try
        {
            if (this.writer != null)
            {
                this.writer.close();
            }

            this.writer = new FileWriter(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File findFunction(String path)
    {
        return new File(this.dataPack.getPathById("functions"), path + ".mcfunction");
    }

    public void close()
    {
        if (this.writer == null)
        {
            return;
        }

        try
        {
            this.writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

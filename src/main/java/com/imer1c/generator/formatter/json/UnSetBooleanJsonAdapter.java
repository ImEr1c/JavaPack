package com.imer1c.generator.formatter.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.imer1c.utils.UnSetBoolean;

import java.io.IOException;

public class UnSetBooleanJsonAdapter extends TypeAdapter<UnSetBoolean> {
    @Override
    public void write(JsonWriter out, UnSetBoolean value) throws IOException
    {
        out.value(value.value);
    }

    @Override
    public UnSetBoolean read(JsonReader in) throws IOException
    {
        return new UnSetBoolean(in.nextBoolean());
    }
}

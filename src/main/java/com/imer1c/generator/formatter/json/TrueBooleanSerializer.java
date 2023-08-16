package com.imer1c.generator.formatter.json;

import com.google.gson.*;

import java.lang.reflect.Type;

public class TrueBooleanSerializer implements JsonSerializer<Boolean> {
    @Override
    public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext context)
    {
        if (src)
        {
            return new JsonPrimitive(true);
        }
        else
        {
            return null;
        }
    }
}

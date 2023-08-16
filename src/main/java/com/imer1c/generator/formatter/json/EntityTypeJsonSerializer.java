package com.imer1c.generator.formatter.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.imer1c.api.minecraft.entity.EntityType;
import com.imer1c.generator.formatter.Formatters;

import java.lang.reflect.Type;

public class EntityTypeJsonSerializer implements JsonSerializer<EntityType> {
    @Override
    public JsonElement serialize(EntityType src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(Formatters.format(src));
    }
}

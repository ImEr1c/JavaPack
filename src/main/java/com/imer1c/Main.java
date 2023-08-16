package com.imer1c;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.imer1c.api.minecraft.chatting.text.TextComponentColor;
import com.imer1c.api.minecraft.entity.EntityType;
import com.imer1c.api.minecraft.utils.ResourceLocation;
import com.imer1c.generator.Generator;
import com.imer1c.generator.data.events.advancement.EventAdvancement;
import com.imer1c.generator.data.events.advancement.breed.AdvancementEventType;
import com.imer1c.generator.data.events.advancement.breed.BreedAnimalsConditions;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.generator.formatter.json.EntityTypeJsonSerializer;
import com.imer1c.generator.formatter.json.TrueBooleanSerializer;
import com.imer1c.impl.minecraft.chatting.text.KeybindTextComponent;
import com.imer1c.impl.minecraft.chatting.text.TextComponent;
import com.imer1c.impl.minecraft.world.Dimensions;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException
    {
        Dimensions.init();
        EventAdvancement event = new EventAdvancement(AdvancementEventType.BRED_ANIMALS);
        System.out.println(new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Boolean.class, new TrueBooleanSerializer()).registerTypeAdapter(EntityType.class, new EntityTypeJsonSerializer()).create().toJson(event));

        Formatters.init();

        File f = new File(args[0] + ".jar");

        DataPack datapack = JarReader.read(f);

        Generator.init(datapack);
        JavaPackWriter.getInstance().close();

        TextComponent text = new TextComponent("gigel merge pe o roata");
        text.bold(true);
        text.color(TextComponentColor.AQUA);

        KeybindTextComponent keybindTextComponent = new KeybindTextComponent("key.jump");
        keybindTextComponent.italic(true);
        keybindTextComponent.color(TextComponentColor.GREEN);
    }
}
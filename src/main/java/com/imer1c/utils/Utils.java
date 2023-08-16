package com.imer1c.utils;

import com.imer1c.DataPack;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.generator.Generator;
import com.imer1c.impl.minecraft.entity.LivingEntity;
import com.imer1c.impl.minecraft.entity.player.Player;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static File getOrCreateDir(File f, String child)
    {
        return getOrCreateDir(new File(f, child));
    }

    public static File getOrCreateDir(File f)
    {
        if (!f.exists())
        {
            f.mkdirs();
        }

        return f;
    }

    public static File createFile(File f, String child) throws IOException
    {
        File file = new File(f, child);

        file.createNewFile();

        return file;
    }

    public static boolean isClassExtending(Class<?> c, Class<?> extend)
    {
        while (c != Object.class)
        {
            if (c == extend)
            {
                return true;
            }

            c = c.getSuperclass();
        }

        return false;
    }

    public static ILivingEntity checkForMultipleEntities(ILivingEntity entity)
    {
        LivingEntity livingEntity = (LivingEntity) entity;

        if (livingEntity.getUuid() != null || (entity instanceof Player player && player.getPlayerName() != null))
        {
            return entity;
        }

        TargetSelector target = livingEntity.getTarget();

        if (target.getLimit() == 1)
        {
            return entity;
        }

        switch (target.getTarget())
        {
            case COMMAND_EXECUTOR, RANDOM_PLAYER, NEAREST_PLAYER -> {}
            case ALL_ENTITIES, ALL_PLAYERS -> throw new RuntimeException("Only one entity is allowed");
        }

        return entity;
    }
}

package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.chatting.text.TextComponentColor;
import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawComponentBase;
import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.entity.EntityAnchor;
import com.imer1c.api.minecraft.entity.EntityType;
import com.imer1c.api.minecraft.entity.Rotation;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.entity.target.Sort;
import com.imer1c.api.minecraft.world.DamageType;
import com.imer1c.api.minecraft.world.Difficulty;
import com.imer1c.api.minecraft.world.Time;
import com.imer1c.api.minecraft.world.TimeQuery;
import com.imer1c.api.minecraft.world.block.*;
import com.imer1c.api.minecraft.world.block.properties.*;
import com.imer1c.api.minecraft.world.bossbar.BossbarColor;
import com.imer1c.api.minecraft.world.bossbar.BossbarStyle;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.pos.ColumnPos;
import com.imer1c.api.minecraft.world.pos.Vec3;
import com.imer1c.impl.minecraft.entity.LivingEntity;
import com.imer1c.impl.minecraft.entity.player.Player;
import com.imer1c.impl.minecraft.entity.target.TargetSelectorImpl;
import com.imer1c.impl.minecraft.world.block.SculkSensorPhase;

import java.util.HashMap;
import java.util.Map;

public class Formatters {
    private static final Map<Class<?>, IFormatter<?>> map = new HashMap<>();

    public static void init()
    {
        register(TargetSelectorImpl.class, new TargetSelectorFormatter());
        register(Player.class, new PlayerFormatter());
        register(LivingEntity.class, new LivingEntityFormatter());
        register(BlockPos.class, new BlockPosFormatter());
        register(ColumnPos.class, new ColumnPosFormatter());
        register(Vec3.class, new Vec3Formatter());
        register(Angle.class, new AngleFormatter());
        register(Rotation.class, new RotationFormatter());

        registerEnums(Facing.class, HorizontalFacing.class, GameMode.class, Time.class, TimeQuery.class, BossbarColor.class, BossbarStyle.class, DamageType.class,
                Difficulty.class, TextComponentColor.class, Sort.class, ITellrawComponentBase.ClickEventType.class, ITellrawComponentBase.HoverEventType.class,
                BlockRotation.class, EntityAnchor.class, Time.class, TimeQuery.class, Axis.class, BedPart.class, BellAttachment.class, DripLeafTilt.class,
                ChestType.class, Half.class, DoorHinge.class, HorizontalAxis.class, Instrument.class, PistonType.class, Thickness.class, RailShape.class,
                SpecialRailShape.class, ComparatorMode.class, RedstoneDustSide.class, SculkSensorPhase.class, SlabType.class, StairShape.class, StructureMode.class,
                EggHatch.class);
        registerOrdinalEnums(Stage.class, SaplingAge.class, HoneyLevel.class, CauldronLevel.class, ComposterLevel.class);
        register(EntityType.class, value -> "minecraft:" + value.name().toLowerCase());
    }

    private static<T> void register(Class<T> c, IFormatter<T> formatter)
    {
        map.put(c, formatter);
    }

    private static void registerOrdinalEnums(Class<? extends Enum<?>>... classes)
    {
        for (Class<? extends Enum<?>> c : classes)
        {
            registerOrdinalEnum(c);
        }
    }

    private static void registerEnums(Class<? extends Enum<?>>... classes)
    {
        for (Class<? extends Enum<?>> c : classes)
        {
            registerEnum(c);
        }
    }

    private static void registerOrdinalEnum(Class<? extends Enum<?>> c)
    {
        register(c, value -> String.valueOf(value.ordinal()));
    }

    private static void registerEnum(Class<? extends Enum<?>> c)
    {
        registerEnum(c, true);
    }

    private static void registerEnum(Class<? extends Enum<?>> c, boolean lowerCase)
    {
        if (lowerCase)
        {
            register(c, value -> value.name().toLowerCase());
        }
        else
        {
            register(c, Enum::name);
        }
    }

    public static<T> IFormatter<T> getFormatter(Class<T> c)
    {
        return (IFormatter<T>) map.get(c);
    }

    public static<T> String format(T obj)
    {
        return getFormatter((Class<T>)obj.getClass()).format(obj);
    }
}

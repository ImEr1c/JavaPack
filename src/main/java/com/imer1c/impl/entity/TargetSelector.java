package com.imer1c.impl.entity;

import com.imer1c.annotation.Property;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.entity.target.Sort;
import com.imer1c.api.minecraft.entity.target.Target;
import com.imer1c.api.util.Range;
import com.imer1c.impl.ToggleableValue;
import com.imer1c.properties.PropertiesSerializer;

import java.util.ArrayList;
import java.util.List;

public class TargetSelector implements com.imer1c.api.minecraft.entity.target.TargetSelector {

    @Property(expose = false)
    private final Target target;

    private int limit;
    private Sort sort;
    private Range radius;
    private int dx;
    private int dy;
    private int dz;

    @Property(id = "x_rotation")
    private Range verticalRotation;

    @Property(id = "y_rotation")
    private Range horizontalRotation;

    private ToggleableValue<String> name;
    private final List<ToggleableValue<String>> nbt = new ArrayList<>();
    private ToggleableValue<GameMode> gamemode;

    @Property(id = "level")
    private Range xpLevel;

    @Property(id = "tag")
    private final List<ToggleableValue<String>> tags = new ArrayList<>();

    private int x;
    private int y;
    private int z;

    public TargetSelector(Target target)
    {
        this.target = target;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector limit(int limit)
    {
        this.limit = limit;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector sort(Sort sort)
    {
        this.sort = sort;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector atLocation(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector inRadius(Range radius)
    {
        this.radius = radius;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector inVolume(int dx, int dy, int dz)
    {
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector verticalRotation(Range rotation)
    {
        this.verticalRotation = rotation;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector horizontalRotation(Range rotation)
    {
        this.horizontalRotation = rotation;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector name(String name)
    {
        this.name = new ToggleableValue<>(name, true);
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector notName(String name)
    {
        this.name = new ToggleableValue<>(name, false);
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector nbt(String nbt)
    {
        this.nbt.add(new ToggleableValue<>(nbt, true));
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector notNbt(String nbt)
    {
        this.nbt.add(new ToggleableValue<>(nbt, false));
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector gameMode(GameMode gameMode)
    {
        this.gamemode = new ToggleableValue<>(gameMode, true);
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector notGameMode(GameMode gameMode)
    {
        this.gamemode = new ToggleableValue<>(gameMode, false);
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector xpLevel(Range level)
    {
        this.xpLevel = level;
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector tag(String tag)
    {
        this.tags.add(new ToggleableValue<>(tag, true));
        return this;
    }

    @Override
    public com.imer1c.api.minecraft.entity.target.TargetSelector notTag(String tag)
    {
        this.tags.add(new ToggleableValue<>(tag, false));
        return this;
    }

    @Override
    public String toString()
    {
        String target = switch (this.target)
        {
            case ALL_PLAYERS -> "@a";
            case ALL_ENTITIES -> "@e";
            case EXECUTING_PLAYER -> "@s";
            case NEAREST_PLAYER -> "@p";
            case RANDOM_PLAYER -> "@r";
        };

        return target + PropertiesSerializer.serialize(TargetSelector.class, this);
    }

    public boolean isPlayersOnly()
    {
        return this.target == Target.ALL_PLAYERS || this.target == Target.NEAREST_PLAYER || this.target == Target.RANDOM_PLAYER;
    }

    public boolean isForMultipleEntities()
    {
        return this.limit != 1;
    }
}

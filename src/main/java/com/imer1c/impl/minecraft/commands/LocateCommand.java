package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.utils.ValueImpl;

public class LocateCommand extends AbstractCommand {

    private static final int BIOME_INDEX = 0;
    private static final int POI_INDEX = 1;
    private static final int STRUCTURE_INDEX = 2;

    @Override
    public String getId()
    {
        return "locate";
    }

    public Value distToBiome(String biome)
    {
        return new ValueImpl(this.getCommand(BIOME_INDEX, biome));
    }

    public Value distToPOI(String poi)
    {
        return new ValueImpl(this.getCommand(POI_INDEX, poi));
    }

    public Value distToStructure(String structure)
    {
        return new ValueImpl(this.getCommand(STRUCTURE_INDEX, structure));
    }
}

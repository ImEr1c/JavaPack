package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.Difficulty;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.ValueImpl;

public class DifficultyCommand extends AbstractCommand {

    private static final int SET_INDEX = 0;
    private static final int GET_INDEX = 1;

    @Override
    public String getId()
    {
        return "difficulty";
    }

    public void changeDifficulty(Difficulty difficulty)
    {
        this.write(SET_INDEX, Formatters.format(difficulty));
    }

    public Value get()
    {
        return new ValueImpl(this.getCommand(GET_INDEX));
    }
}

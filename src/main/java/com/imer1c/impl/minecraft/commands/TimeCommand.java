package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.utils.Times;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.Time;
import com.imer1c.api.minecraft.world.TimeQuery;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.ValueImpl;

public class TimeCommand extends AbstractCommand {
    private static final int ADD_INDEX = 0;
    private static final int QUERY_INDEX = 1;
    private static final int SET_TIME_INDEX = 2;

    @Override
    public String getId()
    {
        return "time";
    }

    public void add(Times time)
    {
        this.write(ADD_INDEX, time);
    }

    public Value query(TimeQuery query)
    {
        return new ValueImpl(this.getCommand(QUERY_INDEX, Formatters.format(query)));
    }

    public void set(Time time)
    {
        this.write(SET_TIME_INDEX, Formatters.format(time));
    }

    public void set(Times time)
    {
        this.write(SET_TIME_INDEX, time);
    }
}

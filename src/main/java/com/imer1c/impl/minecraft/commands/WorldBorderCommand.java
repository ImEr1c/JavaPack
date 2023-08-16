package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.pos.Vec2;
import com.imer1c.utils.ValueImpl;

public class WorldBorderCommand extends AbstractCommand {

    private static final int ADD_INDEX = 0;
    private static final int ADD_TIME_INDEX = 1;
    private static final int BORDER_DAMAGE_INDEX = 2;
    private static final int CENTER_INDEX = 3;
    private static final int DAMAGE_BUFFER_DISTANCE_INDEX = 4;
    private static final int GET_INDEX = 5;
    private static final int SET_SIZE_INDEX = 6;
    private static final int SET_SIZE_TIME_INDEX = 7;
    private static final int SET_WARNING_DISTANCE = 8;
    private static final int SET_WARNING_TIME = 9;

    @Override
    public String getId()
    {
        return "worldborder";
    }

    public void add(double distance)
    {
        this.write(ADD_INDEX, distance);
    }

    public void add(double distance, int time)
    {
        this.write(ADD_TIME_INDEX, distance, time);
    }

    public void setBorderDamage(float damage)
    {
        this.write(BORDER_DAMAGE_INDEX, damage);
    }

    public void center(Vec2 pos)
    {
        this.write(CENTER_INDEX, pos);
    }

    public void setDamageBuffer(float distance)
    {
        this.write(DAMAGE_BUFFER_DISTANCE_INDEX, distance);
    }

    public Value getSize()
    {
        return new ValueImpl(this.getCommand(GET_INDEX));
    }

    public void setSize(double distance)
    {
        this.write(SET_SIZE_INDEX, distance);
    }

    public void setSize(double distance, int time)
    {
        this.write(SET_SIZE_TIME_INDEX, distance, time);
    }

    public void setWarningDistance(int distance)
    {
        this.write(SET_WARNING_DISTANCE, distance);
    }

    public void setWarningTime(int time)
    {
        this.write(SET_WARNING_TIME, time);
    }
}

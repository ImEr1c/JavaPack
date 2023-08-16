package com.imer1c.impl.minecraft.world;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.IWorldBoder;
import com.imer1c.api.minecraft.world.pos.Vec2;
import com.imer1c.impl.minecraft.commands.CommandManager;

public class WorldBorder implements IWorldBoder {
    @Override
    public void add(double distance)
    {
        CommandManager.worldBorder.add(distance);
    }

    @Override
    public void add(double distance, int time)
    {
        CommandManager.worldBorder.add(distance, time);
    }

    @Override
    public void setDamage(float damage)
    {
        CommandManager.worldBorder.setBorderDamage(damage);
    }

    @Override
    public void center(Vec2 pos)
    {
        CommandManager.worldBorder.center(pos);
    }

    @Override
    public void setDamageBuffer(float distance)
    {
        CommandManager.worldBorder.setDamageBuffer(distance);
    }

    @Override
    public Value getSize()
    {
        return CommandManager.worldBorder.getSize();
    }

    @Override
    public void setSize(double distance)
    {
        CommandManager.worldBorder.setSize(distance);
    }

    @Override
    public void setSize(double distance, int time)
    {
        CommandManager.worldBorder.setSize(distance, time);
    }

    @Override
    public void setWarningDistance(int distance)
    {
        CommandManager.worldBorder.setWarningDistance(distance);
    }

    @Override
    public void setWarningTime(int time)
    {
        CommandManager.worldBorder.setWarningTime(time);
    }
}

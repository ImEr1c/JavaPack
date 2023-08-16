package com.imer1c.impl.minecraft.world;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.bossbar.BossbarColor;
import com.imer1c.api.minecraft.world.bossbar.BossbarStyle;
import com.imer1c.api.minecraft.world.bossbar.IBossbar;
import com.imer1c.impl.minecraft.commands.CommandManager;

public class Bossbar implements IBossbar {

    private final String id;

    public Bossbar(String id)
    {
        this.id = id;
    }

    @Override
    public void remove()
    {
        CommandManager.bossbar.remove(this.id);
    }

    @Override
    public void setColor(BossbarColor color)
    {
        CommandManager.bossbar.setColor(this.id, color);
    }

    @Override
    public void setStyle(BossbarStyle style)
    {
        CommandManager.bossbar.setStyle(this.id, style);
    }

    @Override
    public void setName(ITextComponent name)
    {
        CommandManager.bossbar.setName(this.id, name);
    }

    @Override
    public void setMax(int max)
    {
        CommandManager.bossbar.setMax(this.id, max);
    }

    @Override
    public void setValue(int value)
    {
        CommandManager.bossbar.setValue(this.id, value);
    }

    @Override
    public void setVisible(boolean visible)
    {
        CommandManager.bossbar.setVisible(this.id, visible);
    }

    @Override
    public void setPlayers(IPlayer players)
    {
        CommandManager.bossbar.setPlayers(this.id, players);
    }

    @Override
    public Value getMax()
    {
        return CommandManager.bossbar.getMax(this.id);
    }

    @Override
    public Value getPlayerCount()
    {
        return CommandManager.bossbar.getPlayersCount(this.id);
    }

    @Override
    public Value getValue()
    {
        return CommandManager.bossbar.getValue(this.id);
    }

    @Override
    public Value isVisible()
    {
        return CommandManager.bossbar.isVisible(this.id);
    }
}

package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.ValueImpl;

public class GameModeCommand extends AbstractCommand {
    @Override
    public String getId()
    {
        return "gamemode";
    }

    public void changeGameMode(IPlayer player, GameMode gameMode)
    {
        this.write(0, Formatters.format(gameMode), player);
    }

    public Value changeAndCountPlayers(IPlayer player, GameMode gameMode)
    {
        return new ValueImpl(this.getCommand(0, Formatters.format(gameMode), player));
    }
}

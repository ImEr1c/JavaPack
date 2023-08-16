package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.ValueImpl;

public class DefaultGameModeCommand extends AbstractCommand {
    @Override
    public String getId()
    {
        return "defaultgamemode";
    }

    public void setDefaultGameMode(GameMode gameMode)
    {
        this.write(0, Formatters.format(gameMode));
    }

    public Value detectHowManyPlayersWillChangeTheirGameMode(GameMode gameMode)
    {
        return new ValueImpl(this.getCommand(0, Formatters.format(gameMode)));
    }
}

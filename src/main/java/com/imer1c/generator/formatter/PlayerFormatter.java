package com.imer1c.generator.formatter;

import com.imer1c.impl.minecraft.entity.player.Player;

public class PlayerFormatter implements IFormatter<Player> {
    @Override
    public String format(Player player)
    {
        if (player.getTarget() != null)
        {
            return player.getTarget().toString();
        }
        else if (player.getPlayerName() != null)
        {
            return player.getPlayerName();
        }
        else if (player.getUuid() != null)
        {
            return player.getUuid().toString();
        }

        return null;
    }
}

package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.utils.Utils;

public class SpectateCommand extends AbstractCommand {

    private static final int SPECTATE_INDEX = 0;
    private static final int STOP_SPECTATING_INDEX = 1;

    @Override
    public String getId()
    {
        return "spectate";
    }

    public void spectate(ILivingEntity entity, IPlayer player)
    {
        this.write(SPECTATE_INDEX, Utils.checkForMultipleEntities(entity), Utils.checkForMultipleEntities(player));
    }

    public void stopSpectating()
    {
        this.write(STOP_SPECTATING_INDEX);
    }
}

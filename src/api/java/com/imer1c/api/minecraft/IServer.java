package com.imer1c.api.minecraft;

import com.imer1c.api.minecraft.chatting.text.ITextComponentCreator;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.entity.target.Targetter;
import com.imer1c.api.minecraft.world.IWorld;

public interface IServer {
    Targetter getTargetter();

    ITextComponentCreator getTextComponentCreator();

    IWorld getWorld();

    IPlayer findPlayer(TargetSelector selector);
}

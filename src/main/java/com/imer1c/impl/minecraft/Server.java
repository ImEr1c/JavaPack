package com.imer1c.impl.minecraft;

import com.imer1c.api.minecraft.IServer;
import com.imer1c.api.minecraft.chatting.text.ITextComponentCreator;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.entity.target.Targetter;
import com.imer1c.api.minecraft.world.IWorld;
import com.imer1c.impl.minecraft.chatting.text.TextComponentCreator;
import com.imer1c.impl.minecraft.entity.player.Player;
import com.imer1c.impl.minecraft.entity.target.TargetterImpl;
import com.imer1c.impl.minecraft.world.World;

public class Server implements IServer {

    private final ITextComponentCreator textComponentCreator = new TextComponentCreator();
    private final Targetter targetter = new TargetterImpl();
    private final IWorld world = new World();

    @Override
    public Targetter getTargetter()
    {
        return this.targetter;
    }

    @Override
    public ITextComponentCreator getTextComponentCreator()
    {
        return this.textComponentCreator;
    }

    @Override
    public IWorld getWorld()
    {
        return this.world;
    }

    @Override
    public IPlayer findPlayer(TargetSelector selector)
    {
        return new Player(this.world, selector);
    }
}

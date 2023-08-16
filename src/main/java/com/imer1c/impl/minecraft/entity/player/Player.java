package com.imer1c.impl.minecraft.entity.player;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.player.inventory.IPlayerInventory;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.entity.target.Target;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.utils.Times;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.IWorld;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.impl.minecraft.commands.CommandManager;
import com.imer1c.impl.minecraft.entity.LivingEntity;

import java.util.UUID;

public class Player extends LivingEntity implements IPlayer {

    private final String playerName;
    private final IPlayerInventory inventory;

    public Player(IWorld world, TargetSelector target)
    {
        super(target, world);

        if (target.getTarget() == Target.ALL_ENTITIES)
        {
            throw new RuntimeException("Can't use the All Entities target to find players");
        }

        this.playerName = null;
        this.inventory = new PlayerInventory(this);
    }

    public Player(String playerName, IWorld world)
    {
        super((TargetSelector) null, world);
        this.playerName = playerName;
        this.inventory = new PlayerInventory(this);
    }

    public Player(UUID uuid, IWorld world)
    {
        super(uuid, world);
        this.playerName = null;
        this.inventory = new PlayerInventory(this);
    }

    @Override
    public void tellraw(ITextComponent... components)
    {
        this.world.tellraw(this, components);
    }

    @Override
    public void clearTitle()
    {
        this.world.clearTitle(this);
    }

    @Override
    public void resetTitleOptions()
    {
        this.world.resetTitleOptions(this);
    }

    @Override
    public void setSubtitle(ITextComponent component)
    {
        this.world.setSubtitle(this, component);
    }

    @Override
    public void showTitle(ITextComponent component, boolean actionbar)
    {
        this.world.showTitle(this, component, actionbar);
    }

    @Override
    public void setTitleScreenTime(Times fadeInTime, Times stayTime, Times fadeOutTime)
    {
        this.world.setTitleScreenTime(this, fadeInTime, stayTime, fadeOutTime);
    }

    @Override
    public void setGameMode(GameMode gameMode)
    {
        CommandManager.gamemode.changeGameMode(this, gameMode);
    }

    @Override
    public Value setGameModeAndCount(GameMode gameMode)
    {
        return CommandManager.gamemode.changeAndCountPlayers(this, gameMode);
    }

    @Override
    public void ride(ILivingEntity entity)
    {
        CommandManager.ride.ride(this, entity);
    }

    @Override
    public void stopRiding()
    {
        CommandManager.ride.stopRiding(this);
    }

    @Override
    public void setSpawnPoint()
    {
        CommandManager.spawnPoint.setSpawnPoint(this);
    }

    @Override
    public void setSpawnPoint(BlockPos pos)
    {
        CommandManager.spawnPoint.setSpawnPoint(this, pos);
    }

    @Override
    public void setSpawnPoint(BlockPos pos, Angle angle)
    {
        CommandManager.spawnPoint.setSpawnPoint(this, pos, angle);
    }

    @Override
    public void spectate(ILivingEntity entity)
    {
        CommandManager.spectate.spectate(entity, this);
    }

    @Override
    public void stopSpectating()
    {
        CommandManager.spectate.stopSpectating();
    }

    @Override
    public void addXpPoints(int xp)
    {
        CommandManager.xp.addPoints(this, xp);
    }

    @Override
    public void addXpLevels(int levels)
    {
        CommandManager.xp.addLevels(this, levels);
    }

    @Override
    public void setXpPoints(int xp)
    {
        CommandManager.xp.setPoints(this, xp);
    }

    @Override
    public void setXpLevels(int levels)
    {
        CommandManager.xp.setLevels(this, levels);
    }

    @Override
    public Value getXpPoints()
    {
        return CommandManager.xp.getPoints(this);
    }

    @Override
    public Value getXpLevels()
    {
        return CommandManager.xp.getLevels(this);
    }

    @Override
    public IWorld getWorld()
    {
        return world;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    @Override
    public String toString()
    {
        return Formatters.format(this);
    }

    @Override
    public IPlayerInventory getInventory()
    {
        return inventory;
    }
}

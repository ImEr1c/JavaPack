package com.imer1c.impl.minecraft.world;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.utils.Times;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.*;
import com.imer1c.api.minecraft.world.block.IBlockState;
import com.imer1c.api.minecraft.world.bossbar.IBossbar;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.pos.ColumnPos;
import com.imer1c.impl.minecraft.commands.CommandManager;
import com.imer1c.impl.minecraft.entity.LivingEntity;
import com.imer1c.impl.minecraft.entity.player.Player;
import com.imer1c.impl.minecraft.world.block.BlockState;
import com.imer1c.utils.VersionLimitUtils;

import java.util.UUID;

public class World implements IWorld {

    private final WorldBorder border;

    public World()
    {
        VersionLimitUtils.limitVersion(11, VersionLimitUtils.LimitType.CLASS);
        this.border = new WorldBorder();
    }

    @Override
    public void tellraw(IPlayer player, ITextComponent... components)
    {
        CommandManager.tellraw.execute(player, components);
    }

    @Override
    public IBlockState createBlockState(String blockId)
    {
        return new BlockState(null);
    }

    @Override
    public ILivingEntity findEntity(TargetSelector target)
    {
        return new LivingEntity(target, this);
    }

    @Override
    public ILivingEntity findEntity(UUID uuid)
    {
        return new LivingEntity(uuid, this);
    }

    @Override
    public IPlayer findPlayer(TargetSelector target)
    {
        return new Player(this, target);
    }

    @Override
    public IPlayer findPlayer(String playerName)
    {
        return new Player(playerName, this);
    }

    @Override
    public IPlayer findPlayer(UUID uuid)
    {
        return new Player(uuid, this);
    }

    @Override
    public void clearTitle(IPlayer player)
    {
        CommandManager.title.clear(player);
    }

    @Override
    public void resetTitleOptions(IPlayer player)
    {
        CommandManager.title.reset(player);
    }

    @Override
    public void setSubtitle(IPlayer player, ITextComponent component)
    {
        CommandManager.title.subtitle(player, component);
    }

    @Override
    public void showTitle(IPlayer player, ITextComponent component, boolean actionbar)
    {
        if (actionbar)
        {
            CommandManager.title.actionbar(player, component);
        }
        else
        {
            CommandManager.title.title(player, component);
        }
    }

    @Override
    public void setTitleScreenTime(IPlayer player, Times fadeInTime, Times stayTime, Times fadeOutTime)
    {
        CommandManager.title.times(player, fadeInTime, stayTime, fadeOutTime);
    }

    @Override
    public IBossbar addBossbar(String id, ITextComponent name)
    {
        CommandManager.bossbar.add(id, name);

        return new Bossbar(id);
    }

    @Override
    public void broadcastNarrativeMessage(String message)
    {
        CommandManager.me.broadcastNarrativeMessage(message);
    }

    @Override
    public void setDefaultGameMode(GameMode gameMode)
    {
        CommandManager.defaultGameMode.setDefaultGameMode(gameMode);
    }

    @Override
    public Value setDefaultGameModeAndCount(GameMode gameMode)
    {
        return CommandManager.defaultGameMode.detectHowManyPlayersWillChangeTheirGameMode(gameMode);
    }

    @Override
    public void setDifficulty(Difficulty difficulty)
    {
        CommandManager.difficulty.changeDifficulty(difficulty);
    }

    @Override
    public Value getDifficulty()
    {
        return CommandManager.difficulty.get();
    }

    @Override
    public Value countForceLoadedChunks()
    {
        return CommandManager.forceLoad.countChunks();
    }

    @Override
    public void forceLoadChunks(ColumnPos from, ColumnPos to)
    {
        CommandManager.forceLoad.addChunks(from, to);
    }

    @Override
    public void unForceLoadChunks(ColumnPos from, ColumnPos to)
    {
        CommandManager.forceLoad.removeChunks(from, to);
    }

    @Override
    public void unForceLoadAllChunks()
    {
        CommandManager.forceLoad.removeAllChunks();
    }

    @Override
    public IChunk getChunk(ColumnPos pos)
    {
        return new Chunk(pos);
    }

    @Override
    public void kill(ILivingEntity entity)
    {
        CommandManager.kill.kill(entity);
    }

    @Override
    public Value killAndCount(ILivingEntity entity)
    {
        return CommandManager.kill.killAndCount(entity);
    }

    @Override
    public Value findBiome(String biome)
    {
        return CommandManager.locate.distToBiome(biome);
    }

    @Override
    public Value findPOI(String POI)
    {
        return CommandManager.locate.distToPOI(POI);
    }

    @Override
    public Value findStructure(String structure)
    {
        return CommandManager.locate.distToStructure(structure);
    }

    @Override
    public void setWorldSpawn(BlockPos pos)
    {
        CommandManager.setWorldSpawn.setWorldSpawn(pos);
    }

    @Override
    public void setWorldSpawn(BlockPos pos, Angle angle)
    {
        CommandManager.setWorldSpawn.setWorldSpawn(pos, angle);
    }

    @Override
    public void broadcastMessage(String message)
    {
        CommandManager.say.say(message);
    }

    @Override
    public void addTime(Times time)
    {
        CommandManager.time.add(time);
    }

    @Override
    public void setTime(Times time)
    {
        CommandManager.time.set(time);
    }

    @Override
    public void setTime(Time time)
    {
        CommandManager.time.set(time);
    }

    @Override
    public Value getTime(TimeQuery query)
    {
        return CommandManager.time.query(query);
    }

    @Override
    public void setWeather(Weather weather)
    {
        CommandManager.weather.setWeather(weather);
    }

    @Override
    public void setWeather(Weather weather, int duration)
    {
        CommandManager.weather.setWeather(weather, duration);
    }

    @Override
    public IWorldBoder getWorldBorder()
    {
        return this.border;
    }
}

package com.imer1c.api.minecraft.world;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.utils.Times;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.block.IBlockState;
import com.imer1c.api.minecraft.world.bossbar.IBossbar;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.pos.ColumnPos;

import java.util.UUID;

public interface IWorld {
    void tellraw(IPlayer player, ITextComponent... components);

    IBlockState createBlockState(String blockId);

    ILivingEntity findEntity(TargetSelector target);

    ILivingEntity findEntity(UUID uuid);

    IPlayer findPlayer(TargetSelector target);

    IPlayer findPlayer(String playerName);

    IPlayer findPlayer(UUID uuid);

    void clearTitle(IPlayer player);

    void resetTitleOptions(IPlayer player);

    void setSubtitle(IPlayer player, ITextComponent component);

    void showTitle(IPlayer player, ITextComponent component, boolean actionbar);

    void setTitleScreenTime(IPlayer player, Times fadeInTime, Times stayTime, Times fadeOutTime);

    IBossbar addBossbar(String id, ITextComponent name);

    void broadcastNarrativeMessage(String message);

    void setDefaultGameMode(GameMode gameMode);

    Value setDefaultGameModeAndCount(GameMode gameMode);

    void setDifficulty(Difficulty difficulty);

    Value getDifficulty();

    Value countForceLoadedChunks();

    void forceLoadChunks(ColumnPos from, ColumnPos to);

    void unForceLoadChunks(ColumnPos from, ColumnPos to);

    void unForceLoadAllChunks();

    IChunk getChunk(ColumnPos pos);

    void kill(ILivingEntity entity);

    Value killAndCount(ILivingEntity entity);

    Value findBiome(String biome);

    Value findPOI(String POI);

    Value findStructure(String structure);

    void setWorldSpawn(BlockPos pos);

    void setWorldSpawn(BlockPos pos, Angle angle);

    void broadcastMessage(String message);

    void addTime(Times time);

    void setTime(Times time);

    void setTime(Time time);

    Value getTime(TimeQuery query);

    void setWeather(Weather weather);

    void setWeather(Weather weather, int duration);

    IWorldBoder getWorldBorder();
}

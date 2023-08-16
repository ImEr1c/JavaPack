package com.imer1c.api.minecraft.entity.player;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.Angle;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.player.inventory.IPlayerInventory;
import com.imer1c.api.minecraft.entity.target.GameMode;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.utils.Times;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.IWorld;
import com.imer1c.api.minecraft.world.pos.BlockPos;

public interface IPlayer extends ILivingEntity {
    void tellraw(ITextComponent... components);

    void clearTitle();

    void resetTitleOptions();

    void setSubtitle(ITextComponent component);

    void showTitle(ITextComponent component, boolean actionbar);

    void setTitleScreenTime(Times fadeInTime, Times stayTime, Times fadeOutTime);

    void setGameMode(GameMode gameMode);

    Value setGameModeAndCount(GameMode gameMode);

    void ride(ILivingEntity entity);

    void stopRiding();

    void setSpawnPoint();

    void setSpawnPoint(BlockPos pos);

    void setSpawnPoint(BlockPos pos, Angle angle);

    void spectate(ILivingEntity entity);

    void stopSpectating();

    void addXpPoints(int xp);

    void addXpLevels(int levels);

    void setXpPoints(int xp);

    void setXpLevels(int levels);

    Value getXpPoints();

    Value getXpLevels();

    IWorld getWorld();

    IPlayerInventory getInventory();
}

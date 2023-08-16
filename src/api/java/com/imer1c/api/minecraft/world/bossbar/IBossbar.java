package com.imer1c.api.minecraft.world.bossbar;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.player.IPlayer;
import com.imer1c.api.minecraft.utils.Value;

public interface IBossbar {
    void remove();

    void setColor(BossbarColor color);

    void setStyle(BossbarStyle style);

    void setName(ITextComponent name);

    void setMax(int max);

    void setValue(int value);

    void setVisible(boolean visible);

    void setPlayers(IPlayer players);

    Value getMax();

    Value getPlayerCount();

    Value getValue();

    Value isVisible();
}

package com.imer1c.api.minecraft.world;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.pos.Vec2;

public interface IWorldBoder {
    void add(double distance);

    void add(double distance, int time);

    void setDamage(float damage);

    void center(Vec2 pos);

    void setDamageBuffer(float distance);

    Value getSize();

    void setSize(double distance);

    void setSize(double distance, int time);

    void setWarningDistance(int distance);

    void setWarningTime(int time);
}

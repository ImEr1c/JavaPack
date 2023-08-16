package com.imer1c.api.minecraft.world;

import com.imer1c.api.minecraft.utils.Value;

public interface IChunk {
    void forceLoad();

    void removeForceLoad();

    Value isForceLoaded();
}

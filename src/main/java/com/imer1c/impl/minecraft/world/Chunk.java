package com.imer1c.impl.minecraft.world;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.IChunk;
import com.imer1c.api.minecraft.world.pos.ColumnPos;
import com.imer1c.impl.minecraft.commands.CommandManager;

public class Chunk implements IChunk {

    private final ColumnPos pos;

    public Chunk(ColumnPos pos)
    {
        this.pos = pos;
    }

    @Override
    public void forceLoad()
    {
        CommandManager.forceLoad.addChunk(this.pos);
    }

    @Override
    public void removeForceLoad()
    {
        CommandManager.forceLoad.removeChunk(this.pos);
    }

    @Override
    public Value isForceLoaded()
    {
        return CommandManager.forceLoad.isChunkForceLoaded(this.pos);
    }
}

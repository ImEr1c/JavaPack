package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.pos.ColumnPos;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.utils.ValueImpl;

public class ForceLoadCommand extends AbstractCommand {

    private static final int ADD_CHUNK_INDEX = 1;
    private static final int ADD_CHUNKS_INDEX = 2;
    private static final int REMOVE_CHUNK_INDEX = 3;
    private static final int REMOVE_CHUNKS_INDEX = 4;
    private static final int REMOVE_ALL_CHUNKS_INDEX = 5;
    private static final int QUERY_INDEX = 6;
    private static final int QUERY_CHUNK_INDEX = 7;

    @Override
    public String getId()
    {
        return "forceload";
    }

    public void addChunk(ColumnPos pos)
    {
        this.write(ADD_CHUNK_INDEX, pos);
    }

    public void addChunks(ColumnPos from, ColumnPos to)
    {
        this.write(ADD_CHUNKS_INDEX, Formatters.format(from),
                Formatters.format(to));
    }

    public void removeChunk(ColumnPos pos)
    {
        this.write(REMOVE_CHUNK_INDEX, Formatters.format(pos));
    }

    public void removeChunks(ColumnPos from, ColumnPos to)
    {
        this.write(REMOVE_CHUNKS_INDEX, Formatters.format(from),
                Formatters.format(to));
    }

    public void removeAllChunks()
    {
        this.write(REMOVE_ALL_CHUNKS_INDEX);
    }

    public Value countChunks()
    {
        return new ValueImpl(this.getCommand(QUERY_INDEX));
    }

    public Value isChunkForceLoaded(ColumnPos pos)
    {
        return new ValueImpl(this.getCommand(QUERY_CHUNK_INDEX, Formatters.format(pos)));
    }
}

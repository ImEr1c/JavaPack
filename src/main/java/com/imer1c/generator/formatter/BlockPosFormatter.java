package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.world.pos.BlockPos;

public class BlockPosFormatter implements IFormatter<BlockPos> {
    @Override
    public String format(BlockPos value)
    {
        int x = value.getX();
        int y = value.getY();
        int z = value.getZ();

        boolean relative = value.isRelative();
        boolean vector = value.isVector();

        StringBuilder builder = new StringBuilder();

        if (relative)
        {
            char c = vector ? '^' : '~';

            builder.append(c);
            builder.append(x);
            builder.append(" ");
            builder.append(c);
            builder.append(y);
            builder.append(" ");
            builder.append(c);
            builder.append(z);
        }
        else
        {
            builder.append(x);
            builder.append(" ");
            builder.append(y);
            builder.append(" ");
            builder.append(z);
        }

        return builder.toString();
    }
}

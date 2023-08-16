package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.world.pos.ColumnPos;

public class ColumnPosFormatter implements IFormatter<ColumnPos> {
    @Override
    public String format(ColumnPos value)
    {
        int x = value.getX();
        int z = value.getZ();

        boolean relative = value.isRelative();

        StringBuilder builder = new StringBuilder();

        if (relative)
        {
            char c = '~';

            builder.append(c);
            builder.append(x);
            builder.append(" ");
            builder.append(c);
            builder.append(z);
        }
        else
        {
            builder.append(x);
            builder.append(" ");
            builder.append(z);
        }

        return builder.toString();
    }
}

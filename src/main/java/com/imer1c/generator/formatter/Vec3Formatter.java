package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.world.pos.Vec3;

public class Vec3Formatter implements IFormatter<Vec3> {
    @Override
    public String format(Vec3 value)
    {
        double x = value.getX();
        double y = value.getY();
        double z = value.getZ();

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

package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.entity.Rotation;

public class RotationFormatter implements IFormatter<Rotation> {
    @Override
    public String format(Rotation value)
    {
        float yaw = value.getYaw();
        float pitch = value.getPitch();

        boolean relative = value.isRelative();

        StringBuilder builder = new StringBuilder();

        if (relative)
        {
            builder.append('~');
            builder.append(yaw);
            builder.append(" ");
            builder.append('~');
            builder.append(pitch);
        }
        else
        {
            builder.append(yaw);
            builder.append(" ");
            builder.append(pitch);
        }

        return builder.toString();
    }
}

package com.imer1c.generator.formatter;

import com.imer1c.api.minecraft.entity.Angle;

public class AngleFormatter implements IFormatter<Angle> {
    @Override
    public String format(Angle value)
    {
        boolean relative = value.isRelative();

        if (relative)
        {
            return "~" + value.getValue();
        }
        else
        {
            return String.valueOf(value.getValue());
        }
    }
}

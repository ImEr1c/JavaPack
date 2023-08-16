package com.imer1c.generator.data.events.advancement.breed.data;

import com.imer1c.utils.Range;

public class AdvancementDistance {
    private Range absolute, horizontal, x, y, z;

    public void setAbsolute(int value)
    {
        this.setAbsolute(value, value);
    }

    public void setAbsolute(int min, int max)
    {
        this.absolute = new Range(min, max);
    }

    public void setHorizontal(int value)
    {
        this.setHorizontal(value, value);
    }

    public void setHorizontal(int min, int max)
    {
        this.horizontal = new Range(min, max);
    }

    public void setX(int value)
    {
        this.setX(value, value);
    }

    public void setX(int min, int max)
    {
        this.x = new Range(min, max);
    }
    public void setY(int value)
    {
        this.setY(value, value);
    }

    public void setY(int min, int max)
    {
        this.y = new Range(min, max);
    }
    public void setZ(int value)
    {
        this.setZ(value, value);
    }

    public void setZ(int min, int max)
    {
        this.z = new Range(min, max);
    }

    public Range getAbsolute()
    {
        return absolute;
    }

    public Range getHorizontal()
    {
        return horizontal;
    }

    public Range getX()
    {
        return x;
    }

    public Range getY()
    {
        return y;
    }

    public Range getZ()
    {
        return z;
    }
}

package com.imer1c.impl;

public class ToggleableValue<B> {
    private final B value;
    private final boolean use;

    public ToggleableValue(B value, boolean use)
    {
        this.value = value;
        this.use = use;
    }

    public B getValue()
    {
        return value;
    }

    public boolean isUse()
    {
        return use;
    }

    @Override
    public String toString()
    {
        return this.use ? this.value.toString() : "!" + this.value.toString();
    }
}

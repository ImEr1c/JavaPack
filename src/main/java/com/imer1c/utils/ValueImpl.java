package com.imer1c.utils;

import com.imer1c.api.minecraft.utils.Value;

public class ValueImpl implements Value {
    private final String command;

    public ValueImpl(String command)
    {
        this.command = command;
    }

    public String getCommand()
    {
        return command;
    }
}

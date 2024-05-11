package com.imer1c.generator.commands;

import java.util.Map;

public class Command {
    private final Map<Integer, String> templates;

    public Command(Map<Integer, String> templates)
    {
        this.templates = templates;
    }

    public String buildCommand(int index, Object... args)
    {
        return String.format(this.templates.get(index), args);
    }

}

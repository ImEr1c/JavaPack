package com.imer1c.impl.minecraft.commands;

public class SayCommand extends AbstractCommand {
    @Override
    public String getId()
    {
        return "say";
    }

    public void say(String msg)
    {
        this.write(0, msg);
    }
}

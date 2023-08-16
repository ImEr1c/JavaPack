package com.imer1c.impl.minecraft.commands;

public class BroadcastNarrativeMessageCommand extends AbstractCommand {
    @Override
    public String getId()
    {
        return "me";
    }

    public void broadcastNarrativeMessage(String message)
    {
        this.write(0, message);
    }
}

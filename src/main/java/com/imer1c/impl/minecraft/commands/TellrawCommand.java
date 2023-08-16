package com.imer1c.impl.minecraft.commands;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.entity.player.IPlayer;

public class TellrawCommand extends AbstractCommand {
    @Override
    public String getId()
    {
        return "tellraw";
    }

    public void execute(IPlayer player, ITextComponent[] component)
    {
        this.write(0, player, this.formatArray(component));
    }

    private String formatArray(Object[] array)
    {
        if (array.length == 0)
        {
            return null;
        }

        if (array.length == 1)
        {
            return array[0].toString();
        }

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < array.length; i++)
        {
            if (i > 0)
            {
                builder.append(",");
            }

            builder.append(array[i].toString());
        }

        return builder.append("]").toString();
    }
}

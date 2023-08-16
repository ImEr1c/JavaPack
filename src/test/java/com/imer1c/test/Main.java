package com.imer1c.test;

import com.imer1c.api.JavaDataPack;
import com.imer1c.api.annotations.DataPackMain;
import com.imer1c.api.minecraft.IServer;
import com.imer1c.api.minecraft.chatting.text.ITextComponent;
import com.imer1c.api.minecraft.chatting.text.ITextComponentCreator;
import com.imer1c.api.minecraft.chatting.text.TextComponentColor;
import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawComponentBase;
import com.imer1c.api.minecraft.entity.target.Target;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.entity.target.Targetter;
import com.imer1c.api.minecraft.world.Dimensions;
import com.imer1c.api.minecraft.world.IWorld;

@DataPackMain(id = "salam")
public class Main extends JavaDataPack {

    @Override
    public void onTick()
    {
        IServer server = this.getServer();
        Targetter targetter = server.getTargetter();
        IWorld world = server.getWorld();
        ITextComponentCreator textComponentCreator = server.getTextComponentCreator();

        TargetSelector target = targetter.select(Target.ALL_PLAYERS);

        ITextComponent first = textComponentCreator.text("Apasa aici:");
        first.bold(true);
        first.color(TextComponentColor.YELLOW);
        first.underlined(true);

        ITellrawComponentBase second = textComponentCreator.tellrawText(" gigel");
        second.color(TextComponentColor.WHITE);
        second.italic(true);
        second.bold(false);
        second.underlined(false);
        second.hoverEvent(textComponentCreator.text("O furnica pe-un picior"));
        second.clickEvent(ITellrawComponentBase.ClickEventType.OPEN_URL, "https://mcstacker.net/");

    }

    @Override
    public void onLoad()
    {
        IWorld world = this.server.getWorld();
        ITextComponentCreator textComponentCreator = this.server.getTextComponentCreator();
        Targetter targetter = this.server.getTargetter();

        world.broadcastNarrativeMessage("A fost o data ca niciodata un Remus cu cioaca scoasa");
    }
}

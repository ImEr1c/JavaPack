package com.imer1c.impl.minecraft.chatting.text.tellraw;

import com.imer1c.api.minecraft.chatting.text.tellraw.ITellrawKeybindTextComponent;

public class TellrawKeybindTextComponent extends TellrawComponentBase implements ITellrawKeybindTextComponent {
    private final String keybind;

    public TellrawKeybindTextComponent(String keybind)
    {
        super(null);
        this.keybind = keybind;
    }
}

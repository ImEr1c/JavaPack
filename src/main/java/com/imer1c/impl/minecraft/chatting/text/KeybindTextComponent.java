package com.imer1c.impl.minecraft.chatting.text;

import com.imer1c.api.minecraft.chatting.text.IKeybindTextComponent;

public class KeybindTextComponent extends TextComponent implements IKeybindTextComponent {
    private final String keybind;
    public KeybindTextComponent(String keybind)
    {
        super(null);
        this.keybind = keybind;
    }
}

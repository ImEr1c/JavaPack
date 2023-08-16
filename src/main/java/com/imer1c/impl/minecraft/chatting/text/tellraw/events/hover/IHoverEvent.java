package com.imer1c.impl.minecraft.chatting.text.tellraw.events.hover;

public interface IHoverEvent<S> {
    String getAction();

    S getContents();
}

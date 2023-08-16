package com.imer1c.api.minecraft.chatting.text.tellraw;

import com.imer1c.api.minecraft.chatting.text.ITextComponent;

public interface ITellrawComponentBase extends ITextComponent {

    void clickEvent(ClickEventType type, String value);

    void hoverEvent(ITextComponent... text);

    void hoverEvent(HoverEventType type, String value);

    enum ClickEventType {
        RUN_COMMAND,
        COPY_TO_CLIPBOARD,
        SUGGEST_COMMAND,
        OPEN_URL
    }

    enum HoverEventType {
        SHOW_TEXT,
        SHOW_ENTITY,
        SHOW_ITEM
    }
}

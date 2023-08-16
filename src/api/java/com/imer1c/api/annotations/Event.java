package com.imer1c.api.annotations;

import com.imer1c.api.minecraft.events.EventType;

public @interface Event {
    EventType type();
}

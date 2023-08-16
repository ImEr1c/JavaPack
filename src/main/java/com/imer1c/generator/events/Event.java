package com.imer1c.generator.events;

public class Event {
    private final EventType type;

    public Event(EventType type)
    {
        this.type = type;
    }

    public EventType getType()
    {
        return type;
    }

    public enum EventType {
        ADVANCEMENT,
        SCOREBOARD
    }
}

package com.imer1c;

import com.imer1c.api.minecraft.events.EventType;

import java.lang.reflect.Method;
import java.util.*;

public class DataPackEventListener {
    private final Map<EventType, List<Method>> events = new HashMap<>();

    public void addEventListener(EventType type, Method method)
    {
        List<Method> methods = this.events.computeIfAbsent(type, t -> new ArrayList<>());

        methods.add(method);
    }

    public Set<EventType> getEventTypes()
    {
        return this.events.keySet();
    }

    public List<Method> getListeners(EventType type)
    {
        return this.events.get(type);
    }
}

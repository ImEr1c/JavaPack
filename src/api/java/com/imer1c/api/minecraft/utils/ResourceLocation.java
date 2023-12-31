package com.imer1c.api.minecraft.utils;

public class ResourceLocation {
    private final String namespace;
    private final String path;

    public ResourceLocation(String namespace, String path)
    {
        this.namespace = namespace;
        this.path = path;
    }

    public static ResourceLocation minecraft(String path)
    {
        return new ResourceLocation("minecraft", path);
    }

    @Override
    public String toString()
    {
        return this.namespace + ":" + path;
    }
}

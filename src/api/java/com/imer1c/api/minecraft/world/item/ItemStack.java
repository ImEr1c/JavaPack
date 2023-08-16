package com.imer1c.api.minecraft.world.item;

public class ItemStack {
    private final String itemId;
    private final String nbt;

    public ItemStack(String itemId, String nbt)
    {
        this.itemId = itemId;
        this.nbt = nbt;
    }

    public String getItemId()
    {
        return itemId;
    }

    public String getNbt()
    {
        return nbt;
    }
}

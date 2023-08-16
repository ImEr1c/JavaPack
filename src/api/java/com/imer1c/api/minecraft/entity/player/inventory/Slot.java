package com.imer1c.api.minecraft.entity.player.inventory;

public class Slot {
    private final SlotType type;
    private final int slot;

    public Slot(SlotType type, int slot)
    {
        this.type = type;
        this.slot = slot;
    }

    public Slot(SlotType type)
    {
        this.type = type;
        this.slot = -1;
    }

    public int getSlot()
    {
        return slot;
    }

    public SlotType getType()
    {
        return type;
    }
}

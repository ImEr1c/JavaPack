package com.imer1c.api.minecraft.entity.player.inventory;

public interface IPlayerInventory {
    void clear();

    void clear(String itemId);

    void clear(String itemId, int count);
}

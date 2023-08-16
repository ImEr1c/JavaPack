package com.imer1c.generator.data.events.advancement.breed.data;

import com.google.gson.annotations.SerializedName;
import com.imer1c.api.minecraft.entity.EntityType;

public class AdvancementEntity {
    private EntityType type;
    private String nbt;
    private AdvancementEntityFlags flags;
    @SerializedName("lightning_bolt")
    private AdvancementLightningBolt lightningBolt;
    private AdvancementDistance distance;
}

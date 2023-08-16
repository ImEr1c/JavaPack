package com.imer1c.generator.data.events.advancement.breed.data;

import com.google.gson.annotations.SerializedName;

public class AdvancementLightningBolt {
    @SerializedName("blocks_set_on_fire")
    private int blocksSetOnFire;

    public int getBlocksSetOnFire()
    {
        return blocksSetOnFire;
    }

    public void setBlocksSetOnFire(int blocksSetOnFire)
    {
        this.blocksSetOnFire = blocksSetOnFire;
    }
}

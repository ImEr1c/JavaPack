package com.imer1c.generator.data.events.advancement.breed.data;

import com.google.gson.annotations.SerializedName;

public class AdvancementEntityFlags {
    @SerializedName("is_on_fire")
    private boolean onFire;
    @SerializedName("is_sneaking")
    private boolean sneaking;
    @SerializedName("is_sprinting")
    private boolean sprinting;
    @SerializedName("is_swimming")
    private boolean swimming;
    @SerializedName("is_baby")
    private boolean baby;

    public boolean isOnFire()
    {
        return onFire;
    }

    public void setOnFire(boolean onFire)
    {
        this.onFire = onFire;
    }

    public boolean isSneaking()
    {
        return sneaking;
    }

    public void setSneaking(boolean sneaking)
    {
        this.sneaking = sneaking;
    }

    public boolean isSprinting()
    {
        return sprinting;
    }

    public void setSprinting(boolean sprinting)
    {
        this.sprinting = sprinting;
    }

    public boolean isSwimming()
    {
        return swimming;
    }

    public void setSwimming(boolean swimming)
    {
        this.swimming = swimming;
    }

    public boolean isBaby()
    {
        return baby;
    }

    public void setBaby(boolean baby)
    {
        this.baby = baby;
    }
}

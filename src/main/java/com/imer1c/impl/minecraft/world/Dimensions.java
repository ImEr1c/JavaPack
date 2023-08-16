package com.imer1c.impl.minecraft.world;

import com.imer1c.api.APIData;
import com.imer1c.api.minecraft.utils.ResourceLocation;

public class Dimensions {
    public static void init()
    {
        APIData.registerData("dim.overworld", ResourceLocation.minecraft("overworld"));
        APIData.registerData("dim.nether", ResourceLocation.minecraft("the_nether"));
        APIData.registerData("dim.end", ResourceLocation.minecraft("the_end"));
    }
}

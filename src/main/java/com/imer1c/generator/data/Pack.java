package com.imer1c.generator.data;

import com.google.gson.annotations.SerializedName;

public class Pack {
    @SerializedName("pack_format")
    private final int packFormat;
    private final String description;

    public Pack(int packFormat, String description)
    {
        this.packFormat = packFormat;
        this.description = description;
    }
}

package com.imer1c.utils;

import com.google.gson.annotations.JsonAdapter;
import com.imer1c.generator.formatter.json.UnSetBooleanJsonAdapter;

@JsonAdapter(UnSetBooleanJsonAdapter.class)
public class UnSetBoolean {
    public final boolean value;

    public UnSetBoolean(boolean value)
    {
        this.value = value;
    }
}

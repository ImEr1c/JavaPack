package com.imer1c.utils;

import com.imer1c.generator.Generator;

public class VersionLimitUtils {

    private static int version;

    public static void setVersion(int version)
    {
        VersionLimitUtils.version = version;
    }

    public static void limitVersion(int min, LimitType type)
    {
        if (version < min)
        {
            throw new RuntimeException("This " + type.name().toLowerCase() + " can only be accessed with the version " + min + " or above");
        }
    }

    public enum LimitType {
        CLASS,
        METHOD,
        FIELD
    }
}

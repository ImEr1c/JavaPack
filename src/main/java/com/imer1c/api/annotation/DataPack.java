package com.imer1c.api.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DataPack {
    int version() default 4;

    String id();

    String description() default "";
}

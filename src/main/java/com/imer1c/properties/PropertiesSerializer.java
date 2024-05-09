package com.imer1c.properties;

import com.imer1c.annotation.Property;
import com.imer1c.impl.ToggleableValue;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

public class PropertiesSerializer {
    public static<C> String serialize(Class<C> c, C obj)
    {
        StringBuilder builder = new StringBuilder("[");

        Field[] fields = c.getFields();

        try
        {
            for (Field f : fields)
            {
                Object object = f.get(obj);

                String name;

                if (f.isAnnotationPresent(Property.class))
                {
                    Property property = f.getAnnotation(Property.class);

                    if (!property.expose())
                    {
                        continue;
                    }

                    name = property.id();
                }
                else
                {
                    name = f.getName();
                }

                if (object == null || object instanceof Integer i && i == 0)
                {
                    continue;
                }

                if (object instanceof List<?> list)
                {
                    if (list.isEmpty())
                    {
                        continue;
                    }

                    list.forEach(o -> {
                        builder.append(name).append("=").append(o).append(",");
                    });

                    continue;
                }

                String val = object instanceof Enum<?> e ? e.name().toLowerCase(Locale.ROOT) : object.toString();

                builder.append(name).append("=").append(val);
                builder.append(",");
            }
        } catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }

        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");

        return builder.toString();
    }
}

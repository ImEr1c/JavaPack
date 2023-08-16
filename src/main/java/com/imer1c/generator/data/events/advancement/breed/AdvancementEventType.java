package com.imer1c.generator.data.events.advancement.breed;

import com.imer1c.generator.data.events.advancement.IAdvancementEventCondition;

import java.util.function.Supplier;

public enum AdvancementEventType {
    BRED_ANIMALS("bred_animals", BreedAnimalsConditions::new);

    private final String id;
    private final Supplier<IAdvancementEventCondition> conditionSupplier;

    AdvancementEventType(String id, Supplier<IAdvancementEventCondition> conditionSupplier)
    {
        this.id = id;
        this.conditionSupplier = conditionSupplier;
    }

    public String getId()
    {
        return id;
    }

    public IAdvancementEventCondition buildCondition()
    {
        return this.conditionSupplier.get();
    }
}

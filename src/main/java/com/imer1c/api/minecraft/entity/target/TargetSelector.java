package com.imer1c.api.minecraft.entity.target;

import com.imer1c.api.util.Range;

public interface TargetSelector {

    /**
     * Limit the number of targets selected
     * @param limit the number of targets to select
     */
    TargetSelector limit(int limit);

    /**
     * Sorting algorithm to use
     * @param sort the sorting method
     */
    TargetSelector sort(Sort sort);

    /**
     * Select targets at a location
     * @param x x-coordinate
     * @param y y-coordinate
     * @param z z-coordinate
     */
    TargetSelector atLocation(int x, int y, int z);

    /**
     * Select targets within a radius. Paired with {@link #atLocation(int, int, int)} to specify the center of the radius to select targets within.
     * <p>
     * <p style='color: red;'>Note: This method cannot be used in conjunction with {@link #inVolume(int, int, int)}</p>
     *
     * @see #atLocation(int, int, int)
     * @param radius the radius to select targets within
     */
    TargetSelector inRadius(Range radius);

    default TargetSelector inRadius(int min, int max) {
        return inRadius(Range.of(min, max));
    }

    default TargetSelector inRadius(int radius) {
        return inRadius(radius, radius);
    }

    /**
     * Select targets within a volume. Paired with {@link #atLocation(int, int, int)} to specify the center of the volume to select targets within.
     * All the entities within the volume are selected.
     * <p>
     * <p style='color: red;'>Note: This method cannot be used in conjunction with {@link #inRadius(Range)}</p>
     *
     * @see #atLocation(int, int, int)
     *
     * @param dx the x-dimension of the volume
     * @param dy the y-dimension of the volume
     * @param dz the z-dimension of the volume
     */
    TargetSelector inVolume(int dx, int dy, int dz);

    /**
     * Selects targets with the speicified horizontal rotation. The rotation can vary from -90 (facing straight up) to 90 (facing straight down).
     * @param rotation the rotation to select targets with
     */
    TargetSelector verticalRotation(Range rotation);

    /**
     * Selects targets with the specified vertical rotation. The rotation can vary from -180 (facing north), to -90 (facing east), to 0 (facing south), to 90 (facing west).
     * @param rotation the rotation to select targets with
     */
    TargetSelector horizontalRotation(Range rotation);

    /**
     * Selects targets with the specified name. Players and entities can be targeted with this.
     * <p style='color: red;'>Note: This method cannot be used in conjunction with {@link #notName(String)}</p>
     * @param name the name of the target
     */
    TargetSelector name(String name);

    /**
     * Selects targets that are not named the specified name. Players and entities can be targeted with this.
     * <p style='color: red;'>Note: This method cannot be used in conjunction with {@link #name(String)}</p>
     *
     * @param name the name of the target
     */
    TargetSelector notName(String name);

    /**
     * Selects targets with the specified nbt tag. For example, you can check for entities on ground using {OnGround:1b}.
     * @param nbt the nbt tag to select targets with
     */
    TargetSelector nbt(String nbt);

    /**
     * Selects targets that are not named the specified nbt tag. For example, you can check for entities not on ground using {OnGround:1b}.
     * @param nbt the nbt tag to select targets with
     */
    TargetSelector notNbt(String nbt);

    //TODO: Add teams

    /**
     * Selects targets with the specified game mode. Players can be targeted with this.
     * @param gameMode the game mode to select targets with
     */
    TargetSelector gameMode(GameMode gameMode);

    /**
     * Selects targets that are not in the specified game mode. Players can be targeted with this.
     * @param gameMode the game mode to select targets with
     */
    TargetSelector notGameMode(GameMode gameMode);

    /**
     * Selects targets with the specified xp level. Players can be targeted with this.
     * @param level the xp level to select targets with
     */
    TargetSelector xpLevel(Range level);

    /**
     * Selects targets that are tagged with the specified tag. Note: Can be used multiple times, as well as with {@link #notTag(String)}.
     * @param tag the tag to select targets with
     */
    TargetSelector tag(String tag);

    /**
     * Selects targets that are not tagged with the specified tag. Note: Can be used multiple times, as well as with {@link #tag(String)}.
     * @param tag the tag to select targets with
     */
    TargetSelector notTag(String tag);

    //TODO: Add advancements, predicates and scores
}

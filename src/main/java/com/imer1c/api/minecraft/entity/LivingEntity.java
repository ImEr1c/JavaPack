package com.imer1c.api.minecraft.entity;

public interface LivingEntity {

    /**
     * Teleport the entity to the given coordinates
     * @param x x-coordinate
     * @param y y-coordinate
     * @param z z-coordinate
     */
    void teleport(double x, double y, double z);

    /**
     * Teleport the entity to the given coordinates with the given yaw and pitch
     * @param x x-coordinate
     * @param y y-coordinate
     * @param z z-coordinate
     * @param yaw yaw
     * @param pitch pitch
     */
    void teleport(double x, double y, double z, float yaw, float pitch);

    /**
     * Teleport the entity to the another entity
     * @param entity entity to teleport to
     */
    void teleport(LivingEntity entity);
}

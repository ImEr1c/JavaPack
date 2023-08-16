package com.imer1c.api.minecraft.entity;

import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.DamageType;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.pos.Vec3;

public interface ILivingEntity {
    void damage(float damage);

    void damage(float damage, DamageType damageType);

    void damageAtLocation(float damage, DamageType damageType, BlockPos pos);

    void damageByEntity(float damage, DamageType damageType, ILivingEntity entity);

    void damageByEntity(float damage, DamageType damageType, ILivingEntity entity, ILivingEntity cause);

    void kill();

    Value killAndCount();

    void addTag(String tag);

    void removeTag(String tag);

    Value countTags();

    void tp(ILivingEntity entity);

    void tp(BlockPos pos);

    void tp(BlockPos pos, Rotation rotation);

    void tp(BlockPos pos, Vec3 facingBlock);

    void tp(BlockPos pos, ILivingEntity facingEntity, EntityAnchor entityAnchor);
}

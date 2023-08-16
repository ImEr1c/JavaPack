package com.imer1c.impl.minecraft.entity;

import com.imer1c.api.minecraft.entity.EntityAnchor;
import com.imer1c.api.minecraft.entity.ILivingEntity;
import com.imer1c.api.minecraft.entity.Rotation;
import com.imer1c.api.minecraft.entity.target.TargetSelector;
import com.imer1c.api.minecraft.utils.Value;
import com.imer1c.api.minecraft.world.pos.BlockPos;
import com.imer1c.api.minecraft.world.DamageType;
import com.imer1c.api.minecraft.world.IWorld;
import com.imer1c.api.minecraft.world.pos.Vec3;
import com.imer1c.generator.formatter.Formatters;
import com.imer1c.impl.minecraft.commands.CommandManager;

import java.util.UUID;

public class LivingEntity implements ILivingEntity {
    private final TargetSelector target;
    private final UUID uuid;
    protected final IWorld world;

    public LivingEntity(TargetSelector target, IWorld world)
    {
        this.target = target;
        this.uuid = null;
        this.world = world;
    }

    public LivingEntity(UUID uuid, IWorld world)
    {
        this.uuid = uuid;
        this.world = world;
        this.target = null;
    }

    @Override
    public void damage(float damage)
    {
        CommandManager.damage.normal(this, damage);
    }

    @Override
    public void damage(float damage, DamageType damageType)
    {
        CommandManager.damage.withType(this, damage, damageType);
    }

    @Override
    public void damageAtLocation(float damage, DamageType damageType, BlockPos pos)
    {
        CommandManager.damage.atLocation(this, damage, damageType, pos);
    }

    @Override
    public void damageByEntity(float damage, DamageType damageType, ILivingEntity entity)
    {
        CommandManager.damage.byEntity(this, damage, damageType, entity);
    }

    @Override
    public void damageByEntity(float damage, DamageType damageType, ILivingEntity entity, ILivingEntity cause)
    {
        CommandManager.damage.byEntityWithCause(this, damage, damageType, entity, cause);
    }

    @Override
    public void kill()
    {
        CommandManager.kill.kill(this);
    }

    @Override
    public Value killAndCount()
    {
        return CommandManager.kill.killAndCount(this);
    }

    @Override
    public void addTag(String tag)
    {
        CommandManager.tag.add(this, tag);
    }

    @Override
    public void removeTag(String tag)
    {
        CommandManager.tag.remove(this, tag);
    }

    @Override
    public Value countTags()
    {
        return CommandManager.tag.count(this);
    }

    @Override
    public void tp(ILivingEntity entity)
    {
        CommandManager.tp.tp(this, entity);
    }

    @Override
    public void tp(BlockPos pos)
    {
        CommandManager.tp.tp(this, pos);
    }

    @Override
    public void tp(BlockPos pos, Rotation rotation)
    {
        CommandManager.tp.tp(this, pos, rotation);
    }

    @Override
    public void tp(BlockPos pos, Vec3 facingBlock)
    {
        CommandManager.tp.tp(this, pos, facingBlock);
    }

    @Override
    public void tp(BlockPos pos, ILivingEntity facingEntity, EntityAnchor entityAnchor)
    {
        CommandManager.tp.tp(this, pos, facingEntity, entityAnchor);
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public TargetSelector getTarget()
    {
        return target;
    }

    @Override
    public String toString()
    {
        return Formatters.format(this);
    }
}

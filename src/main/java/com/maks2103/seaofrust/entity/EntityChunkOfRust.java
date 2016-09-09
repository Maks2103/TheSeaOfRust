package com.maks2103.seaofrust.entity;

import com.maks2103.seaofrust.client.particle.Particles;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.Random;

public class EntityChunkOfRust extends EntityThrowable {
    private static final byte DAMAGE = 10;

    public EntityChunkOfRust(World world) {
        super(world);
    }

    public EntityChunkOfRust(World world, EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
    }

    public EntityChunkOfRust(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onImpact(MovingObjectPosition objectPosition) {
        if(this.worldObj.isRemote) {
            return;
        }

        EntityLivingBase thrower = getThrower();

        if(objectPosition.entityHit != null) {
            double damage = 1 / Vec3.createVectorHelper(objectPosition.entityHit.posX, objectPosition.entityHit.posY, objectPosition.entityHit.posZ).distanceTo(Vec3.createVectorHelper(thrower.posX, thrower.posY, thrower.posZ)) * DAMAGE;
            objectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, thrower), (float) damage);
        }

        Random random = new Random();
        double range = 0.1;

        for(int i = 0; i < 32; i++) {
            Particles.spawnParticle("chunkOfRust", posX, posY, posZ, random.nextDouble() * range * 2 - range, random.nextDouble() * range * 2 - range, random.nextDouble() * range * 2 - range);
        }

        setDead();
    }
}

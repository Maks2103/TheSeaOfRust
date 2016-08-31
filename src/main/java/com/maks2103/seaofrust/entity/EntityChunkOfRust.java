package com.maks2103.seaofrust.entity;

import com.maks2103.seaofrust.client.particle.Particles;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityChunkOfRust extends EntityThrowable {
    private static final byte DAMAGE = 2;

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
        if(objectPosition.entityHit != null) {
            objectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float) DAMAGE);
        }

        for(int i = 0; i < 8; ++i) {
            Particles.spawnParticle("chunkOfRust", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if(!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}

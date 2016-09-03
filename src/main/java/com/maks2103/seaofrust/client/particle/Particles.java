package com.maks2103.seaofrust.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class Particles {
    //    private static final Random random = new Random();
//
//    public static void spawnChunkOfRustParticle(Entity entity) {
//        double motionX = random.nextGaussian() * 0.02D;
//        double motionY = random.nextGaussian() * 0.02D;
//        double motionZ = random.nextGaussian() * 0.02D;
//        EntityFX chunkOfRustFX = new ChunkOfRustFX(
//                entity.worldObj,
//                entity.posX + random.nextFloat() * entity.width
//                        * 2.0F - entity.width,
//                entity.posY + 0.5D + random.nextFloat()
//                        * entity.height,
//                entity.posZ + random.nextFloat() * entity.width
//                        * 2.0F - entity.width,
//                motionX,
//                motionY,
//                motionZ);
//        Minecraft.getMinecraft().effectRenderer.addEffect(chunkOfRustFX);
//        Minecraft.getMinecraft().renderGlobal.
//    }
    private static Minecraft mc = Minecraft.getMinecraft();
    private static World theWorld = mc.theWorld;

    public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12) {
        if(mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
            int var14 = mc.gameSettings.particleSetting;

            if(var14 == 1 && theWorld.rand.nextInt(3) == 0) {
                var14 = 2;
            }

            double var15 = mc.renderViewEntity.posX - par2;
            double var17 = mc.renderViewEntity.posY - par4;
            double var19 = mc.renderViewEntity.posZ - par6;
            EntityFX var21 = null;
            double var22 = 16.0D;

            if(var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
                return null;
            } else if(var14 > 1) {
                return null;
            } else {
                if(particleName.equals("chunkOfRust")) {
                    var21 = new ChunkOfRustFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
                }


                mc.effectRenderer.addEffect(var21);
                return (EntityFX) var21;
            }
        }
        return null;
    }
}

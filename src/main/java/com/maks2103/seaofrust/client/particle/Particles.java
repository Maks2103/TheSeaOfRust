package com.maks2103.seaofrust.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;

@SideOnly(Side.CLIENT)
public class Particles {
    public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12) {
        if(Minecraft.getMinecraft() != null && Minecraft.getMinecraft().renderViewEntity != null && Minecraft.getMinecraft().effectRenderer != null) {
            int var14 = Minecraft.getMinecraft().gameSettings.particleSetting;

            if(var14 == 1 && Minecraft.getMinecraft().theWorld.rand.nextInt(3) == 0) {
                var14 = 2;
            }

            double var15 = Minecraft.getMinecraft().renderViewEntity.posX - par2;
            double var17 = Minecraft.getMinecraft().renderViewEntity.posY - par4;
            double var19 = Minecraft.getMinecraft().renderViewEntity.posZ - par6;
            EntityFX var21 = null;
            double var22 = 16.0D;

            if(var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
                return null;
            } else if(var14 > 1) {
                return null;
            } else {
                if(particleName.equals("chunkOfRust")) {
                    var21 = new ChunkOfRustFX(Minecraft.getMinecraft().theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
                }

                Minecraft.getMinecraft().effectRenderer.addEffect(var21);
                return var21;
            }
        }
        return null;
    }
}

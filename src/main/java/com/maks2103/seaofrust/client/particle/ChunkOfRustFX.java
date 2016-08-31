package com.maks2103.seaofrust.client.particle;

import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.world.World;

import java.awt.*;

public class ChunkOfRustFX extends EntitySnowShovelFX {

    ChunkOfRustFX(World world, double x, double y, double z, double d1, double d2, double d3) {
        super(world, x, y, z, d1, d2, d3);
        float[] components = new Color(151, 84, 54).getRGBColorComponents(null);
        setRBGColorF(components[0], components[1], components[2]);
    }
}

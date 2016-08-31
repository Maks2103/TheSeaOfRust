package com.maks2103.seaofrust.entity;

import com.maks2103.seaofrust.item.ModItems;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class ModEntities {
    private static int id = 0;

    public static void init() {
        EntityRegistry.registerModEntity(EntityChunkOfRust.class, "SeaOfRustEntityChunkOfRust", id++, "seaofrust", 64, 10, true);
    }

    public static void clinit() {
        RenderingRegistry.registerEntityRenderingHandler(EntityChunkOfRust.class, new RenderSnowball(ModItems.chunkOfRust));
    }
}

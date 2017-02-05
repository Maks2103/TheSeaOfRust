package com.maks2103.seaofrust.entity;

import com.maks2103.seaofrust.item.ModItems;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderSnowball;

import static cpw.mods.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;

public class ModEntities {
    private static int id = 0;

    public static void init() {
        EntityRegistry.registerModEntity(EntityChunkOfRust.class, "SeaOfRustEntityChunkOfRust", id++, "seaofrust", 64, 10, true);
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
        registerEntityRenderingHandler(EntityChunkOfRust.class, new RenderSnowball(ModItems.chunkOfRust));
    }
}

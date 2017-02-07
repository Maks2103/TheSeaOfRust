package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItems {
    public static final ItemRust RUST = new ItemRust();
    public static final ItemChunkOfRust CHUNK_OF_RUST = new ItemChunkOfRust();
    public static final ItemModBucket ENERGON_REFINEMENT_WASTE_BUCKET = new ItemModBucket(ModBlocks.ENERGON_REFINEMENT_WASTE);
    public static final ItemModBucket ENERGON_BUCKET = new ItemModBucket(ModBlocks.ENERGON);
    public static final ItemModBucket REFINED_ENERGON_BUCKET = new ItemModBucket(ModBlocks.REFINED_ENERGON);

    public static void init() {
        GameRegistry.registerItem(RUST, "rust");
        GameRegistry.registerItem(CHUNK_OF_RUST, "chunk_of_rust");
        GameRegistry.registerItem(ENERGON_REFINEMENT_WASTE_BUCKET, "bucket_of_energon_refinemend_waste");
        GameRegistry.registerItem(ENERGON_BUCKET, "bucket_of_energon");
        GameRegistry.registerItem(REFINED_ENERGON_BUCKET, "bucket_of_refined_energon");
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
    }
}

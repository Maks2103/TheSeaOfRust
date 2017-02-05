package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModItems {
    public static ItemRust rust;
    public static ItemChunkOfRust chunkOfRust;
    public static ItemModBucket energonRefinementWasteBucket;
    public static ItemModBucket energonBucket;
    public static ItemModBucket refinedEnergonBucket;

    public static void init() {
        GameRegistry.registerItem(rust = new ItemRust(), "rust");
        GameRegistry.registerItem(chunkOfRust = new ItemChunkOfRust(), "chunk_of_rust");
        GameRegistry.registerItem(energonRefinementWasteBucket = new ItemModBucket(ModBlocks.ENERGON_REFINEMENT_WASTE), "bucket_of_energon_refinemend_waste");
        GameRegistry.registerItem(energonBucket = new ItemModBucket(ModBlocks.ENERGON), "bucket_of_energon");
        GameRegistry.registerItem(refinedEnergonBucket = new ItemModBucket(ModBlocks.REFINED_ENERGON), "bucket_of_refined_energon");
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {

    }
}

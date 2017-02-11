package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.block.ModBlocks;
import com.maks2103.seaofrust.fluid.ModFluids;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;

public class ModItems {
    public static final ItemRust RUST = new ItemRust();
    public static final ItemRefinedEnergonCrystal REFINED_ENERGON_CRYSTAL = new ItemRefinedEnergonCrystal();
    public static final ItemChunkOfRust CHUNK_OF_RUST = new ItemChunkOfRust();
    public static final ItemModBucket ENERGON_REFINEMENT_WASTE_BUCKET = new ItemModBucket(ModBlocks.ENERGON_REFINEMENT_WASTE);
    public static final ItemModBucket ENERGON_BUCKET = new ItemModBucket(ModBlocks.ENERGON);
    public static final ItemModBucket REFINED_ENERGON_BUCKET = new ItemModBucket(ModBlocks.REFINED_ENERGON);
//    public static final ItemEnergonSword ENERGON_SWORD = new ItemEnergonSword();

    public static void init() {
        GameRegistry.registerItem(RUST, "rust");
        GameRegistry.registerItem(REFINED_ENERGON_CRYSTAL, "refined_energon_crystal");
        GameRegistry.registerItem(CHUNK_OF_RUST, "chunk_of_rust");
        GameRegistry.registerItem(ENERGON_REFINEMENT_WASTE_BUCKET, "bucket_of_energon_refinemend_waste");
        FluidContainerRegistry.registerFluidContainer(ModFluids.ENERGON_REFINEMENT_WASTE, new ItemStack(ENERGON_REFINEMENT_WASTE_BUCKET), new ItemStack(Items.bucket));
        GameRegistry.registerItem(ENERGON_BUCKET, "bucket_of_energon");
        FluidContainerRegistry.registerFluidContainer(ModFluids.ENERGON, new ItemStack(ENERGON_BUCKET), new ItemStack(Items.bucket));
        GameRegistry.registerItem(REFINED_ENERGON_BUCKET, "bucket_of_refined_energon");
        FluidContainerRegistry.registerFluidContainer(ModFluids.REFINED_ENERGON, new ItemStack(REFINED_ENERGON_BUCKET), new ItemStack(Items.bucket));
//        GameRegistry.registerItem(ENERGON_SWORD, "energon_sword");
    }

    @SideOnly(Side.CLIENT)
    public static void clientInit() {
    }
}

package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.item.ItemBlockRustyDust;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlocks {
    public static BlockRustyDust rustyDust;
    public static BlockRustedSand rustedSand;
    public static BlockRustyIron rustyIron;
    public static BlockGrapplePoint grapplePoint;
    public static BlockEnergonRefinementWaste energonRefinemendWasteBlock;
    public static BlockEnergon energonBlock;
    public static BlockRefinedEnergon refinedEnergonBlock;

    public static void init() {
        GameRegistry.registerBlock(rustyDust = new BlockRustyDust(), ItemBlockRustyDust.class, "rusty_dust");
        GameRegistry.registerBlock(rustedSand = new BlockRustedSand(), "rusted_sand");
        GameRegistry.registerBlock(rustyIron = new BlockRustyIron(), "rusted_iron_block");
        GameRegistry.registerBlock(grapplePoint = new BlockGrapplePoint(), "grapple_point");
        GameRegistry.registerBlock(energonRefinemendWasteBlock = new BlockEnergonRefinementWaste(), "energon_refinement_waste");
        GameRegistry.registerBlock(energonBlock = new BlockEnergon(), "energon");
        GameRegistry.registerBlock(refinedEnergonBlock = new BlockRefinedEnergon(), "refined_energon");
    }

    @SideOnly(Side.CLIENT)
    public static void clinit() {

    }
}

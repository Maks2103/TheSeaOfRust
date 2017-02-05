package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.item.ItemBlockRustyDust;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlocks {
    public static final BlockRustyDust RUSTY_DUST = new BlockRustyDust();
    public static final BlockRustedSand RUSTED_SAND = new BlockRustedSand();
    public static final BlockRustyIron RUSTY_IRON = new BlockRustyIron();
    public static final BlockGrapplePoint GRAPPLE_POINT = new BlockGrapplePoint();
    public static final BlockEnergonRefinementWaste ENERGON_REFINEMENT_WASTE = new BlockEnergonRefinementWaste();
    public static final BlockEnergon ENERGON = new BlockEnergon();
    public static final BlockRefinedEnergon REFINED_ENERGON = new BlockRefinedEnergon();
    public static final BlockEnergonLamp ENERGON_LAMP = new BlockEnergonLamp(false);
    public static final BlockEnergonLamp ENERGON_LAMP_POWERED = new BlockEnergonLamp(true);

    public static void init() {
        GameRegistry.registerBlock(RUSTY_DUST, ItemBlockRustyDust.class, "rusty_dust");
        GameRegistry.registerBlock(RUSTED_SAND, "rusted_sand");
        GameRegistry.registerBlock(RUSTY_IRON, "rusted_iron_block");
        GameRegistry.registerBlock(GRAPPLE_POINT, "grapple_point");
        GameRegistry.registerBlock(ENERGON_REFINEMENT_WASTE, "energon_refinement_waste");
        GameRegistry.registerBlock(ENERGON, "energon");
        GameRegistry.registerBlock(REFINED_ENERGON, "refined_energon");
        GameRegistry.registerBlock(ENERGON_LAMP, "energon_lamp");
        GameRegistry.registerBlock(ENERGON_LAMP_POWERED, "energon_lamp_powered");
    }

    @SideOnly(Side.CLIENT)
    public static void cleintInit() {

    }
}

package com.maks2103.seaofrust.fluid;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;

public class FluidRegistry {
    public static Fluid refinementWaste = new Fluid("energon_refinement_waste");
    public static Fluid energon = new Fluid("energon");
    static Block refinemendWasteBlock;
    static Block energonBlock;

    public static void init() {
        refinementWaste.setTemperature(1500);
        net.minecraftforge.fluids.FluidRegistry.registerFluid(refinementWaste);
        net.minecraftforge.fluids.FluidRegistry.registerFluid(energon);
        GameRegistry.registerBlock(refinemendWasteBlock = new EnergonRefinementWasteFluid(), "energon_refinement_waste");
        GameRegistry.registerBlock(energonBlock = new EnergonFluid(), "energon");
    }
}

package com.maks2103.seaofrust.fluid;

import com.maks2103.seaofrust.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
    public static Fluid energonRefinementWaste = new Fluid("energon_refinement_waste");
    public static Fluid energon = new Fluid("energon");
    public static Fluid refinedEnergon = new Fluid("refined_energon");

    public static void init() {
        energonRefinementWaste.setTemperature(1500);
        FluidRegistry.registerFluid(energonRefinementWaste);
        FluidRegistry.registerFluid(energon);
        FluidRegistry.registerFluid(refinedEnergon);
    }
}

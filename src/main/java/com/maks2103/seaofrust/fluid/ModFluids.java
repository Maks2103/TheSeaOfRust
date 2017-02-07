package com.maks2103.seaofrust.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
    public static final Fluid ENERGON_REFINEMENT_WASTE = new Fluid("energon_refinement_waste").setTemperature(1500);
    public static final Fluid ENERGON = new Fluid("energon");
    public static final Fluid REFINED_ENERGON = new Fluid("refined_energon");

    public static void init() {
        FluidRegistry.registerFluid(ENERGON_REFINEMENT_WASTE);
        FluidRegistry.registerFluid(ENERGON);
        FluidRegistry.registerFluid(REFINED_ENERGON);
    }

    public static void clientInit() {
    }
}

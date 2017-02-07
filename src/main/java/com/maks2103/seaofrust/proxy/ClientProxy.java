package com.maks2103.seaofrust.proxy;

import com.maks2103.seaofrust.block.ModBlocks;
import com.maks2103.seaofrust.entity.ModEntities;
import com.maks2103.seaofrust.fluid.ModFluids;
import com.maks2103.seaofrust.item.ModItems;
import com.maks2103.seaofrust.recipe.ModRecipes;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        ModFluids.clientInit();
        ModBlocks.clientInit();
        ModItems.clientInit();
        ModEntities.clientInit();
        ModRecipes.clientInit();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}

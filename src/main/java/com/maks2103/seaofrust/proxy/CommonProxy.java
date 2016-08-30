package com.maks2103.seaofrust.proxy;

import com.maks2103.seaofrust.block.ModBlocks;
import com.maks2103.seaofrust.item.ModItems;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}

package com.maks2103.seaofrust;

import com.maks2103.seaofrust.block.ModBlocks;
import com.maks2103.seaofrust.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = SeaOfRust.MODID, version = SeaOfRust.VERSION, name = SeaOfRust.NAME, dependencies = "required-after:transformers;required-after:ThermalExpansion")
public class SeaOfRust {
    public static final String MODID = "seaofrust";
    public static final String NAME = "The Sea of Rust";
    public static final String VERSION = "0.0.2";

    public static CreativeTabs CREATIVE_TAB = new CreativeTabs("sea_of_rust") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.RUSTY_DUST);
        }
    };

    @SidedProxy(modId = MODID, clientSide = "com.maks2103.seaofrust.proxy.ClientProxy", serverSide = "com.maks2103.seaofrust.proxy.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}

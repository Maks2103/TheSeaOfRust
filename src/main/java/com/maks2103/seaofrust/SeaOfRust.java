package com.maks2103.seaofrust;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = SeaOfRust.MODID, version = SeaOfRust.VERSION, name = SeaOfRust.NAME)
public class SeaOfRust {
    public static final String MODID = "seaofrust";
    public static final String NAME = "The Sea of Rust";
    public static final String VERSION = "0.1";

    public static CreativeTabs tab;
    public static BlockRustyDust rustyDust;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tab = new CreativeTabs("sea_of_rust") {
            @Override
            public Item getTabIconItem() {
                return Item.getItemFromBlock(rustyDust);
            }
        };
        GameRegistry.registerBlock(rustyDust = new BlockRustyDust(), ItemBlockRustyDust.class, "rusty_dust");
    }
}

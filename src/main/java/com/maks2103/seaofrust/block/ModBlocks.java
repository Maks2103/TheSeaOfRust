package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.item.ItemBlockRustyDust;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static BlockRustyDust rustyDust;
    public static BlockRustedSand rustedSand;
    public static BlockRustyIron rustyIron;

    public static void init() {
        GameRegistry.registerBlock(rustyDust = new BlockRustyDust(), ItemBlockRustyDust.class, "rusty_dust");
        GameRegistry.registerBlock(rustedSand = new BlockRustedSand(), "rusted_sand");
        GameRegistry.registerBlock(rustyIron = new BlockRustyIron(), "rusted_iron_block");
    }

    public static void clinit() {

    }
}

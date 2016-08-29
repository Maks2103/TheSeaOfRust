package com.maks2103.seaofrust.blocks;

import com.maks2103.seaofrust.items.ItemBlockRustyDust;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static BlockRustyDust rustyDust;

    public static void init() {
        GameRegistry.registerBlock(rustyDust = new BlockRustyDust(), ItemBlockRustyDust.class, "rusty_dust");
    }

    public static void clinit() {

    }
}

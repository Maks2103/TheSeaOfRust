package com.maks2103.seaofrust.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemRust rust;
    public static ItemChunkOfRust chunkOfRust;

    public static void init() {
        GameRegistry.registerItem(rust = new ItemRust(), "rust");
        GameRegistry.registerItem(chunkOfRust = new ItemChunkOfRust(), "chunk_of_rust");
    }

    public static void clinit() {

    }
}

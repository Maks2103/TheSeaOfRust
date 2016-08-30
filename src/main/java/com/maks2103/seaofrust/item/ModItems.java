package com.maks2103.seaofrust.item;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemRust rust;

    public static void init() {
        GameRegistry.registerItem(rust = new ItemRust(), "rust");
    }

    public static void clinit() {

    }
}

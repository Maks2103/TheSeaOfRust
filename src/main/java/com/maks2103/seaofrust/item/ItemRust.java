package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.item.Item;

public class ItemRust extends Item {
    public ItemRust() {
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setUnlocalizedName("rust");
        setTextureName("seaofrust:rust");
    }
}

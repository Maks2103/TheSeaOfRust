package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ItemModBucket extends ItemBucket {
    public ItemModBucket(Block block) {
        super(block);
        this.setCreativeTab(SeaOfRust.CREATIVE_TAB);
        this.setContainerItem(Items.bucket);
        String unlocalizedName = block.getUnlocalizedName().substring(5);
        this.setUnlocalizedName("bucket_of_" + unlocalizedName);
        this.setTextureName("seaofrust:bucket_of_" + unlocalizedName);
    }
}

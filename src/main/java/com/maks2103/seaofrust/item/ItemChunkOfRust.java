package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.SeaOfRust;
import com.maks2103.seaofrust.entity.EntityChunkOfRust;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChunkOfRust extends Item {

    public ItemChunkOfRust() {
        this.setCreativeTab(SeaOfRust.CREATIVE_TAB);
        this.setUnlocalizedName("chunk_of_rust");
        this.setTextureName("seaofrust:chunk_of_rust");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if(!world.isRemote) {
            world.spawnEntityInWorld(new EntityChunkOfRust(world, player));
        }
        return stack;
    }
}

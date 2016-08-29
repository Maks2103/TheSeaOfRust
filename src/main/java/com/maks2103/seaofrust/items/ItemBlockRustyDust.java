package com.maks2103.seaofrust.items;

import com.maks2103.seaofrust.blocks.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static com.maks2103.seaofrust.blocks.ModBlocks.rustyDust;

public class ItemBlockRustyDust extends ItemBlock {
    public ItemBlockRustyDust(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int meta, float ux, float uy, float uz) {
        Block block = world.getBlock(x, y, z);

        if(block != ModBlocks.rustyDust && world.getBlockMetadata(x, y, z) < 7) {
            y++;
        }
        System.out.println(String.valueOf(world.getBlockMetadata(x, y, z)));
        if(itemStack.stackSize == 0) {
            return false;
        } else if(!player.canPlayerEdit(x, y, z, meta, itemStack)) {
            return false;
        } else if(y == 255 && this.field_150939_a.getMaterial().isSolid()) {
            return false;
        } else if(block == ModBlocks.rustyDust && world.getBlockMetadata(x, y, z) < 7) {
            world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 2);
            --itemStack.stackSize;
            return true;
        } else if(world.canPlaceEntityOnSide(this.field_150939_a, x, y, z, false, meta, player, itemStack)) {
            int i1 = this.getMetadata(itemStack.getItemDamage());
            int j1 = this.field_150939_a.onBlockPlaced(world, x, y, z, meta, ux, uy, uz, i1);

            if(placeBlockAt(itemStack, player, world, x, y, z, meta, ux, uy, uz, j1)) {
                world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
                --itemStack.stackSize;
            }

            return true;
        } else {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_150936_a(World world, int x, int y, int z, int meta, EntityPlayer player, ItemStack itemStack) {
        Block block = world.getBlock(x, y, z);
        if(block != ModBlocks.rustyDust && world.getBlockMetadata(x, y, z) < 7) {
            y++;
        }

        return block == rustyDust || world.canPlaceEntityOnSide(this.field_150939_a, x, y, z, false, meta, null, itemStack);
    }
}

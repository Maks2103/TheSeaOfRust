package com.maks2103.seaofrust;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockRustyDust extends ItemBlock {
    public ItemBlockRustyDust(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int meta, float ux, float uy, float uz) {
        Block block = world.getBlock(x, y, z);
        if (block instanceof BlockRustyDust) {

        }
//        Block block = world.getBlock(x, y, z);
//
//        if (block == SeaOfRust.rustyDust && (world.getBlockMetadata(x, y, z) & 7) < 1) {
//            meta = 1;
//        } else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(world, x, y, z)) {
//            if (meta == 0) {
//                --y;
//            }
//
//            if (meta == 1) {
//                ++y;
//            }
//
//            if (meta == 2) {
//                --z;
//            }
//
//            if (meta == 3) {
//                ++z;
//            }
//
//            if (meta == 4) {
//                --x;
//            }
//
//            if (meta == 5) {
//                ++x;
//            }
//        }
////        System.out.println(world.getBlockMetadata(x, y, z));
//        if (itemStack.stackSize == 0) {
//            return false;
//        } else if (!player.canPlayerEdit(x, y, z, meta, itemStack)) {
//            return false;
//        } else if (y == 255 && this.field_150939_a.getMaterial().isSolid()) {
//            return false;
//        } else if (block == SeaOfRust.rustyDust && world.getBlockMetadata(x, y, z) < 7) {
////            world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 2, 3);
//            --itemStack.stackSize;
//            return true;
//        } else if (world.canPlaceEntityOnSide(this.field_150939_a, x, y, z, false, meta, player, itemStack)) {
//            int i1 = this.getMetadata(itemStack.getItemDamage());
//            int j1 = this.field_150939_a.onBlockPlaced(world, x, y, z, meta, ux, uy, uz, i1);
//
//            if (placeBlockAt(itemStack, player, world, x, y, z, meta, ux, uy, uz, j1)) {
//                world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
//                --itemStack.stackSize;
//            }
//
//            return true;
//        } else {
//            return false;
//        }
    }

    @SideOnly(Side.CLIENT)
    public boolean func_150936_a(World p_150936_1_, int p_150936_2_, int p_150936_3_, int p_150936_4_, int p_150936_5_, EntityPlayer p_150936_6_, ItemStack p_150936_7_) {
        Block block = p_150936_1_.getBlock(p_150936_2_, p_150936_3_, p_150936_4_);

        if (block == SeaOfRust.rustyDust) {
            p_150936_5_ = 1;
        } else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush && !block.isReplaceable(p_150936_1_, p_150936_2_, p_150936_3_, p_150936_4_)) {
            if (p_150936_5_ == 0) {
                --p_150936_3_;
            }

            if (p_150936_5_ == 1) {
                ++p_150936_3_;
            }

            if (p_150936_5_ == 2) {
                --p_150936_4_;
            }

            if (p_150936_5_ == 3) {
                ++p_150936_4_;
            }

            if (p_150936_5_ == 4) {
                --p_150936_2_;
            }

            if (p_150936_5_ == 5) {
                ++p_150936_2_;
            }
        }

        return block == SeaOfRust.rustyDust ? true : p_150936_1_.canPlaceEntityOnSide(this.field_150939_a, p_150936_2_, p_150936_3_, p_150936_4_, false, p_150936_5_, null, p_150936_7_);
    }
}

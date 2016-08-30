package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.block.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static com.maks2103.seaofrust.block.ModBlocks.rustyDust;

public class ItemBlockRustyDust extends ItemBlock {
    public ItemBlockRustyDust(Block block) {
        super(block);
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float ux, float uy, float uz) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        if(block == ModBlocks.rustyDust && itemStack.stackSize > 0 && meta < 7) {
            world.setBlockMetadataWithNotify(x, y, z, meta + 1, 2);
            --itemStack.stackSize;
            return true;
        } else if(itemStack.getItem() instanceof ItemBlockRustyDust && ((meta < 7 && side != 1) || side == 1)) { //1 is a top side
            y++;
            if(placeBlockAt(itemStack, player, world, x, y, z, side, ux, uy, uz, 0)) {
                --itemStack.stackSize;
                this.field_150939_a.onBlockPlaced(world, x, y, z, side, ux, uy, uz, meta);
                world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this.field_150939_a.stepSound.func_150496_b(), (this.field_150939_a.stepSound.getVolume() + 1.0F) / 2.0F, this.field_150939_a.stepSound.getPitch() * 0.8F);
            }
            return true;
        } else {
            return super.onItemUse(itemStack, player, world, x, y, z, meta, ux, uy, uz);
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

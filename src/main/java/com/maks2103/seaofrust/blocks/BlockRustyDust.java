package com.maks2103.seaofrust.blocks;

import com.maks2103.seaofrust.SeaOfRust;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.ArrayList;
import java.util.Random;

public class BlockRustyDust extends BlockFalling {
    public BlockRustyDust() {
        setStepSound(soundTypeSand);
        setCreativeTab(SeaOfRust.tab);
        setTickRandomly(true);
        setBlockName("rusty_dust");
        setBlockHeight(0);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("seaofrust:rusty_dust");
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        int l = world.getBlockMetadata(x, y, z) & 7;
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double) x + this.minX, (double) y + this.minY, (double) z + this.minZ, (double) x + this.maxX, (double) ((float) y + (float) l * f), (double) z + this.maxZ);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender() {
        this.setBlockHeight(0);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int x, int y, int z) {
        this.setBlockHeight(iBlockAccess.getBlockMetadata(x, y, z));
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y - 1, z);
        return (block != Blocks.ice && block != Blocks.packed_ice) && (block.isLeaves(world, x, y - 1, z) || (block == this && (world.getBlockMetadata(x, y - 1, z) & 7) == 7 || block.isOpaqueCube() && block.getMaterial().blocksMovement()));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(world.getBlock(x, y - 1, z) == ModBlocks.rustyDust && world.getBlockMetadata(x, y - 1, z) < 7) {
            int delta = 7 - world.getBlockMetadata(x, y - 1, z);
            if(delta >= world.getBlockMetadata(x, y, z)) {
                world.setBlockMetadataWithNotify(x, y - 1, z, world.getBlockMetadata(x, y - 1, z) + world.getBlockMetadata(x, y, z), 2);
                world.setBlockToAir(x, y, z);
            } else {
                int last = world.getBlockMetadata(x, y, z) - delta;
                world.setBlockMetadataWithNotify(x, y, z, last, 2);
                world.setBlockMetadataWithNotify(x, y - 1, z, 7, 2);
            }
        }
        world.notifyBlockOfNeighborChange(x, y + 1, z, ModBlocks.rustyDust);
        if (!this.canPlaceBlockAt(world, x, y, z) && world.getBlock(x, y, z) != ModBlocks.rustyDust) {
            world.setBlockToAir(x, y, z);
        }
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
        super.harvestBlock(world, player, x, y, z, meta);
        world.setBlockToAir(x, y, z);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random) {
        return 1;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return side == 1 || super.shouldSideBeRendered(blockAccess, x, y, z, side);
    }

    /**
     * Metadata and fortune sensitive version, this replaces the old (int meta, Random rand)
     * version in 1.1.
     *
     * @param meta    Blocks Metadata
     * @param fortune Current item fortune level
     * @param random  Random number generator
     * @return The number of items to drop
     */
    public int quantityDropped(int meta, int fortune, Random random) {
        return meta + 1;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float ux, float uy, float uz) {
        Item equippedItem = player.getCurrentEquippedItem().getItem();
        //TODO rewrite
        if(equippedItem instanceof ItemSpade) {
            player.getCurrentEquippedItem().damageItem(1, player);
            int blockMetadata = world.getBlockMetadata(x, y, z) - 1;
            if(blockMetadata < 0) {
                this.harvestBlock(world, player, x, y, z, blockMetadata + 1);
                return true;
            }
            ForgeEventFactory.fireBlockHarvesting(new ArrayList<>(), world, this, x, y, z, blockMetadata, 0, 1.0f, false, player);
            world.setBlockMetadataWithNotify(x, y, z, blockMetadata, 2);
            this.dropBlockAsItem(world, x, y, z, new ItemStack(Item.getItemFromBlock(ModBlocks.rustyDust)));
            world.notifyBlockOfNeighborChange(x, y + 1, z, ModBlocks.rustyDust);
            return true;
        }
        return false;
    }

    /**
     * Determines if a new block can be replace the space occupied by this one,
     * Used in the player's placement code to make the block act like water, and lava.
     *
     * @param world The current world
     * @param x     X Position
     * @param y     Y position
     * @param z     Z position
     * @return True if the block is replaceable by another block
     */
    public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
        int meta = world.getBlockMetadata(x, y, z);
        return meta < 7 && blockMaterial.isReplaceable();
    }

    private void setBlockHeight(int height) {
        int j = height & 7;
        float f = (float) (2 * (1 + j)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }
}

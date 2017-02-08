package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//import cpw.mods.fml.relauncher.Side;
//import cpw.mods.fml.relauncher.SideOnly;
//import net.minecraft.util.Facing;
//import net.minecraft.world.IBlockAccess;

public class BlockGrapplePoint extends Block {
    protected BlockGrapplePoint() {
        super(Material.iron);
        setBlockName("grapple_point");
        setBlockTextureName("seaofrust:grapple_point");
        setStepSound(soundTypeMetal);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setHardness(2.5F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
    }
//    @SideOnly(Side.CLIENT)
//    public int getRenderBlockPass()
//    {
//        return 1;
//    }
//
//    public boolean isOpaqueCube()
//    {
//        return false;
//    }
//
//    public boolean renderAsNormalBlock()
//    {
//        return false;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
//    {
//        Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);
//
//        if (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.getBlockMetadata(p_149646_2_ - Facing.offsetsXForSide[p_149646_5_], p_149646_3_ - Facing.offsetsYForSide[p_149646_5_], p_149646_4_ - Facing.offsetsZForSide[p_149646_5_]))
//        {
//            return true;
//        }
//
//        if (block == this)
//        {
//            return false;
//        }
//        return super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
//    }
}

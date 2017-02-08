package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockRefinedEnergonCube extends Block {
    protected BlockRefinedEnergonCube() {
        super(Material.glass);
        setBlockName("refined_energon_cube");
        setBlockTextureName("seaofrust:refined_energon_cube");
        setStepSound(soundTypeGlass);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setHardness(6.0F);
        setResistance(10.0F);
        setLightLevel(0.75F);
        setHarvestLevel("pickaxe", 1);
    }

    protected boolean canSilkHarvest() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return world.getBlock(x, y, z) != this && super.shouldSideBeRendered(world, x, y, z, side);
    }
}
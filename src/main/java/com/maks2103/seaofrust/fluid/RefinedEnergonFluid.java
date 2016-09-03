package com.maks2103.seaofrust.fluid;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class RefinedEnergonFluid extends BlockFluidClassic {
    private IIcon[] icons = new IIcon[2];

    public RefinedEnergonFluid() {
        super(FluidRegistry.refinedEnergon, Material.water);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setBlockName("refined_energon");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side > 1 ? icons[1] : icons[0];
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons[0] = iconRegister.registerIcon("seaofrust:refined_energon_still");
        icons[1] = iconRegister.registerIcon("seaofrust:refined_energon_flow");
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x, y, z) == FluidRegistry.energonBlock || world.getBlock(x, y, z) == Blocks.air;
    }
}

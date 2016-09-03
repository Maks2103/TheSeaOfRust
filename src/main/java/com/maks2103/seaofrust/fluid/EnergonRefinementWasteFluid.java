package com.maks2103.seaofrust.fluid;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class EnergonRefinementWasteFluid extends BlockFluidClassic {
    private IIcon[] icons = new IIcon[2];

    public EnergonRefinementWasteFluid() {
        super(FluidRegistry.refinementWaste, Material.lava);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setBlockName("energon_refinement_waste");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side > 1 ? icons[1] : icons[0];
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons[0] = iconRegister.registerIcon("seaofrust:energon_refinement_waste_still");
        icons[1] = iconRegister.registerIcon("seaofrust:energon_refinement_waste_flow");
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x, y, z) == FluidRegistry.refinemendWasteBlock || world.getBlock(x, y, z) == Blocks.air;
    }
}


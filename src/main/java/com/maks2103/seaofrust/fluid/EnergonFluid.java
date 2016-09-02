package com.maks2103.seaofrust.fluid;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;

public class EnergonFluid extends BlockFluidClassic {
    private IIcon[] icons = new IIcon[2];

    public EnergonFluid() {
        super(FluidRegistry.energon, Material.lava);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setBlockName("energon");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side > 1 ? icons[1] : icons[0];
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons[0] = iconRegister.registerIcon("seaofrust:energon_still");
        icons[1] = iconRegister.registerIcon("seaofrust:energon_flow");
    }
}

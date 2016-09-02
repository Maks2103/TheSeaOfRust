package com.maks2103.seaofrust.fluid;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
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

//    @Override
//    public void updateTick(World world, int x, int y, int z, Random rand) {
//        super.updateTick(world, x, y, z, rand);
//        EntityPlayer player = world.
//        if(player != null) {
//            player.attackEntityFrom(DamageSource.lava, 4.0F);
//        }
//    }
}



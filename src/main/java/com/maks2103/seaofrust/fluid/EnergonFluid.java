package com.maks2103.seaofrust.fluid;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class EnergonFluid extends BlockFluidClassic {
    private IIcon[] icons = new IIcon[2];

    public EnergonFluid() {
        super(FluidRegistry.energon, Material.water);
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

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x, y, z) == FluidRegistry.energonBlock || world.getBlock(x, y, z) == Blocks.air;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        entity.attackEntityFrom(DamageSource.cactus, 4.0F);
    }
}

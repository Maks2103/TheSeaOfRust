package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import com.maks2103.seaofrust.fluid.ModFluids;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

public class BlockEnergon extends BlockFluidClassic {
    private IIcon[] icons = new IIcon[2];

    public BlockEnergon() {
        super(ModFluids.ENERGON, Material.water);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setBlockName("energon");
        setLightLevel(0.75F);
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side == 1 ? icons[0] : icons[1];
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons[0] = iconRegister.registerIcon("seaofrust:energon_still");
        icons[1] = iconRegister.registerIcon("seaofrust:energon_flow");
        ModFluids.ENERGON.setIcons(icons[0], icons[1]);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        entity.attackEntityFrom(new DamageSource("energon"), 4.0F);
    }
}

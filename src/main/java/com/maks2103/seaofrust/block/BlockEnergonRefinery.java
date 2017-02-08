package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import com.maks2103.seaofrust.tile.TileEnergonRefinery;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnergonRefinery extends Block implements ITileEntityProvider {
    protected BlockEnergonRefinery() {
        super(Material.glass);
        setBlockName("energon_refinery");
        setStepSound(soundTypeMetal);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setHardness(2.5F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEnergonRefinery();
    }
}

package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGrapplePoint extends Block {
    protected BlockGrapplePoint() {
        super(Material.iron);
        setBlockName("grapple_point");
        setBlockTextureName("seaofrust:grapple_point");
        setStepSound(soundTypeMetal);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setHardness(5.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
    }
}

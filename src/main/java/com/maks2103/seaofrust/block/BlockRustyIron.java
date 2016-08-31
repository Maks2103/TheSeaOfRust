package com.maks2103.seaofrust.block;


import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRustyIron extends Block {
    protected BlockRustyIron() {
        super(Material.sand);
        setStepSound(soundTypeMetal);
        setBlockName("rusted_iron_block");
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setBlockTextureName("seaofrust:rusted_iron_block");
        setHardness(5.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 1);
    }
}

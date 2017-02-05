package com.maks2103.seaofrust.block;


import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

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
        setTickRandomly(true);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        for(int i = 0; i < 6; i++) {
            if(random.nextInt(10) == 0) {
                switch (i) {
                    case 0:
                        if(world.getBlock(x, y + 1, z) == Blocks.iron_block)
                            world.setBlock(x, y + 1, z, ModBlocks.RUSTY_IRON);
                        break;
                    case 1:
                        if(world.getBlock(x, y - 1, z) == Blocks.iron_block)
                            world.setBlock(x, y - 1, z, ModBlocks.RUSTY_IRON);
                        break;
                    case 2:
                        if(world.getBlock(x + 1, y, z) == Blocks.iron_block)
                            world.setBlock(x + 1, y, z, ModBlocks.RUSTY_IRON);
                        break;
                    case 3:
                        if(world.getBlock(x - 1, y, z) == Blocks.iron_block)
                            world.setBlock(x - 1, y, z, ModBlocks.RUSTY_IRON);
                        break;
                    case 4:
                        if(world.getBlock(x, y, z + 1) == Blocks.iron_block)
                            world.setBlock(x, y, z + 1, ModBlocks.RUSTY_IRON);
                        break;
                    case 5:
                        if(world.getBlock(x, y, z - 1) == Blocks.iron_block)
                            world.setBlock(x, y, z - 1, ModBlocks.RUSTY_IRON);
                        break;
                }
            }
        }
    }
}

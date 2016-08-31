package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockRustedSand extends BlockFalling {
    protected BlockRustedSand() {
        super(Material.sand);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setBlockName("rusted_sand");
        setStepSound(soundTypeSand);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon("seaofrust:rusted_sand");
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        if(!world.isRemote) {
            if(shouldFall(world, x, y, z) && y >= 0) {
                if(!fallInstantly && world.checkChunksExist(x - (byte) 32, y - (byte) 32, z - (byte) 32, x + (byte) 32, y + (byte) 32, z + (byte) 32)) {
                    if(!world.isRemote) {
                        EntityFallingBlock entityfallingblock = new EntityFallingBlock(world, (double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this, world.getBlockMetadata(x, y, z));
                        this.func_149829_a(entityfallingblock);
                        world.spawnEntityInWorld(entityfallingblock);
                    }
                } else {
                    world.setBlockToAir(x, y, z);

                    while(shouldFall(world, x, y, z) && y > 0) {
                        --y;
                    }

                    if(y > 0) {
                        world.setBlock(x, y, z, this);
                    }
                }
            }
        }
    }

    private boolean shouldFall(World world, int x, int y, int z) {
        Block block = world.getBlock(x, y - 1, z);
        EntityPlayer closestPlayer = world.getClosestPlayer(x, y, z, 3);
        return block.isAir(world, x, y - 1, z) && closestPlayer != null && y - closestPlayer.posY == -1;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if(entity instanceof EntityPlayer) {
            world.scheduleBlockUpdate(x, y, z, this, 20);
        }
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB aabb, List list, Entity entity) {
        if(entity instanceof EntityPlayer) {
            world.scheduleBlockUpdate(x, y, z, this, 0);
        }
        super.addCollisionBoxesToList(world, x, y, z, aabb, list, entity);
    }
}

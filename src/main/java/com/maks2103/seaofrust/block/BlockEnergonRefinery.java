package com.maks2103.seaofrust.block;

import com.maks2103.seaofrust.SeaOfRust;
import com.maks2103.seaofrust.tile.TileEnergonRefinery;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Arrays;

public class BlockEnergonRefinery extends Block implements ITileEntityProvider {
    private IIcon[][] icons = new IIcon[8][6];

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

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        world.setBlockMetadataWithNotify(
                x,
                y,
                z,
                new int[]{0, 3, 1, 2}[MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3],
                2
        );
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        for (int direction = 0; direction < 4; direction++) {
            for (boolean active : Arrays.asList(false, true)) {
                int meta = (active ? 4 : 0) + direction;
                icons[meta][0] = iconRegister.registerIcon("thermalexpansion:machine/Machine_Bottom");
                icons[meta][1] = iconRegister.registerIcon("thermalexpansion:machine/Machine_Top");
                icons[meta][2] = icons[meta][3] = icons[meta][4] = icons[meta][5] = iconRegister.registerIcon("thermalexpansion:machine/Machine_Side");
                icons[meta][2 + direction] = iconRegister.registerIcon("seaofrust:refinery_face" + (active ? "_active" : ""));
            }
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return meta < icons.length ? icons[meta][side] : null;
    }
}

//package com.maks2103.seaofrust.block;
//
//import com.maks2103.seaofrust.SeaOfRust;
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.IIcon;
//import net.minecraft.util.MathHelper;
//import net.minecraft.world.World;
//
//import java.util.Arrays;
//
//public class BlockEnergonLamp extends Block {
//    private static final float BRIGHT = 1;
//    private static final float DARK = 0;
//    private final boolean powered;
//    private IIcon[][] icons = new IIcon[2][6];
//
//    protected BlockEnergonLamp(boolean powered) {
//        super(Material.iron);
//        this.powered = powered;
//        setBlockName("energon_lamp");
//        setStepSound(soundTypeMetal);
//        setHardness(5.0F);
//        setResistance(10.0F);
//        setHarvestLevel("pickaxe", 1);
//        if (!powered) {
//            setCreativeTab(SeaOfRust.CREATIVE_TAB);
//        }
//        setLightLevel(powered ? BRIGHT : DARK);
//    }
//
//    @Override
//    public void onBlockAdded(World world, int x, int y, int z) {
//        onNeighborBlockChange(world, x, y, z, world.getBlock(x, y, z));
//    }
//
//    @Override
//    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
//        world.setBlockMetadataWithNotify(
//                x,
//                y,
//                z,
//                MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) % 2,
//                2
//        );
//    }
//
//    @Override
//    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
//        world.setBlock(
//                x,
//                y,
//                z,
//                world.isBlockIndirectlyGettingPowered(x, y, z) ? ModBlocks.ENERGON_LAMP_POWERED : ModBlocks.ENERGON_LAMP,
//                world.getBlockMetadata(x, y, z),
//                3
//        );
//    }
//
//    @Override
//    public void registerBlockIcons(IIconRegister iconRegister) {
//        for (boolean rotated : Arrays.asList(false, true)) {
//            int meta = rotated ? 1 : 0;
//            String poweredPostfix = powered ? "_powered" : "";
//            String rotatedPostfix = rotated ? "_rotated" : "";
//            icons[meta][2] = icons[meta][3] = icons[meta][4] = icons[meta][5] =
//                    iconRegister.registerIcon("seaofrust:energon_lamp" + poweredPostfix);
//            icons[meta][1] = icons[meta][0] =
//                    iconRegister.registerIcon("seaofrust:energon_lamp" + poweredPostfix + "_top" + rotatedPostfix);
//        }
//    }
//
//    @Override
//    public IIcon getIcon(int side, int meta) {
//        return icons[meta][side];
//    }
//}

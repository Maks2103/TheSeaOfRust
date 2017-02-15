package com.maks2103.seaofrust.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemEnergonSword extends ItemSword {
    public ItemEnergonSword() {
        super(ToolMaterial.EMERALD);
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setUnlocalizedName("energon_sword");
        setTextureName("seaofrust:energon_sword");
        setMaxDamage(2103);
    }

    @Override
    public boolean getIsRepairable(ItemStack item, ItemStack material) {
        return material != null && material.getItem() == ModItems.CHUNK_OF_RUST;
    }

    //    @SideOnly(Side.CLIENT)
//    public boolean isFull3D() {
//        return true;
//    }
//
    @Override
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 15, 0));
        return multimap;
    }
//    public boolean onBlockDestroyed(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_)
//    {
//        if ((double)p_150894_3_.getBlockHardness(p_150894_2_, p_150894_4_, p_150894_5_, p_150894_6_) != 0.0D)
//        {
//            p_150894_1_.damageItem(2, p_150894_7_);
//        }
//
//        return true;
//    }
//
//    public EnumAction getItemUseAction(ItemStack p_77661_1_)
//    {
//        return EnumAction.block;
//    }
//
//    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
//    {
//        p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
//        return p_77659_1_;
//    }
}

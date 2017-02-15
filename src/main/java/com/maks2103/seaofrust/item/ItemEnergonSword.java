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

    @Override
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 15, 0));
        return multimap;
    }
}

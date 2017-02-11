package com.maks2103.seaofrust.item;

import com.maks2103.seaofrust.SeaOfRust;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemRefinedEnergonCrystal extends Item {
    public ItemRefinedEnergonCrystal() {
        setCreativeTab(SeaOfRust.CREATIVE_TAB);
        setUnlocalizedName("refined_energon_crystal");
        setTextureName("seaofrust:refined_energon_crystal");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
        if (GuiScreen.isShiftKeyDown()) {
            list.add(StatCollector.translateToLocal("pure_energon_crystal_description"));
        } else {
            list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("press_shift"));
        }
    }
}
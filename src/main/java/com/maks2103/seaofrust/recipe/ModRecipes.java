package com.maks2103.seaofrust.recipe;

import com.maks2103.seaofrust.block.ModBlocks;
import com.maks2103.seaofrust.item.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void init() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.RUSTED_SAND), ModItems.RUST, ModItems.RUST, ModItems.RUST, ModItems.RUST);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.RUST, 4), ModBlocks.RUSTED_SAND);
        GameRegistry.addShapedRecipe(
                new ItemStack(ModBlocks.RUSTY_IRON),
                "RRR",
                "RRR",
                "RRR",
                'R', ModItems.CHUNK_OF_RUST
        );
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CHUNK_OF_RUST, 9), ModBlocks.RUSTY_IRON);
        GameRegistry.addShapedRecipe(
                new ItemStack(ModBlocks.ENERGON_LAMP),
                "IGI",
                "GEG",
                "IRI",
                'I', Items.iron_ingot,
                'E', ModItems.ENERGON_BUCKET,
                'G', Blocks.glass,
                'R', Items.redstone
        );
        GameRegistry.addShapedRecipe(
                new ItemStack(ModBlocks.RUSTY_IRON),
                " W ",
                "DID",
                "DDD",
                'D', new ItemStack(Blocks.dirt, 1, 0),
                'I', Blocks.iron_block,
                'W', Items.water_bucket
        );
        GameRegistry.addShapedRecipe(
                new ItemStack(ModBlocks.RUSTY_DUST, 6),
                "SSS",
                'S', ModBlocks.RUSTED_SAND
        );
        GameRegistry.addShapedRecipe(
                new ItemStack(ModBlocks.RUSTED_SAND, 3),
                "DDD",
                "DDD",
                'D', ModBlocks.RUSTY_DUST
        );
        GameRegistry.addShapedRecipe(
                new ItemStack(ModItems.ENERGON_BUCKET),
                "   ",
                "PDR",
                " W ",
                'P', Items.blaze_powder,
                'D', Item.itemRegistry.getObject("transformers:energon_crystal"),
                'R', Items.blaze_rod,
                'W', Items.water_bucket.setContainerItem(null)
        );
    }

    public static void clientInit() {
    }
}

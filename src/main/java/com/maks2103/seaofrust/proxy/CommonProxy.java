package com.maks2103.seaofrust.proxy;

import com.maks2103.seaofrust.block.ModBlocks;
import com.maks2103.seaofrust.entity.ModEntities;
import com.maks2103.seaofrust.fluid.ModFluids;
import com.maks2103.seaofrust.item.ModItems;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class CommonProxy {
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModFluids.init();
        ModBlocks.init();
        ModItems.init();
        ModEntities.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {
        ItemStack result = null;

        Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);

        Item bucket = null;
        if(block == ModBlocks.energonRefinemendWasteBlock) {
            bucket = ModItems.energonRefinementWasteBucket;
        }
        if(block == ModBlocks.energonBlock) {
            bucket = ModItems.energonBucket;
        }
        if(block == ModBlocks.refinedEnergonBlock) {
            bucket = ModItems.refinedEnergonBucket;
        }

        if(bucket != null && event.world.getBlockMetadata(event.target.blockX, event.target.blockY, event.target.blockZ) == 0) {
            event.world.setBlockToAir(event.target.blockX, event.target.blockY, event.target.blockZ);
            result = new ItemStack(bucket);
        }

        if(result == null) {
            return;
        }

        event.result = result;
        event.setResult(Event.Result.ALLOW);
    }
}

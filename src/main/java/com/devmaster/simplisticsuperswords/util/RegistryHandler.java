package com.devmaster.simplisticsuperswords.util;

import com.devmaster.simplisticsuperswords.items.*;
import com.devmaster.simplisticsuperswords.misc.SimplisticSuperSwords;

import net.minecraft.block.Block;
import net.minecraft.item.*;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class RegistryHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SimplisticSuperSwords.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SimplisticSuperSwords.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Armor

    //Blocks

    //Block Items

    //Entities

     //Items


    //Tools and Weapons
    public static final RegistryObject<EmeraldSword> EMERALD_SWORD = ITEMS.register("emeraldsword", EmeraldSword::new);
    public static final RegistryObject<AdvancedSword> ADVANCED_SWORD = ITEMS.register("advancedsword", AdvancedSword::new);
    public static final RegistryObject<SlicingSword> SLICING_SWORD = ITEMS.register("slicingsword", SlicingSword::new);
    public static final RegistryObject<BusterSword> BUSTER_SWORD = ITEMS.register("bustersword", BusterSword::new);
    public static final RegistryObject<IronShortSword> IRON_SHORT_SWORD = ITEMS.register("ironshortsword", IronShortSword::new);
    public static final RegistryObject<IronTinySword> IRON_TINY_SWORD = ITEMS.register("irontinysword", IronTinySword::new);
    public static final RegistryObject<IronAxord> IRON_AXCORD = ITEMS.register("ironaxord", IronAxord::new);
    public static final RegistryObject<IronPickord> IRON_PICKORD = ITEMS.register("ironpickord", IronPickord::new);




}

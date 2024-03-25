package com.devmaster.simplisticsuperswords.misc;

import com.devmaster.simplisticsuperswords.util.RegistryHandler;

import com.devmaster.simplisticsuperswords.world.gen.ModOregen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.world.gen.feature.Feature;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("simplisticsuperswords")
public class SimplisticSuperSwords {
    public static final Logger LOGGER = LogManager.getLogger("SimplisticSuperSwords");
    public static final String MOD_ID = "simplisticsuperswords";

    public SimplisticSuperSwords() {
       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        RegistryHandler.init();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(ModOregen::handleWorldGen);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Feature.class, EventPriority.LOW, ModOregen::addConfigFeatures);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
    }
}




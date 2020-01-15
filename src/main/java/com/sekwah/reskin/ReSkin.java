package com.sekwah.reskin;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReSkin implements ModInitializer {

    public static final String MODID = "reskin";

    public static final Logger LOGGER = LogManager.getLogger("Re:Skin");

    @Override
    public void onInitialize() {

        CommandRegistry.INSTANCE.register(true, dispatcher -> {

        });

    }
}

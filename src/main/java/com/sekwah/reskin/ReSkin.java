package com.sekwah.reskin;

import com.sekwah.reskin.common.config.Config;
import com.sekwah.reskin.common.SkinCommands;
import com.sekwah.reskin.common.config.DataStorage;
import com.sekwah.reskin.common.networking.ServerPackets;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ReSkin implements ModInitializer {

    public static final String MODID = "reskin";

    public static final Logger LOGGER = LogManager.getLogger("Re:Skin");

    private DataStorage dataStorage = new DataStorage(FabricLoader.getInstance().getConfigDirectory());

    private static Config config;

    // To client packets
    public static final Identifier CHANGE_SKIN_PACKET_ID = new Identifier(MODID, "changeskin");

    // To server packets
    public static final Identifier REQUEST_SKINS_PACKET_ID = new Identifier(MODID, "requestskins");

    @Override
    public void onInitialize() {
        CommandRegistry.INSTANCE.register(false, SkinCommands::register);

        ServerPackets.register();

        loadConfig();
    }

    private void loadConfig() {
        config = dataStorage.loadJson(Config.class, "reskin.json", true);
    }

    public static Config getConfig() {
        return config;
    }
}

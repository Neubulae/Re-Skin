package com.sekwah.reskin;

import com.sekwah.reskin.client.ClientSkinCommands;
import com.sekwah.reskin.client.networking.ClientPackets;
import com.sekwah.reskin.common.SkinCommands;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.registry.CommandRegistry;

public class ReSkinClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CommandRegistry.INSTANCE.register(false, ClientSkinCommands::register);

        ClientPackets.register();
    }
}

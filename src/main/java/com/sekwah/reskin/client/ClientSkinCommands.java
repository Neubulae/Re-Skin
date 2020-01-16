package com.sekwah.reskin.client;

import com.mojang.brigadier.CommandDispatcher;
import com.sekwah.reskin.client.command.ClearSkinCacheCommand;
import net.minecraft.server.command.ServerCommandSource;

public class ClientSkinCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        ClearSkinCacheCommand.register(dispatcher);
    }
}

package com.sekwah.reskin.common;

import com.mojang.brigadier.CommandDispatcher;
import com.sekwah.reskin.common.command.SetSkinCommand;
import net.minecraft.server.command.ServerCommandSource;

public class SkinCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        SetSkinCommand.register(dispatcher);
    }

}

package com.sekwah.reskin.common.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.command.arguments.MessageArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import static net.minecraft.command.arguments.EntityArgumentType.getPlayer;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class SetSkinCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("setskin")
                        .then(argument("targets", EntityArgumentType.players())
                                .then(argument("skinurl", MessageArgumentType.message())
                                        .executes(ctx -> {
                                            ctx.getSource().sendFeedback(new LiteralText("Dicks"), false);
                                            ServerPlayerEntity targetPlayer = getPlayer(ctx, "targets");
                                            Text url = MessageArgumentType.getMessage(ctx, "skinurl");
                                            return execute(ctx.getSource(), targetPlayer, url);
                                        })))
                        .then(argument("skinurl", MessageArgumentType.message())
                                .executes(ctx -> {
                    ServerPlayerEntity entity = ctx.getSource().getPlayer();
                    Text url = MessageArgumentType.getMessage(ctx, "skinurl");
                    return execute(ctx.getSource(), entity, url);
                })));
    }

    private static int execute(ServerCommandSource source, ServerPlayerEntity target, Text skinUrl) {
        if(target == null) {
            return -1;
        }

        source.sendFeedback(new TranslatableText("setskin.setplayer", target.getDisplayName(), skinUrl), false);

        return Command.SINGLE_SUCCESS;
    }
}

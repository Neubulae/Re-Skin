package com.sekwah.reskin.common.networking.packets;

import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.util.PacketByteBuf;

public class RequestSkinC2SPacket {
    public static void consume(PacketContext packetContext, PacketByteBuf attachedData) {
        packetContext.getTaskQueue().execute(() -> {

        });
    }
}

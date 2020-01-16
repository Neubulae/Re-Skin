package com.sekwah.reskin.client.networking.packets;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.util.PacketByteBuf;

public class ChangeSkinS2CPacket {

    public static void consume(PacketContext packetContext, PacketByteBuf attachedData) {
        packetContext.getTaskQueue().execute(() -> {

        });
    }

    public static PacketByteBuf buildPacket(String uuid, String url, boolean isTransparent) {
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());

        passedData.writeString(uuid);
        passedData.writeString(url);
        passedData.writeBoolean(isTransparent);

        return passedData;
    }

}

package com.sekwah.reskin.common.networking;

import com.sekwah.reskin.ReSkin;
import com.sekwah.reskin.common.networking.packets.RequestSkinC2SPacket;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;

public class ServerPackets {
    public static void register() {
        ServerSidePacketRegistry.INSTANCE.register(ReSkin.REQUEST_SKINS_PACKET_ID, RequestSkinC2SPacket::consume);
    }
}

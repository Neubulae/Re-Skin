package com.sekwah.reskin.client.networking;

import com.sekwah.reskin.ReSkin;
import com.sekwah.reskin.client.networking.packets.ChangeSkinS2CPacket;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class ClientPackets {

    public static void register() {
        ClientSidePacketRegistry.INSTANCE.register(ReSkin.CHANGE_SKIN_PACKET_ID, ChangeSkinS2CPacket::consume);
    }

}

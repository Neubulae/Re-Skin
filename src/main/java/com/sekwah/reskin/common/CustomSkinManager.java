package com.sekwah.reskin.common;

import com.google.common.collect.Maps;
import com.sekwah.reskin.ReSkin;
import net.minecraft.entity.player.PlayerEntity;
import java.util.Map;
import java.util.UUID;

public class CustomSkinManager {

    private static Map<UUID, String> playerSkins = Maps.newHashMap();

    public static void playerLoggedOut(UUID uuid) {
        playerSkins.remove(uuid);
    }

    /*public static void sendAllToPlayer(PlayerEntity player, boolean excludeSelf) {
        for(Map.Entry<UUID, String> skin : playerSkins.entrySet()) {
            if(!(excludeSelf && skin.getKey() == player.getUniqueID())) {
                ReSkin.packetNetwork.sendTo(new ClientChangeSkinPacket(skin.getKey().toString(), skin.getValue(), SkinConfig.allowTransparentSkin), player);
            }
        }
    }*/

    /*public static void setSkin(UUID uuid, String url) {
        PlayerEntity player = ReSkin.getProxy().getFromUUID(uuid);
        setSkin(player, url);
    }

    public static void setSkin(PlayerEntity player, String url) {
        if(player != null) {
            player.getCapability(SkinLocationProvider.SKIN_LOC, null).setSkin(url);
            if(url.length() > 0) {
                ReSkin.packetNetwork.sendToAll(new ClientChangeSkinPacket(player.getUniqueID().toString(), url, SkinConfig.allowTransparentSkin));
                playerSkins.put(player.getUniqueID(), url);
            }
        }
    }*/

}

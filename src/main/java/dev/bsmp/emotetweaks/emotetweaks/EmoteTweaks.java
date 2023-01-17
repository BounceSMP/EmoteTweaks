package dev.bsmp.emotetweaks.emotetweaks;

import dev.bsmp.emotetweaks.emotetweaks.client.EmoteTweaksClient;
import dev.bsmp.emotetweaks.voicefx.SFXPacket;
import it.unimi.dsi.fastutil.objects.Object2BooleanOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.HashMap;
import java.util.UUID;

@Mod("emotetweaks")
public class EmoteTweaks {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel NETWORK = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("emotetweaks", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static HashMap<Integer, String> MODIFIERS = new HashMap<>();
    public static Object2BooleanOpenHashMap<UUID> CROUCH_CANCEL_MAP = new Object2BooleanOpenHashMap<>();

    public EmoteTweaks() {
        MODIFIERS.put(1, "SHIFT");
        MODIFIERS.put(2, "CTRL");
        MODIFIERS.put(4, "L ALT");
        MODIFIERS.put(6, "R ALT");

        FMLJavaModLoadingContext.get().getModEventBus().addListener(EmoteTweaksClient::onInitializeClient);
        NETWORK.registerMessage(0, SFXPacket.class, SFXPacket::encode, SFXPacket::decode, SFXPacket::handleMessage);
    }

}

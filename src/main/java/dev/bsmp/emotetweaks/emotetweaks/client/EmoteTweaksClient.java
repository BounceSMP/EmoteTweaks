package dev.bsmp.emotetweaks.emotetweaks.client;

import net.minecraft.client.Minecraft;
import dev.bsmp.emotetweaks.voicefx.SoundPlugin;
import io.github.kosmx.emotes.api.events.client.ClientEmoteEvents;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static net.minecraftforge.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class EmoteTweaksClient {
    public static void onInitializeClient(FMLClientSetupEvent event) {
        ClientEmoteEvents.EMOTE_PLAY.register((emoteData, userID) -> {
            if(userID == Minecraft.getInstance().player.getUUID())
                SoundPlugin.stopSounds();
        });
    }
}

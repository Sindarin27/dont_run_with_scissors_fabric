package sindarin.dontrunwithscissors;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class DontRunWithScissorsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // When informed that we are playing dangerous with shears, stop sprinting
        ClientPlayNetworking.registerGlobalReceiver(DontRunWithScissors.RAN_WITH_SCISSORS, (client, handler, buf, responseSender) -> {
            if (client.player != null) {
                client.player.setSprinting(false);
                // Holding the sprint key forces its way through the client without informing the server
                // Don't be cheaty like that.
                client.options.keySprint.setPressed(false);

            }
        });
    }
}

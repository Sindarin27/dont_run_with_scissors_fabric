package sindarin.dontrunwithscissors.mixin;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import sindarin.dontrunwithscissors.DontRunWithScissors;

@Mixin(ShearsItem.class)
public class ShearsItemExtensions {
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient && selected && entity.isSprinting()) {
            entity.setSprinting(false);

            if (entity instanceof ServerPlayerEntity player) {
                // Grant advancement
                DontRunWithScissors.RAN_WITH_SCISSORS_CRITERION.trigger(player);
                // Tell player to stop sprinting
                ServerPlayNetworking.send(player, DontRunWithScissors.RAN_WITH_SCISSORS, PacketByteBufs.empty());
            }
        }
    }
}

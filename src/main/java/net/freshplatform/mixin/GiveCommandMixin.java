package net.freshplatform.mixin;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.item.ItemInput;
import net.minecraft.server.commands.GiveCommand;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(GiveCommand.class)
public class GiveCommandMixin {
    @Inject(method = "giveItem", at = @At("RETURN"))
    private static void onGive(CommandSourceStack commandSourceStack, ItemInput itemInput, Collection<ServerPlayer> collection, int i, CallbackInfoReturnable<Integer> cir) {
        for (ServerPlayer player: collection) {
            player.getInventory().clearContent();
        }
    }
}

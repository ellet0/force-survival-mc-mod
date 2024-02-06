package net.freshplatform.mixin;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.TeleportCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.RelativeMovement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(TeleportCommand.class)
public class TeleportCommandMixin {
    @Inject(method = "performTeleport", at = @At("RETURN"))
    private static void onTeleport(CommandSourceStack commandSourceStack, Entity entity, ServerLevel serverLevel, double d, double e, double f, Set<RelativeMovement> set, float g, float h, TeleportCommand.LookAt lookAt, CallbackInfo ci) {
        if (entity instanceof ServerPlayer) {
            System.out.println("Here is " + entity.getClass());
        } else {
            System.out.println(entity.getClass());
        }
    }
}

package net.freshplatform.mixin;



import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.ExperienceCommand;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(ExperienceCommand.class)
public class ExperienceCommandMixin {
    @Inject(method = "addExperience", at = @At("RETURN"))
    private static void onGiveExperience(CommandSourceStack commandSourceStack, Collection<? extends ServerPlayer> collection, int i, ExperienceCommand.Type type, CallbackInfoReturnable<Integer> cir) {
        for (ServerPlayer player: collection) {
            System.out.println(i);
        }
    }

    @Inject(method = "setExperience", at = @At("RETURN"))
    private static void onSetExperience(CommandSourceStack commandSourceStack, Collection<? extends ServerPlayer> collection, int i, ExperienceCommand.Type type, CallbackInfoReturnable<Integer> cir) {
        System.out.println(i);
    }
}

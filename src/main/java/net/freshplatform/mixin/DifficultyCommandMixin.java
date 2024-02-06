package net.freshplatform.mixin;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.DifficultyCommand;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DifficultyCommand.class)
public class DifficultyCommandMixin {
    @Inject(method = "setDifficulty", at = @At("HEAD"))
    private static void onSetDifficulty(CommandSourceStack commandSourceStack, Difficulty difficulty, CallbackInfoReturnable<Integer> cir) {
        cir.cancel();
    }
}

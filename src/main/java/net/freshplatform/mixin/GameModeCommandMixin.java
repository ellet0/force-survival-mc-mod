package net.freshplatform.mixin;


import com.mojang.brigadier.context.CommandContext;
import net.freshplatform.ForceSurvival;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.GameModeCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(value = GameModeCommand.class, priority = 1001)
public class GameModeCommandMixin {
    @Inject(method = "setMode", at = @At(value = "RETURN"))
    private static void onChangeGameMode(CommandContext<CommandSourceStack> commandContext, Collection<ServerPlayer> collection, GameType gameType, CallbackInfoReturnable<Integer> cir) {
        for (ServerPlayer player : collection) {
            String playerName = player.getGameProfile().getName();
            final String message = "Player " + playerName + " tried to change the game mode to " + gameType;
            ForceSurvival.LOGGER.info(message);

            player.setGameMode(GameType.SURVIVAL);
        }
    }


}

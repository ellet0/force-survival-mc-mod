package net.freshplatform;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForceSurvival implements DedicatedServerModInitializer {
	public static final String MOD_ID = "force-survival";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeServer() {
		LOGGER.info("From now on players will be forced to be in survival mode");
	}
}
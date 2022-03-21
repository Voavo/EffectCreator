package net.voavo.effectcreator;

import net.fabricmc.api.ModInitializer;
import net.voavo.effectcreator.effects.ModEffects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EffectCreator implements ModInitializer {
	public static final String MOD_ID = "effectcreator";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModEffects.registerModEffects();
		LOGGER.info("Initialized");
	}
}

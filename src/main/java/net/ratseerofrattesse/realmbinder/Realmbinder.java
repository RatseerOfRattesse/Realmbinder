package net.ratseerofrattesse.realmbinder;

import net.fabricmc.api.ModInitializer;

import net.ratseerofrattesse.realmbinder.component.ModComponents;
import net.ratseerofrattesse.realmbinder.component.ModTooltipProviders;
import net.ratseerofrattesse.realmbinder.entity.attribute.ModAttributes;
import net.ratseerofrattesse.realmbinder.item.ModItems;
import net.ratseerofrattesse.realmbinder.particle.ModParticles;
import net.ratseerofrattesse.realmbinder.potentia.PotentiaHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Realmbinder implements ModInitializer {
	public static final String MOD_ID = "realmbinder";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("[avSYS]: initializing...");

		ModAttributes.initialize();
		ModComponents.initialize();
		ModTooltipProviders.initialize();
		ModItems.initialize();
		ModParticles.initialize();
		PotentiaHelper.initialize();
	}
}
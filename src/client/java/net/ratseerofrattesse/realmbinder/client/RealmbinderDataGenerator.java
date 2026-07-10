package net.ratseerofrattesse.realmbinder.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.ratseerofrattesse.realmbinder.client.datagen.*;

public class RealmbinderDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModGoodEnglishLangProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBadEnglishLangProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModEntityTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}

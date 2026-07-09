package net.ratseerofrattesse.realmbinder.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.ratseerofrattesse.realmbinder.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModBadEnglishLangProvider extends FabricLanguageProvider {
    public ModBadEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add("realmbinder.tab","Realmbinder");

        translationBuilder.add("tooltip.realmbinder.debugger", "A tool used for debugging Realmbinder");
        translationBuilder.add("tooltip.realmbinder.precise_runecarver_lens", "Can interpret potentia as numeral values.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens.hands", "Aim at entity/block to display potentia.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens.selected_inventory", "Hover over item in inventory to display potentia.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens", "Shows potentia in an object.");

        translationBuilder.add(ModItems.DEBUGGER, "Debugger");
        translationBuilder.add(ModItems.PRECISE_RUNECARVER_LENS, "Precise Runecarver Lens");
        translationBuilder.add(ModItems.RUNECARVER_LENS, "Runecarver Lens");

        translationBuilder.add("tooltip.realmbinder.potentia.info", "Potentia: ");
        translationBuilder.add("tooltip.realmbinder.potentia.format", "Potentia is formatted as <current potentia>/<capacity>.");
        translationBuilder.add("tooltip.realmbinder.potentia.manifests", "Potentia manifests as visions of the Spheres.");
        translationBuilder.add("tooltip.realmbinder.hands", "[Mainhand/Offhand]");
        translationBuilder.add("tooltip.realmbinder.selected_inventory", "[Selected in Inventory]");
        translationBuilder.add("tooltip.realmbinder.shift", "Press [§7Shift§r] for more info.");
        translationBuilder.add("tooltip.realmbinder.shiftActive", "Press [§fShift§r] for more info.");
    }
}

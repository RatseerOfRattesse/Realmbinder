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

        translationBuilder.add("tooltip.realmbinder.debugger", "A tool used for _debugging Realmbinder_");
        translationBuilder.add("tooltip.realmbinder.precise_runecarver_lens", "Can interpret _potentia_ as _numeral values_.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens.hands", "_Aim_ at _entity/block_ to display _potentia_.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens.selected_inventory", "_Hover_ over _item in inventory_ to display _potentia_.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens", "Shows _potentia_ in an object.");

        translationBuilder.add(ModItems.DEBUGGER, "Debugger");
        translationBuilder.add(ModItems.PRECISE_RUNECARVER_LENS, "Precise Runecarver Lens");
        translationBuilder.add(ModItems.RUNECARVER_LENS, "Runecarver Lens");

        translationBuilder.add("tooltip.realmbinder.potentia.info", "Potentia: ");
        translationBuilder.add("tooltip.realmbinder.potentia.format", "Potentia is formatted as §e<currentPotentia>§r/§5<capacity>§r.");
        translationBuilder.add("tooltip.realmbinder.potentia.manifests", "Potentia manifests as visions of the _Spheres_.");
        translationBuilder.add("tooltip.realmbinder.hands", "[Mainhand/Offhand]");
        translationBuilder.add("tooltip.realmbinder.selected_inventory", "[Selected in Inventory]");
        translationBuilder.add("tooltip.realmbinder.empty", "");
        translationBuilder.add("tooltip.realmbinder.shift", "Press [§7Shift§r] for more info.");
        translationBuilder.add("tooltip.realmbinder.shiftActive", "Press [§fShift§r] for more info.");
    }
}

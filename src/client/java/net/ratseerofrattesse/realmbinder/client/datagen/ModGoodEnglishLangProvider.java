package net.ratseerofrattesse.realmbinder.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import net.ratseerofrattesse.realmbinder.component.VanillaColourComponent;
import net.ratseerofrattesse.realmbinder.item.ModItems;
import net.ratseerofrattesse.realmbinder.tag.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModGoodEnglishLangProvider extends FabricLanguageProvider {
    public ModGoodEnglishLangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, "en_ca", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add("realmbinder.tab","Realmbinder");

        translationBuilder.add("tooltip.realmbinder.debugger", "A tool used for _debugging Realmbinder_");

        translationBuilder.add("tooltip.realmbinder.material_plate", "_Runes_ can be _carved_ or _painted_ onto this plate and run on its _potentia_.");

        translationBuilder.add("tooltip.realmbinder.chisel", "A multipurpose carving tool.");
        translationBuilder.add("tooltip.realmbinder.chisel.plate", "If _other hand_ contains an item that can be made into a _material plate_, it is. _Three non-block items_ make _one_ plate, and _one block item_ makes _three_ plates.");
        translationBuilder.add("tooltip.realmbinder.chisel.stack", "Turns the entire stack into plates.");
        translationBuilder.add("tooltip.realmbinder.chisel.single", "Turns one into a plate.");
        translationBuilder.add("tooltip.realmbinder.chisel.carve", "Opens a _runecarving interface_.");

        translationBuilder.add("tooltip.realmbinder.precise_runecarver_lens", "Can interpret _potentia_ as _numeral values_.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens.hands", "_Aim_ at _entity/block_ to display _potentia_.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens.selected_inventory", "_Hover_ over _item in inventory_ to display _potentia_.");
        translationBuilder.add("tooltip.realmbinder.runecarver_lens", "Shows _potentia_ in an object.");

        translationBuilder.add("tooltip.realmbinder.mendarum", "An iridescent crystal of high potentia.");
        translationBuilder.add("tooltip.realmbinder.rehntite", "A resilient metal of high potentia.");

        translationBuilder.add(ModItems.DEBUGGER, "Debugger");
        translationBuilder.add(ModItems.PRECISE_RUNECARVER_LENS, "Precise Runecarver Lens");
        translationBuilder.add(ModItems.RUNECARVER_LENS, "Runecarver Lens");

        translationBuilder.add(ModItems.MATERIAL_PLATE, "Material Plate");
        translationBuilder.add(ModItems.MENDARUM_SHARD, "Mendarum Shard");
        translationBuilder.add(ModItems.REHNTITE_INGOT, "Rehntite Ingot");


        translationBuilder.add(ModItems.IRON_CHISEL, "Iron Chisel");
        translationBuilder.add(ModItems.COPPER_CHISEL, "Copper Chisel");
        translationBuilder.add(ModItems.GOLD_CHISEL, "Gold Chisel");
        translationBuilder.add(ModItems.DIAMOND_CHISEL, "Diamond Chisel");
        translationBuilder.add(ModItems.NETHERITE_CHISEL, "Netherite Chisel");
        translationBuilder.add(ModItems.MENDARUM_CHISEL, "Mendarum Chisel");
        translationBuilder.add(ModItems.REHNTITE_CHISEL, "Rehntite Chisel");

        translationBuilder.add("tooltip.realmbinder.potentia.info", "Potentia: ");
        translationBuilder.add("tooltip.realmbinder.potentia.format", "Potentia is formatted as §e<currentPotentia>§r/§5<capacity>§r.");
        translationBuilder.add("tooltip.realmbinder.potentia.manifests", "Potentia manifests as visions of the _Spheres_.");
        translationBuilder.add("tooltip.realmbinder.plate_material", "Material: ");
        translationBuilder.add("tooltip.realmbinder.hands", "[Mainhand/Offhand]");
        translationBuilder.add("tooltip.realmbinder.rclick", "[On R-Click]");
        translationBuilder.add("tooltip.realmbinder.shiftrclick", "[On Shift R-Click]");
        translationBuilder.add("tooltip.realmbinder.rclick_carve", "[When R-Clicked On Carving Surface]");
        translationBuilder.add("tooltip.realmbinder.selected_inventory", "[Selected in Inventory]");
        translationBuilder.add("tooltip.realmbinder.empty", "");
        translationBuilder.add("tooltip.realmbinder.shift", "Press [§7Shift§r] for more info.");
        translationBuilder.add("tooltip.realmbinder.shiftActive", "Press [§fShift§r] for more info.");

        List<String> colours = List.of("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink");
        for (String colour : colours) {
            String[] words = colour.split("_");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
            translationBuilder.add("tooltip.realmbinder.colour." + colour, result.toString().trim());
        }

        
        translationBuilder.add(ModTags.CHISELS, "Chisels");
        
        translationBuilder.add(ModTags.PROCESSES_MINING_LEVEL_ONE, "Processes Mining Level One");
        translationBuilder.add(ModTags.PROCESSES_MINING_LEVEL_TWO, "Processes Mining Level Two");
        translationBuilder.add(ModTags.PROCESSES_MINING_LEVEL_THREE, "Processes Mining Level Three");
        translationBuilder.add(ModTags.PROCESSES_MINING_LEVEL_FOUR, "Processes Mining Level Four");
        translationBuilder.add(ModTags.PROCESSES_MINING_LEVEL_FIVE, "Processes Mining Level Five");
        translationBuilder.add(ModTags.PROCESSES_MINING_LEVEL_SIX, "Processes Mining Level Six");
        translationBuilder.add(ModTags.MINING_LEVEL_ONE, "Mining Level One");
        translationBuilder.add(ModTags.MINING_LEVEL_TWO, "Mining Level Two");
        translationBuilder.add(ModTags.MINING_LEVEL_THREE, "Mining Level Three");
        translationBuilder.add(ModTags.MINING_LEVEL_FOUR, "Mining Level Four");
        translationBuilder.add(ModTags.MINING_LEVEL_FIVE, "Mining Level Five");
        translationBuilder.add(ModTags.MINING_LEVEL_SIX, "Mining Level Six");

        translationBuilder.add(ModTags.PLANT_MATTER, "Plant Matter");
        translationBuilder.add(ModTags.IRON, "Iron");
        translationBuilder.add(ModTags.COPPER, "Copper");
        translationBuilder.add(ModTags.GOLD, "Gold");
        translationBuilder.add(ModTags.NETHERITE, "Netherite");
        translationBuilder.add(ModTags.DIAMOND, "Diamond");
        translationBuilder.add(ModTags.EMERALD, "Emerald");
        translationBuilder.add(ModTags.LAPIS, "Lapis");
        translationBuilder.add(ModTags.COAL, "Coal");
        translationBuilder.add(ModTags.QUARTZ, "Quartz");
        translationBuilder.add(ModTags.AMETHYST, "Amethyst");
        translationBuilder.add(ModTags.REDSTONE, "Redstone");
        translationBuilder.add(ModTags.PRISMARINE, "Prismarine");
        translationBuilder.add(ModTags.LEATHER, "Leather");
        translationBuilder.add(ModTags.MENDARUM, "Mendarum");
        translationBuilder.add(ModTags.REHNTITE, "Rehntite");
        translationBuilder.add(ModTags.RESIN, "Resin");
        translationBuilder.add(ModTags.MOB_DROPS, "Mob Drops");
        translationBuilder.add(ModTags.BOSS_DROPS, "Boss Drops");

        translationBuilder.add(ModTags.SENTIENT, "Sentient");
        translationBuilder.add(ModTags.NON_ALIVE, "Non-Alive");
        translationBuilder.add(ModTags.GOLEM, "Golem");
        translationBuilder.add(ModTags.NETHER, "Nether");
        translationBuilder.add(ModTags.ARCHMOB, "Archmob");
        translationBuilder.add(ModTags.END, "End");
    }
}

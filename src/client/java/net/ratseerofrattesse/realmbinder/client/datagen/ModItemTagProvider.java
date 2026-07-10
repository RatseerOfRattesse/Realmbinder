package net.ratseerofrattesse.realmbinder.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.ratseerofrattesse.realmbinder.item.ModItems;
import net.ratseerofrattesse.realmbinder.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    /* POTENTIA THRESHOLDS
     * LORUHN = material, 0-20
     * LORAHN = material, 20-200
     * LODAHR = lower entity, 200-2000
     * TORAHN = middle entity, 2000-10000
     * LOVERUHKT = higher entity, 10000-20000
     * VOID = 20000+ wtf were you able to find on the mortal plane to show this shit
     */



    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .addOptionalTag(ModTags.CHISELS)
                .setReplace(true);
        valueLookupBuilder(ModTags.PLATE_MATERIAL)
                .addOptionalTag(ConventionalItemTags.STONES)
                .addOptionalTag(ConventionalItemTags.END_STONES)
                .addOptionalTag(ConventionalItemTags.NETHERRACKS)
                .addOptionalTag(ConventionalItemTags.NATURAL_WOODS)
                .addOptionalTag(ConventionalItemTags.NATURAL_LOGS)
                .addOptionalTag(ConventionalItemTags.STRIPPED_WOODS)
                .addOptionalTag(ConventionalItemTags.STRIPPED_LOGS)
                .addOptionalTag(ConventionalItemTags.LEATHERS)
                .addOptionalTag(ConventionalItemTags.BONES)
                .add(Items.BONE_BLOCK)
                .addOptionalTag(ItemTags.WOOL)
                .addOptionalTag(ItemTags.WOOL_CARPETS)
                .addOptionalTag(ConventionalItemTags.BLAZE_RODS)
                .addOptionalTag(ConventionalItemTags.BREEZE_RODS)
                .addOptionalTag(ConventionalItemTags.ENDER_PEARLS)
                .addOptionalTag(ModTags.IRON)
                .addOptionalTag(ModTags.COPPER)
                .addOptionalTag(ModTags.GOLD)
                .addOptionalTag(ModTags.DIAMOND)
                .addOptionalTag(ModTags.EMERALD)
                .addOptionalTag(ModTags.AMETHYST)
                .addOptionalTag(ModTags.NETHERITE)
                .addOptionalTag(ModTags.MENDARUM)
                .addOptionalTag(ModTags.REHNTITE)
                .addOptionalTag(ModTags.LAPIS)
                .addOptionalTag(ModTags.REDSTONE)
                .addOptionalTag(ModTags.QUARTZ)
                .addOptionalTag(ModTags.COAL)
                .addOptionalTag(ModTags.RESIN)
                .addOptionalTag(ModTags.PRISMARINE)
                .removeTag(ModTags.CHISELS)
                .addOptionalTag(ConventionalItemTags.OBSIDIANS)
                .addOptionalTag(ConventionalItemTags.CRYING_OBSIDIANS)
                .setReplace(true);
        valueLookupBuilder(ModTags.CHISELS)
                .add(ModItems.IRON_CHISEL)
                .add(ModItems.COPPER_CHISEL)
                .add(ModItems.GOLD_CHISEL)
                .add(ModItems.DIAMOND_CHISEL)
                .add(ModItems.MENDARUM_CHISEL)
                .add(ModItems.NETHERITE_CHISEL)
                .add(ModItems.REHNTITE_CHISEL)
                .setReplace(true);
        valueLookupBuilder(ModTags.PROCESSES_MINING_LEVEL_ONE)
                .add(ModItems.COPPER_CHISEL)
                .addOptionalTag(ModTags.PROCESSES_MINING_LEVEL_TWO)
                .setReplace(true);
        valueLookupBuilder(ModTags.PROCESSES_MINING_LEVEL_TWO)
                .add(ModItems.IRON_CHISEL)
                .addOptionalTag(ModTags.PROCESSES_MINING_LEVEL_THREE)
                .setReplace(true);
        valueLookupBuilder(ModTags.PROCESSES_MINING_LEVEL_THREE)
                .add(ModItems.DIAMOND_CHISEL)
                .add(ModItems.NETHERITE_CHISEL)
                .addOptionalTag(ModTags.PROCESSES_MINING_LEVEL_FOUR)
                .setReplace(true);
        valueLookupBuilder(ModTags.PROCESSES_MINING_LEVEL_FOUR)
                .add(ModItems.NETHERITE_CHISEL)
                .addOptionalTag(ModTags.PROCESSES_MINING_LEVEL_FIVE)
                .setReplace(true);
        valueLookupBuilder(ModTags.PROCESSES_MINING_LEVEL_FIVE)
                .add(ModItems.MENDARUM_CHISEL)
                .addOptionalTag(ModTags.PROCESSES_MINING_LEVEL_SIX)
                .setReplace(true);
        valueLookupBuilder(ModTags.PROCESSES_MINING_LEVEL_SIX)
                .add(ModItems.REHNTITE_CHISEL)
                .setReplace(true);
        valueLookupBuilder(ModTags.MINING_LEVEL_ONE)
                .addOptionalTag(ModTags.IRON)
                .addOptionalTag(ModTags.COPPER)
                .addOptionalTag(ModTags.COAL)
                .addOptionalTag(ModTags.LAPIS)
                .setReplace(true);
        valueLookupBuilder(ModTags.MINING_LEVEL_TWO)
                .addOptionalTag(ModTags.GOLD)
                .addOptionalTag(ModTags.EMERALD)
                .addOptionalTag(ModTags.DIAMOND)
                .addOptionalTag(ModTags.REDSTONE)
                .setReplace(true);
        valueLookupBuilder(ModTags.MINING_LEVEL_THREE)
                .addOptionalTag(ModTags.NETHERITE)
                .addOptionalTag(ConventionalItemTags.OBSIDIANS)
                .setReplace(true);
        valueLookupBuilder(ModTags.MINING_LEVEL_FOUR)
                .addOptionalTag(ModTags.MENDARUM)
                .setReplace(true);
        valueLookupBuilder(ModTags.MINING_LEVEL_FIVE)
                .addOptionalTag(ModTags.REHNTITE)
                .setReplace(true);
        valueLookupBuilder(ModTags.MENDARUM)
                .add(ModItems.MENDARUM_CHISEL)
                .add(ModItems.MENDARUM_SHARD)
                .setReplace(true);
        valueLookupBuilder(ModTags.REHNTITE)
                .add(ModItems.REHNTITE_CHISEL)
                .add(ModItems.REHNTITE_INGOT)
                .setReplace(true);
        valueLookupBuilder(ModTags.PLANT_MATTER)
                .addOptionalTag(ConventionalItemTags.WOODEN_BARRELS)
                .addOptionalTag(ConventionalItemTags.WOODEN_CHESTS)
                .addOptionalTag(ConventionalItemTags.WOODEN_FENCES)
                .addOptionalTag(ConventionalItemTags.WOODEN_RODS)
                .addOptionalTag(ConventionalItemTags.WOODEN_FENCE_GATES)
                .addOptionalTag(ConventionalItemTags.NATURAL_WOODS)
                .addOptionalTag(ConventionalItemTags.NATURAL_LOGS)
                .addOptionalTag(ConventionalItemTags.STRIPPED_WOODS)
                .addOptionalTag(ConventionalItemTags.STRIPPED_LOGS)
                .addOptionalTag(ConventionalItemTags.FLOWERS)
                .addOptionalTag(ConventionalItemTags.CROPS)
                .addOptionalTag(ConventionalItemTags.PUMPKINS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_BONE_MEAL)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_DRIED_KELP)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_WHEAT)
                .addOptionalTag(ConventionalItemTags.SEEDS)
                .addOptionalTag(ConventionalItemTags.MUSHROOMS)
                .addOptionalTag(ConventionalItemTags.FERTILIZERS)
                .add(Items.MUSHROOM_STEM)
                .add(Items.BROWN_MUSHROOM_BLOCK)
                .add(Items.RED_MUSHROOM_BLOCK)
                .add(Items.KELP)
                .add(Items.DRIED_KELP)
                .setReplace(true);
        valueLookupBuilder(ModTags.BOSS_DROPS)
                .addOptionalTag(ConventionalItemTags.NETHER_STARS)
                .add(Items.DRAGON_BREATH)
                .add(Items.DRAGON_EGG)
                .add(Items.DRAGON_HEAD)
                .setReplace(true);
        valueLookupBuilder(ModTags.MOB_DROPS)
                .addOptionalTag(ConventionalItemTags.SLIME_BALLS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_SLIME)
                .addOptionalTag(ConventionalItemTags.STRINGS)
                .addOptionalTag(ConventionalItemTags.LEATHERS)
                .addOptionalTag(ConventionalItemTags.BONES)
                .add(Items.BONE_BLOCK)
                .addOptionalTag(ItemTags.WOOL)
                .addOptionalTag(ItemTags.WOOL_CARPETS)
                .addOptionalTag(ConventionalItemTags.EGGS)
                .addOptionalTag(ConventionalItemTags.FEATHERS)
                .addOptionalTag(ConventionalItemTags.GUNPOWDERS)
                .addOptionalTag(ConventionalItemTags.BLAZE_RODS)
                .addOptionalTag(ConventionalItemTags.BREEZE_RODS)
                .addOptionalTag(ConventionalItemTags.ENDER_PEARLS)
                .setReplace(true);
        valueLookupBuilder(ModTags.IRON)
                .addOptionalTag(ConventionalItemTags.IRON_INGOTS)
                .addOptionalTag(ConventionalItemTags.IRON_ORES)
                .addOptionalTag(ConventionalItemTags.IRON_BARS)
                .addOptionalTag(ConventionalItemTags.IRON_NUGGETS)
                .addOptionalTag(ConventionalItemTags.IRON_RAW_MATERIALS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_RAW_IRON)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_IRON)
                .add(ModItems.IRON_CHISEL)
                .add(Items.BUCKET)
                .add(Items.WATER_BUCKET)
                .add(Items.LAVA_BUCKET)
                .add(Items.POWDER_SNOW_BUCKET)
                .setReplace(true);
        valueLookupBuilder(ModTags.COPPER)
                .addOptionalTag(ConventionalItemTags.COPPER_INGOTS)
                .addOptionalTag(ConventionalItemTags.COPPER_ORES)
                .addOptionalTag(ConventionalItemTags.COPPER_BARS)
                .addOptionalTag(ConventionalItemTags.COPPER_NUGGETS)
                .addOptionalTag(ConventionalItemTags.COPPER_RAW_MATERIALS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_RAW_COPPER)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_COPPER)
                .add(ModItems.COPPER_CHISEL)
                .setReplace(true);
        valueLookupBuilder(ModTags.GOLD)
                .addOptionalTag(ConventionalItemTags.GOLD_INGOTS)
                .addOptionalTag(ConventionalItemTags.GOLD_ORES)
                .addOptionalTag(ConventionalItemTags.GOLD_NUGGETS)
                .addOptionalTag(ConventionalItemTags.GOLD_RAW_MATERIALS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_RAW_GOLD)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_GOLD)
                .add(ModItems.GOLD_CHISEL)
                .setReplace(true);
        valueLookupBuilder(ModTags.NETHERITE)
                .addOptionalTag(ConventionalItemTags.NETHERITE_INGOTS)
                .addOptionalTag(ConventionalItemTags.NETHERITE_SCRAP_ORES)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_NETHERITE)
                .add(ModItems.NETHERITE_CHISEL)
                .setReplace(true);
        valueLookupBuilder(ModTags.DIAMOND)
                .addOptionalTag(ConventionalItemTags.DIAMOND_GEMS)
                .addOptionalTag(ConventionalItemTags.DIAMOND_ORES)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_DIAMOND)
                .add(ModItems.DIAMOND_CHISEL)
                .setReplace(true);
        valueLookupBuilder(ModTags.EMERALD)
                .addOptionalTag(ConventionalItemTags.EMERALD_GEMS)
                .addOptionalTag(ConventionalItemTags.EMERALD_GEMS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_EMERALD)
                .setReplace(true);
        valueLookupBuilder(ModTags.LAPIS)
                .addOptionalTag(ConventionalItemTags.LAPIS_GEMS)
                .addOptionalTag(ConventionalItemTags.LAPIS_ORES)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_LAPIS)
                .setReplace(true);
        valueLookupBuilder(ModTags.REDSTONE)
                .addOptionalTag(ConventionalItemTags.REDSTONE_DUSTS)
                .addOptionalTag(ConventionalItemTags.REDSTONE_ORES)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_REDSTONE)
                .setReplace(true);
        valueLookupBuilder(ModTags.QUARTZ)
                .addOptionalTag(ConventionalItemTags.QUARTZ_GEMS)
                .addOptionalTag(ConventionalItemTags.QUARTZ_ORES)
                .setReplace(true);
        valueLookupBuilder(ModTags.AMETHYST)
                .addOptionalTag(ConventionalItemTags.AMETHYST_GEMS)
                .add(Items.AMETHYST_BLOCK)
                .add(Items.AMETHYST_CLUSTER)
                .setReplace(true);
        valueLookupBuilder(ModTags.PRISMARINE)
                .addOptionalTag(ConventionalItemTags.PRISMARINE_GEMS)
                .add(Items.PRISMARINE)
                .add(Items.PRISMARINE_BRICK_SLAB)
                .add(Items.PRISMARINE_BRICKS)
                .add(Items.PRISMARINE_BRICK_STAIRS)
                .add(Items.PRISMARINE_SHARD)
                .add(Items.PRISMARINE_SLAB)
                .add(Items.PRISMARINE_STAIRS)
                .add(Items.PRISMARINE_WALL)
                .add(Items.DARK_PRISMARINE)
                .add(Items.DARK_PRISMARINE_STAIRS)
                .add(Items.DARK_PRISMARINE_SLAB)
                .setReplace(true);
        valueLookupBuilder(ModTags.COAL)
                .addOptionalTag(ConventionalItemTags.COAL_ORES)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_COAL)
                .setReplace(true);
        valueLookupBuilder(ModTags.RESIN)
                .addOptionalTag(ConventionalItemTags.RESIN_BRICKS)
                .addOptionalTag(ConventionalItemTags.RESIN_CLUMPS)
                .addOptionalTag(ConventionalItemTags.STORAGE_BLOCKS_RESIN)
                .setReplace(true);
    }
}
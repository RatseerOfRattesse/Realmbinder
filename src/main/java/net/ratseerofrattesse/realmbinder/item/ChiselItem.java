package net.ratseerofrattesse.realmbinder.item;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.ratseerofrattesse.realmbinder.Realmbinder;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import net.ratseerofrattesse.realmbinder.component.PlateMaterialComponent;
import net.ratseerofrattesse.realmbinder.component.PotentiaComponent;
import net.ratseerofrattesse.realmbinder.tag.ModTags;

import java.util.*;

import static java.util.Map.entry;

public class ChiselItem extends Item {
    public ChiselItem(Properties properties) {
        super(properties);
    }

    Map<TagKey<Item>, TagKey<Item>> miningLevels = Map.ofEntries(
            entry(ModTags.MINING_LEVEL_ONE, ModTags.PROCESSES_MINING_LEVEL_ONE),
            entry(ModTags.MINING_LEVEL_TWO, ModTags.PROCESSES_MINING_LEVEL_TWO),
            entry(ModTags.MINING_LEVEL_THREE, ModTags.PROCESSES_MINING_LEVEL_THREE),
            entry(ModTags.MINING_LEVEL_FOUR, ModTags.PROCESSES_MINING_LEVEL_FOUR),
            entry(ModTags.MINING_LEVEL_FIVE, ModTags.PROCESSES_MINING_LEVEL_FIVE),
            entry(ModTags.MINING_LEVEL_SIX, ModTags.PROCESSES_MINING_LEVEL_SIX)
    );

    Map<TagKey<Item>, String> rootItems = Map.ofEntries(
            entry(ConventionalItemTags.STONES, "minecraft:stone"),
            entry(ConventionalItemTags.NETHERRACKS, "minecraft:netherrack"),
            entry(ConventionalItemTags.END_STONES, "minecraft:end_stone"),
            entry(ConventionalItemTags.NORMAL_OBSIDIANS, "minecraft:obsidian"),
            entry(ConventionalItemTags.CRYING_OBSIDIANS, "minecraft:crying_obsidian"),
            entry(ModTags.IRON, "minecraft:iron_ingot"),
            entry(ModTags.COPPER, "minecraft:copper_ingot"),
            entry(ModTags.GOLD, "minecraft:gold_ingot"),
            entry(ModTags.NETHERITE, "minecraft:netherite_ingot"),
            entry(ModTags.PRISMARINE, "minecraft:prismarine"),
            entry(ModTags.DIAMOND, "minecraft:diamond"),
            entry(ModTags.EMERALD, "minecraft:emerald"),
            entry(ModTags.MENDARUM, "realmbinder:mendarum_shard"),
            entry(ModTags.REHNTITE, "realmbinder:rehntite_ingot"),
            entry(ModTags.LAPIS, "minecraft:lapis_lazuli"),
            entry(ModTags.COAL, "minecraft:coal"),
            entry(ModTags.AMETHYST, "minecraft:amethyst_shard"),
            entry(ModTags.QUARTZ, "minecraft:quartz"),
            entry(ModTags.REDSTONE, "minecraft:redstone"),
            entry(ModTags.LEATHER, "minecraft:leather"),
            entry(ModTags.RESIN, "minecraft:resin_clump")
    );

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }
        if (player.getMainHandItem().tags().anyMatch(ModTags.PLATE_MATERIAL::equals) || player.getOffhandItem().tags().anyMatch(ModTags.PLATE_MATERIAL::equals)) {
            EquipmentSlot slot;
            EquipmentSlot chiselSlot;
            if (player.getMainHandItem().tags().anyMatch(ModTags.PLATE_MATERIAL::equals)) {
                slot = EquipmentSlot.MAINHAND;
                chiselSlot = EquipmentSlot.OFFHAND;
            } else {
                slot = EquipmentSlot.OFFHAND;
                chiselSlot = EquipmentSlot.MAINHAND;
            }
            ItemStack material = player.getItemBySlot(slot);
            ItemStack chisel = player.getItemBySlot(chiselSlot);
            for (TagKey<Item> itemTag : miningLevels.keySet()) {
                if (material.tags().anyMatch(itemTag::equals)) {
                    if (chisel.tags().anyMatch(miningLevels.get(itemTag)::equals)) {
                        ItemStack materialPlate = new ItemStack(ModItems.MATERIAL_PLATE);
                        ItemStack materialBackup = material.copy();;
                        if (material.getItem() instanceof BlockItem) {
                            if (player.isShiftKeyDown()) {
                                materialPlate.setCount(material.count() * 3);
                                chisel.hurtAndBreak(2*material.count(), player, chiselSlot);
                                material.setCount(0);
                            } else {
                                materialPlate.setCount(3);
                                material.setCount(material.count() - 1);
                                chisel.hurtAndBreak(2, player, chiselSlot);
                            }
                        } else {
                            if (player.isShiftKeyDown()) {
                                materialPlate.setCount(material.count() / 3);
                                chisel.hurtAndBreak(material.count(), player, chiselSlot);
                                material.setCount(material.count() % 3);
                            } else {
                                materialPlate.setCount(1);
                                material.setCount(material.count() - 3);
                                chisel.hurtAndBreak(1, player, chiselSlot);
                            }
                        }
                        if (materialBackup.tags().anyMatch(rootItems::containsKey)) {
                            ArrayList<Item> itemCandidates = new ArrayList<>();
                            for (TagKey<Item> tag : rootItems.keySet()) {
                                if (materialBackup.tags().anyMatch(tag::equals)) {
                                    String[] processedString = rootItems.get(tag).split(":");
                                    Identifier itemId = Identifier.fromNamespaceAndPath(processedString[0], processedString[1]);
                                    Item item = BuiltInRegistries.ITEM.getValue(itemId);
                                    itemCandidates.addLast(item);
                                }
                            }
                            Map<Integer, Item> candidates = new HashMap<>();
                            for (Item item : itemCandidates) {
                                candidates.put(Objects.requireNonNull(item.getDefaultInstance().get(ModComponents.POTENTIA)).potentia(), item);
                            }
                            //texture stuff here from item
                            int maxPotentia = Collections.max(candidates.keySet());
                            Identifier identifier = BuiltInRegistries.ITEM.getKey(candidates.get(maxPotentia));
                            materialPlate.set(ModComponents.PLATE_MATERIAL, new PlateMaterialComponent(identifier.getNamespace() + ":" + identifier.getPath()));
                            materialPlate.set(ModComponents.POTENTIA, new PotentiaComponent(maxPotentia, maxPotentia));
                        } else {
                            Identifier identifier = BuiltInRegistries.ITEM.getKey(materialBackup.getItem());
                            materialPlate.set(ModComponents.PLATE_MATERIAL, new PlateMaterialComponent(identifier.getNamespace() + ":" + identifier.getPath()));
                            materialPlate.set(ModComponents.POTENTIA, materialBackup.get(ModComponents.POTENTIA));
                        }
                        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.PLAYERS, 1.0f, 1.0f);
                        player.addItem(materialPlate);
                        return InteractionResult.SUCCESS;
                    } else {
                        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0f, 1.0f);
                        chisel.hurtAndBreak(5, player, chiselSlot);
                        return InteractionResult.FAIL;
                    }
                }
            }
        } else {
            return InteractionResult.FAIL;
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return super.useOn(context);
    }
}

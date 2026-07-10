package net.ratseerofrattesse.realmbinder.potentia;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.ratseerofrattesse.realmbinder.Realmbinder;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import net.ratseerofrattesse.realmbinder.component.PotentiaComponent;
import net.ratseerofrattesse.realmbinder.entity.attribute.ModAttributes;
import net.ratseerofrattesse.realmbinder.item.ModItems;
import net.ratseerofrattesse.realmbinder.tag.ModTags;

import java.util.*;

import static java.util.Map.entry;

public class PotentiaHelper {


    //TODO automate this list
    public static List<Holder<Attribute>> vanillaHolders = List.of(Attributes.ARMOR, Attributes.ARMOR_TOUGHNESS, Attributes.ATTACK_DAMAGE, Attributes.ATTACK_KNOCKBACK, Attributes.ATTACK_SPEED, Attributes.BLOCK_BREAK_SPEED, Attributes.BLOCK_INTERACTION_RANGE, Attributes.BURNING_TIME, Attributes.CAMERA_DISTANCE, Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, Attributes.ENTITY_INTERACTION_RANGE, Attributes.FALL_DAMAGE_MULTIPLIER, Attributes.FLYING_SPEED, Attributes.FOLLOW_RANGE, Attributes.GRAVITY, Attributes.JUMP_STRENGTH, Attributes.KNOCKBACK_RESISTANCE, Attributes.LUCK, Attributes.MAX_ABSORPTION, Attributes.MAX_HEALTH, Attributes.MINING_EFFICIENCY, Attributes.MOVEMENT_EFFICIENCY, Attributes.MOVEMENT_SPEED, Attributes.OXYGEN_BONUS, Attributes.SAFE_FALL_DISTANCE, Attributes.SCALE, Attributes.SNEAKING_SPEED, Attributes.SPAWN_REINFORCEMENTS_CHANCE, Attributes.STEP_HEIGHT, Attributes.SUBMERGED_MINING_SPEED, Attributes.SWEEPING_DAMAGE_RATIO, Attributes.TEMPT_RANGE, Attributes.WATER_MOVEMENT_EFFICIENCY, Attributes.WAYPOINT_TRANSMIT_RANGE, Attributes.WAYPOINT_RECEIVE_RANGE);

    static Map<Item, Integer> itemPotentia = Map.ofEntries(
            entry(ModItems.DEBUGGER, 20000),
            entry(Items.COMMAND_BLOCK, 20000),
            entry(Items.COMMAND_BLOCK_MINECART, 20000),
            entry(Items.CHAIN_COMMAND_BLOCK, 20000),
            entry(Items.REPEATING_COMMAND_BLOCK, 20000),
            entry(Items.BARRIER, 20000),
            entry(Items.STRUCTURE_BLOCK, 20000),
            entry(Items.STRUCTURE_VOID, 20000),
            entry(Items.BEDROCK, 15000),
            entry(Items.REINFORCED_DEEPSLATE, 500)
    );

    static Map<TagKey<Item>, Integer> itemTagPotentia = Map.ofEntries(
            entry(ModTags.PLANT_MATTER, 25),
            entry(ConventionalItemTags.NETHERRACKS, 10),
            entry(ConventionalItemTags.END_STONES, 30),
            entry(ConventionalItemTags.NORMAL_OBSIDIANS, 30),
            entry(ConventionalItemTags.CRYING_OBSIDIANS, 20),
            entry(ModTags.IRON, 25),
            entry(ModTags.COPPER, 20),
            entry(ModTags.GOLD, 250),
            entry(ModTags.NETHERITE, 150),
            entry(ModTags.PRISMARINE, 70),
            entry(ModTags.DIAMOND, 130),
            entry(ModTags.EMERALD, 100),
            entry(ModTags.MENDARUM, 1000),
            entry(ModTags.REHNTITE, 1500),
            entry(ModTags.LAPIS, 400),
            entry(ModTags.COAL, 40),
            entry(ModTags.AMETHYST, 400),
            entry(ModTags.QUARTZ, 200),
            entry(ModTags.REDSTONE, 40),
            entry(ModTags.LEATHER, 50),
            entry(ConventionalItemTags.GLOWSTONE_DUSTS, 40),
            entry(ModTags.RESIN, 60),
            entry(ConventionalItemTags.POTIONS, 250),
            entry(ConventionalItemTags.FOODS, 200),
            entry(ConventionalItemTags.DRINKS, 200),
            entry(ConventionalItemTags.DRINK_CONTAINING_BOTTLE, 200),
            entry(ConventionalItemTags.DRINK_CONTAINING_BUCKET, 200),
            entry(ConventionalItemTags.ENTITY_WATER_BUCKETS, 250),
            entry(ConventionalItemTags.SHULKER_BOXES, 300),
            entry(ModTags.BOSS_DROPS, 15000),
            entry(ModTags.MOB_DROPS, 50)
    );

    static Map<String, Integer> itemNamePotentia = Map.ofEntries(
            entry("Diamond", 130),
            entry("Lapis", 300),
            entry("Gold", 250),
            entry("Mendarum", 1000),
            entry("Rehntite", 1500),
            entry("Emerald", 100),
            entry("Iron", 25),
            entry("Copper", 20),
            entry("Coal", 40),
            entry("Netherite", 150),
            entry("Amethyst", 300),
            entry("Quartz", 200),
            entry("Redstone", 40),
            entry("Leather", 50),
            entry("Prismarine", 70),
            entry("Glowstone", 40),
            entry("Resin", 60)
    );

    static List<EntityType<?>> sentient = List.of(EntityType.VILLAGER, EntityType.PLAYER, EntityType.PIGLIN, EntityType.PIGLIN_BRUTE, EntityType.PILLAGER, EntityType.VINDICATOR, EntityType.EVOKER, EntityType.RAVAGER, EntityType.ENDERMAN);

    static List<EntityType<?>> bosses = List.of(EntityType.ENDER_DRAGON, EntityType.WITHER, EntityType.CREAKING, EntityType.WARDEN);

    static List<EntityType<?>> undead = List.of(EntityType.CAMEL_HUSK, EntityType.SKELETON_HORSE, EntityType.ZOMBIE_HORSE, EntityType.DROWNED, EntityType.ZOMBIE, EntityType.ZOMBIE_NAUTILUS, EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIFIED_PIGLIN, EntityType.ZOGLIN, EntityType.BOGGED, EntityType.HUSK, EntityType.PARCHED, EntityType.SKELETON, EntityType.STRAY, EntityType.WITHER_SKELETON);

    static List<EntityType<?>> nonAlive = List.of(EntityType.AREA_EFFECT_CLOUD, EntityType.MANNEQUIN, EntityType.ARMOR_STAND, EntityType.ARROW, EntityType.EGG, EntityType.ENDER_PEARL, EntityType.END_CRYSTAL, EntityType.EVOKER_FANGS, EntityType.EYE_OF_ENDER, EntityType.EXPERIENCE_ORB, EntityType.FALLING_BLOCK, EntityType.EXPERIENCE_BOTTLE, EntityType.FISHING_BOBBER, EntityType.INTERACTION, EntityType.LIGHTNING_BOLT, EntityType.LEASH_KNOT, EntityType.LLAMA_SPIT, EntityType.MARKER, EntityType.PAINTING, EntityType.TNT, EntityType.TEXT_DISPLAY, EntityType.SHULKER_BULLET, EntityType.TRIDENT, EntityType.BIRCH_BOAT, EntityType.BIRCH_CHEST_BOAT, EntityType.ACACIA_BOAT, EntityType.ACACIA_CHEST_BOAT, EntityType.CHERRY_CHEST_BOAT, EntityType.CHERRY_BOAT, EntityType.DARK_OAK_BOAT, EntityType.DARK_OAK_CHEST_BOAT, EntityType.JUNGLE_BOAT, EntityType.JUNGLE_CHEST_BOAT, EntityType.MANGROVE_BOAT, EntityType.MANGROVE_CHEST_BOAT, EntityType.OAK_BOAT, EntityType.OAK_CHEST_BOAT, EntityType.PALE_OAK_BOAT, EntityType.PALE_OAK_CHEST_BOAT, EntityType.SPRUCE_BOAT, EntityType.SPRUCE_CHEST_BOAT, EntityType.ITEM_FRAME, EntityType.GLOW_ITEM_FRAME, EntityType.MINECART, EntityType.CHEST_MINECART, EntityType.FURNACE_MINECART, EntityType.TNT_MINECART, EntityType.COMMAND_BLOCK_MINECART, EntityType.HOPPER_MINECART, EntityType.SPAWNER_MINECART, EntityType.ARROW, EntityType.SPECTRAL_ARROW, EntityType.BIRCH_BOAT, EntityType.FIREBALL, EntityType.SMALL_FIREBALL, EntityType.DRAGON_FIREBALL, EntityType.SNOWBALL, EntityType.BREEZE_WIND_CHARGE, EntityType.WIND_CHARGE, EntityType.WITHER_SKULL);

    static List<EntityType<?>> golem = List.of(EntityType.SNOW_GOLEM, EntityType.IRON_GOLEM, EntityType.COPPER_GOLEM, EntityType.BLAZE, EntityType.BREEZE, EntityType.VEX, EntityType.GUARDIAN, EntityType.ELDER_GUARDIAN);

    static List<EntityType<?>> end = List.of(EntityType.SHULKER, EntityType.PHANTOM);

    static List<EntityType<?>> nether = List.of(EntityType.HAPPY_GHAST, EntityType.STRIDER, EntityType.MAGMA_CUBE, EntityType.GHAST, EntityType.HOGLIN);


    static Map<List<EntityType<?>>, Integer> entityTagPotentia = Map.ofEntries(
            entry(sentient, 5000),
            entry(bosses, 20000),
            entry(undead, 1000),
            entry(nonAlive, 0),
            entry(golem, 2000),
            entry(end, 1200),
            entry(nether, 600)
    );

    //static Map<HashSet<EntityType<?>>, Integer> entityTagPotentia = new HashMap<>();

    public static void initialize() {

        Realmbinder.LOGGER.info("Applying potentia for {}.", Realmbinder.MOD_ID);

        /*
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ConventionalEntityTypeTags.BOSSES).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 20000);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ModTags.SENTIENT).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 5000);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(EntityTypeTags.UNDEAD).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 1000);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ModTags.NON_ALIVE).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 0);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ModTags.GOLEM).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 2000);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ModTags.NETHER).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 600);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ModTags.ARCHMOB).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 20000);
        entityTagPotentia.put(BuiltInRegistries.ENTITY_TYPE.get(ModTags.END).stream().flatMap(holders -> holders.stream().map(Holder::value)).collect(Collectors.toCollection(HashSet::new)), 1200);

         */

        // default 3 potentia for all items
        DefaultItemComponentEvents.MODIFY.register(context -> {
            for (Item item : BuiltInRegistries.ITEM) {
                if (!item.getDefaultInstance().getComponents().has(ModComponents.POTENTIA)) {
                    context.modify(item, builder -> {
                        builder.set(ModComponents.POTENTIA, getPotentia(item));
                    });
                }
            }
        });

        //TODO make this not stupid :sob:
        for (EntityType<?> entityType : BuiltInRegistries.ENTITY_TYPE) {
            List<Integer> potentiaValues = new ArrayList<>();
            List<Boolean> presetEntity = new ArrayList<>();
            /*
            for (HashSet hashSet : entityTagPotentia.keySet().stream().toList()) {
                if (hashSet.contains(entityType)) {
                    potentiaValues.add(entityTagPotentia.get(hashSet));
                    presetEntity.add(true);
                } else {
                    presetEntity.add(false);
                }
            }

             */
            for (List<EntityType<?>> list : entityTagPotentia.keySet().stream().toList()) {
                if (list.contains(entityType)) {
                    potentiaValues.add(entityTagPotentia.get(list));
                    presetEntity.add(true);
                } else {
                    presetEntity.add(false);
                }
            }
            if (presetEntity.contains(true)) {
                if (potentiaValues.contains(0)) {
                    //non-alive; do not add potentia
                }
                applyPotentiaModifiers(entityType, Collections.max(potentiaValues));
            } else {
                applyPotentiaModifiers(entityType, 200);
            }
        }
    }

    public static PotentiaComponent getPotentia(Item item) {
        if (itemPotentia.keySet().stream().anyMatch(item::equals)) {
            return new PotentiaComponent(itemPotentia.get(item), itemPotentia.get(item));
        } else if (item.getDefaultInstance().tags().anyMatch(itemTagPotentia::containsKey)) {
            List<TagKey<Item>> matchingKeys = item.getDefaultInstance().tags().filter(itemTagPotentia::containsKey).toList();
            List<Integer> potentiaValues = new ArrayList<>();
            for (TagKey<Item> tag : matchingKeys) {
                potentiaValues.add(itemTagPotentia.get(tag));
            }
            return new PotentiaComponent(Collections.max(potentiaValues), Collections.max(potentiaValues));
        } else if (itemNamePotentia.keySet().stream().anyMatch(item.getDefaultInstance().getItemName().getString()::contains)) {
            List<String> matchingKeys = itemNamePotentia.keySet().stream().filter(item.getDefaultInstance().getItemName().getString()::contains).toList();
            List<Integer> potentiaValues = new ArrayList<>();
            for (String string : matchingKeys) {
                potentiaValues.add(itemNamePotentia.get(string));
            }
            return new PotentiaComponent(Collections.max(potentiaValues), Collections.max(potentiaValues));
        } else if (item.getDefaultInstance().getRarity() == Rarity.COMMON) {
            return new PotentiaComponent(3, 3);
        } else if (item.getDefaultInstance().getRarity() == Rarity.UNCOMMON) {
            return new PotentiaComponent(25,25);
        } else if (item.getDefaultInstance().getRarity() == Rarity.RARE) {
            return new PotentiaComponent(230,230);
        } else if (item.getDefaultInstance().getRarity() == Rarity.EPIC) {
            return new PotentiaComponent(4000,4000);
        } else {
            return new PotentiaComponent(3,3);
        }
    }


    public static void applyPotentiaModifiers(EntityType entityType, double potentia) {
        AttributeSupplier supplier = DefaultAttributes.getSupplier(entityType);
        if(!(supplier == null)) {
            AttributeSupplier.Builder builder = AttributeSupplier.builder();
            for (Holder<Attribute> attributeHolder : vanillaHolders) {
                if(supplier.hasAttribute(attributeHolder)) {
                    double defaultValue = supplier.getBaseValue(attributeHolder);
                    builder.add(attributeHolder, defaultValue);
                }
            }
            FabricDefaultAttributeRegistry.register(entityType, builder
                    .add(ModAttributes.POTENTIA, potentia)
                    .add(ModAttributes.CAPACITY, potentia));
        }
    }
}

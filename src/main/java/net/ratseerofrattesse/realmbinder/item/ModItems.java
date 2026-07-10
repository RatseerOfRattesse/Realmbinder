package net.ratseerofrattesse.realmbinder.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.ratseerofrattesse.realmbinder.Realmbinder;
import net.ratseerofrattesse.realmbinder.component.*;

import java.util.List;
import java.util.function.Function;

public class ModItems {

    public static void initialize() {
        Realmbinder.LOGGER.info("Registering {} items", Realmbinder.MOD_ID);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, REALMBINDER_KEY, REALMBINDER);
        //attachTooltips();
    }

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, name));
        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));
        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static final Item DEBUGGER = register("debugger", Item::new, new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .component(ModComponents.POTENTIA, new PotentiaComponent(500, 1000))
                    .stacksTo(1));

    public static final Item PRECISE_RUNECARVER_LENS = register("precise_runecarver_lens", Item::new, new Item.Properties()
            .component(ModComponents.POTENTIA, new PotentiaComponent(400,400))
            .component(ModComponents.TOOLTIP, new TooltipComponent("precise_runecarver_lens,gray","realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "potentia.format,gold " +
                            "empty,gray " +
                    "hands,gray " +
                    "runecarver_lens.hands,gold " +
                            "empty,gray " +
                    "selected_inventory,gray " +
                    "runecarver_lens.selected_inventory,gold","realmbinder", "shift:false"))
            .stacksTo(1));
    public static final Item RUNECARVER_LENS = register("runecarver_lens", Item::new, new Item.Properties()
            .component(ModComponents.POTENTIA, new PotentiaComponent(200,200))
            .component(ModComponents.TOOLTIP, new TooltipComponent("runecarver_lens,gray","realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "potentia.manifests,gold " +
                            "empty,gray " +
                            "hands,gray " +
                            "runecarver_lens.hands,gold " +
                            "empty,gray " +
                            "selected_inventory,gray " +
                            "runecarver_lens.selected_inventory,gold","realmbinder", "shift:false"))
            .stacksTo(1));

    public static final Item MATERIAL_PLATE = register("material_plate", MaterialPlateItem::new, new Item.Properties()
            .component(ModComponents.PLATE_MATERIAL, new PlateMaterialComponent("realmbinder:material_plate"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "material_plate,gold",
                    "realmbinder", "shift:false"
            )));


    public static final Item IRON_CHISEL = register("iron_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(250)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));
    public static final Item COPPER_CHISEL = register("copper_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(191)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));
    public static final Item GOLD_CHISEL = register("gold_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(32)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));
    public static final Item DIAMOND_CHISEL = register("diamond_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(1561)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));
    public static final Item NETHERITE_CHISEL = register("netherite_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(2031)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));
    public static final Item MENDARUM_CHISEL = register("mendarum_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(256)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));
    public static final Item REHNTITE_CHISEL = register("rehntite_chisel", ChiselItem::new, new Item.Properties()
            .stacksTo(1)
            .durability(4096)
            .component(ModComponents.TOOLTIP, new TooltipComponent("chisel,gray", "realmbinder"))
            .component(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(
                    "chisel.plate,gold " +
                            "empty,gray " +
                            "rclick,gray " +
                            "chisel.single,gold " +
                            "empty,gray " +
                            "shiftrclick,gray " +
                            "chisel.stack,gold " +
                            "empty,gray " +
                            "rclick_carve,gray " +
                            "chisel.carve,gold",
                    "realmbinder", "shift:false"
            )));

    public static final Item MENDARUM_SHARD = register("mendarum_shard", Item::new, new Item.Properties()
            .component(ModComponents.TOOLTIP, new TooltipComponent(
                    "mendarum,gray",
                    "realmbinder"
            )));
    public static final Item REHNTITE_INGOT = register("rehntite_ingot", Item::new, new Item.Properties()
            .component(ModComponents.TOOLTIP, new TooltipComponent(
                    "rehntite,gray",
                    "realmbinder"
            )));

    public static final ResourceKey<CreativeModeTab> REALMBINDER_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "creative_tab")
    );

    public static final CreativeModeTab REALMBINDER = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.DEBUGGER))
            .title(Component.translatable("realmbinder.tab"))
            .displayItems((params, output) -> {
                ItemStack lapisPlate = new ItemStack(ModItems.MATERIAL_PLATE);
                lapisPlate.set(ModComponents.PLATE_MATERIAL, new PlateMaterialComponent("minecraft:lapis_lazuli"));
                List<String> colours = List.of("white", "light_gray", "gray", "black", "brown", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink");
                for (String colour : colours) {
                    ItemStack mendarumShard = new ItemStack(ModItems.MENDARUM_SHARD);
                    mendarumShard.set(ModComponents.VANILLA_COLOUR, new VanillaColourComponent(colour));
                    output.accept(mendarumShard);
                }
                output.accept(ModItems.REHNTITE_INGOT);
                output.accept(lapisPlate);
                output.accept(ModItems.IRON_CHISEL);
                output.accept(ModItems.COPPER_CHISEL);
                output.accept(ModItems.GOLD_CHISEL);
                output.accept(ModItems.DIAMOND_CHISEL);
                output.accept(ModItems.NETHERITE_CHISEL);
                ItemStack mendarumChisel = new ItemStack(ModItems.MENDARUM_CHISEL);
                mendarumChisel.set(ModComponents.VANILLA_COLOUR, new VanillaColourComponent("magenta"));
                output.accept(mendarumChisel);
                output.accept(ModItems.REHNTITE_CHISEL);
                output.accept(ModItems.RUNECARVER_LENS);
                output.accept(ModItems.PRECISE_RUNECARVER_LENS);
                output.accept(ModItems.DEBUGGER);
                output.accept(Items.FEATHER);

            })
            .build();
}

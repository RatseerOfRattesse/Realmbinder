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
import net.ratseerofrattesse.realmbinder.component.ConditionalTooltipComponent;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import net.ratseerofrattesse.realmbinder.component.PotentiaComponent;
import net.ratseerofrattesse.realmbinder.component.TooltipComponent;

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
                    .component(ModComponents.POTENTIA, new PotentiaComponent(1000, 1000))
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

    public static final ResourceKey<CreativeModeTab> REALMBINDER_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "creative_tab")
    );


    public static final CreativeModeTab REALMBINDER = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.DEBUGGER))
            .title(Component.translatable("realmbinder.tab"))
            .displayItems((params, output) -> {
                output.accept(ModItems.RUNECARVER_LENS);
                output.accept(ModItems.PRECISE_RUNECARVER_LENS);
                output.accept(Items.FEATHER);
                output.accept(ModItems.DEBUGGER);
            })
            .build();
}

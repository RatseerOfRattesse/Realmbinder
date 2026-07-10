package net.ratseerofrattesse.realmbinder.component;

import net.fabricmc.fabric.api.item.v1.ItemComponentTooltipProviderRegistry;
import net.minecraft.core.component.DataComponents;
import net.ratseerofrattesse.realmbinder.Realmbinder;

public class ModTooltipProviders {
    public static void initialize() {
        Realmbinder.LOGGER.info("Registering {} tooltip providers", Realmbinder.MOD_ID);
        register();
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }

    public static void register() {
        ItemComponentTooltipProviderRegistry.addAfter(DataComponents.DAMAGE, ModComponents.PLATE_MATERIAL);
        ItemComponentTooltipProviderRegistry.addAfter(ModComponents.PLATE_MATERIAL, ModComponents.VANILLA_COLOUR);
        ItemComponentTooltipProviderRegistry.addAfter(ModComponents.VANILLA_COLOUR, ModComponents.TOOLTIP);
        ItemComponentTooltipProviderRegistry.addAfter(ModComponents.TOOLTIP, ModComponents.CONDITIONAL_TOOLTIP);
    }
}

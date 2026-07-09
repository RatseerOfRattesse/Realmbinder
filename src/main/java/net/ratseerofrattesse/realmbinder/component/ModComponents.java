package net.ratseerofrattesse.realmbinder.component;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.ratseerofrattesse.realmbinder.Realmbinder;

public class ModComponents {
    public static void initialize() {
        Realmbinder.LOGGER.info("Registering {} components", Realmbinder.MOD_ID);
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }

    public static final DataComponentType<PotentiaComponent> POTENTIA = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "hidden_potentia"),
            DataComponentType.<PotentiaComponent>builder().persistent(PotentiaComponent.CODEC).build()
    );

    public static final DataComponentType<TooltipComponent> TOOLTIP = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "tooltip"),
            DataComponentType.<TooltipComponent>builder().persistent(TooltipComponent.CODEC).build()
    );

    public static final DataComponentType<ConditionalTooltipComponent> CONDITIONAL_TOOLTIP = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "shift_down"),
            DataComponentType.<ConditionalTooltipComponent>builder().persistent(ConditionalTooltipComponent.CODEC).build()
    );

}

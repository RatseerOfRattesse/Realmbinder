package net.ratseerofrattesse.realmbinder.entity.attribute;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.ratseerofrattesse.realmbinder.Realmbinder;

public class ModAttributes {

    public static void initialize(){
        Realmbinder.LOGGER.info("Registering {} attributes", Realmbinder.MOD_ID);
    };

    private static Holder<Attribute> register(
            String name, double defaultValue, double minValue, double maxValue, boolean syncedWithClient
    ) {
        Identifier identifier = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, name);
        Attribute entityAttribute = new RangedAttribute(
                identifier.toLanguageKey(),
                defaultValue,
                minValue,
                maxValue
        ).setSyncable(syncedWithClient);

        return Registry.registerForHolder(BuiltInRegistries.ATTRIBUTE, identifier, entityAttribute);
    }

    public static final Holder<Attribute> POTENTIA = register(
            "potentia",
            200.0,
            0.0,
            Double.MAX_VALUE,
            false
    );

    public static final Holder<Attribute> CAPACITY = register(
            "capacity",
            200.0,
            0.0,
            Double.MAX_VALUE,
            false
    );

}

package net.ratseerofrattesse.realmbinder.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;

public record PlateMaterialComponent(String itemId) implements TooltipProvider {

    public static final Codec<PlateMaterialComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("itemId").forGetter(PlateMaterialComponent::itemId)
    ).apply(builder, PlateMaterialComponent::new));

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        consumer.accept(Component.translatable("tooltip.realmbinder.plate_material").withStyle(ChatFormatting.GRAY));
        String[] processedString = this.itemId.split(":");
        Identifier itemId = Identifier.fromNamespaceAndPath(processedString[0], processedString[1]);
        Item item = BuiltInRegistries.ITEM.getValue(itemId);
        consumer.accept(Component.literal("  " + item.getDefaultInstance().getItemName().getString()).withStyle(ChatFormatting.GOLD));
    }
}

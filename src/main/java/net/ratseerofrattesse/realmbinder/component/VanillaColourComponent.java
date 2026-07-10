package net.ratseerofrattesse.realmbinder.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.Map;
import java.util.function.Consumer;

public record VanillaColourComponent(String colour) implements TooltipProvider {


    public static final Codec<VanillaColourComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("colour").forGetter(VanillaColourComponent::colour)
    ).apply(builder, VanillaColourComponent::new));

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        consumer.accept(Component.translatable("tooltip.realmbinder.colour." + colour).withStyle(ChatFormatting.GOLD));
    }
}

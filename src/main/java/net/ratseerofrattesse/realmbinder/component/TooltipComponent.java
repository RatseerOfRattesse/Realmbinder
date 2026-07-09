package net.ratseerofrattesse.realmbinder.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;

public record TooltipComponent(String lines, String modid) implements TooltipProvider {


    // String format: "lineOneKey,white lineTwoKey,aqua"
    // line one requires shift key down, line two does not
    // List of translation keys + color values! Not literal strings
    // separate by spaces

    public static final Codec<TooltipComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.STRING.fieldOf("lines").forGetter(TooltipComponent::lines),
                Codec.STRING.fieldOf("modid").forGetter(TooltipComponent::modid)
        ).apply(builder, TooltipComponent::new);
    });

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        String[] processedList = this.lines.split(" ");
        for (String string : processedList) {
            String[] processedString = string.split(",");
            String key = "tooltip." + this.modid + "." +  processedString[0];
            ChatFormatting color = ChatFormatting.getByName(processedString[1]);
            assert color != null;
            consumer.accept(Component.translatable(key).withStyle(color));
        }
    }
}

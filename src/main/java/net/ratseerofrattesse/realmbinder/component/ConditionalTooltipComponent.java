package net.ratseerofrattesse.realmbinder.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.Objects;
import java.util.function.Consumer;

public record ConditionalTooltipComponent(String lines, String modid, String condition) implements TooltipProvider {

    //condition
    //"shift:true" = "tooltip.modid.shift" etc. and the shift key is down

    public static final Codec<ConditionalTooltipComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.STRING.fieldOf("condition").forGetter(ConditionalTooltipComponent::condition),
                Codec.STRING.fieldOf("lines").forGetter(ConditionalTooltipComponent::lines),
                Codec.STRING.fieldOf("modid").forGetter(ConditionalTooltipComponent::modid)
        ).apply(builder, ConditionalTooltipComponent::new);
    });

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        String[] processedCondition = condition.split(":");
        String conditionkey = "tooltip." + this.modid + "." + processedCondition[0];
        if (Objects.equals(processedCondition[1], "false")) {
            consumer.accept(Component.translatable(conditionkey).withStyle(ChatFormatting.DARK_GRAY));
        } else if (Objects.equals(processedCondition[1], "true")) {
            consumer.accept(Component.translatable(conditionkey + "Active").withStyle(ChatFormatting.DARK_GRAY));
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
}

package net.ratseerofrattesse.realmbinder.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

public record TooltipComponent(String lines, String modid) implements TooltipProvider {


    // String format: "lineOneKey,white lineTwoKey,aqua"
    // line one requires shift key down, line two does not
    // List of translation keys + color values! Not literal strings
    // separate by spaces

    public static final Codec<TooltipComponent> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.STRING.fieldOf("lines").forGetter(TooltipComponent::lines),
            Codec.STRING.fieldOf("modid").forGetter(TooltipComponent::modid)
    ).apply(builder, TooltipComponent::new));

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> consumer, TooltipFlag flag, DataComponentGetter components) {
        String[] processedList = this.lines.split(" ");
        for (String string : processedList) {
            String[] processedString = string.split(",");


            String key = "tooltip." + this.modid + "." +  processedString[0];
            String translatedText = Component.translatable(key).getString();


            int length = translatedText.length();
            if (Objects.equals(processedString[1], "gold")){
                length += 2;
            }


            char underscore = '_';
            char formatCode = '§';
            long underscores = translatedText.chars()
                    .filter(ch -> ch == underscore)
                    .count();
            long formatCodes = translatedText.chars()
                    .filter(ch -> ch == formatCode)
                    .count();
            for (int i = 0; i == underscores; i ++) {
                length --;
            }
            for (int i = 0; i == formatCodes; i ++) {
                length -=2;
            }


            ArrayList<String> wrappedLines = new ArrayList<>();
            if (length > 40) {
                String[] words = translatedText.split(" ");
                StringBuilder assembledLine = new StringBuilder();
                if (Objects.equals(processedString[1], "gold")) {
                    assembledLine = new StringBuilder("  ");
                }
                for (String word : words) {
                    word = word + " ";
                    int wordLength = word.length();
                    long underscoresInWord = word.chars()
                            .filter(ch -> ch == underscore)
                            .count();
                    long formatCodesInWord = word.chars()
                            .filter(ch -> ch == formatCode)
                            .count();
                    for (int i = 0; i == underscoresInWord; i ++) {
                        wordLength --;
                    }
                    for (int i = 0; i == formatCodesInWord; i ++) {
                        length -=2;
                    }

                    if (assembledLine.length() + wordLength > 40) {
                        wrappedLines.addLast(assembledLine.toString());
                        assembledLine.setLength(0);
                    }
                    assembledLine.append(word);
                }
                wrappedLines.addLast(assembledLine.toString());
            } else {
                wrappedLines.add(translatedText);
            }

            for (String line : wrappedLines) {
                String[] segments = line.split("_");
                for (int i = 1; i < segments.length; i += 2) {
                    if (Objects.equals(processedString[1], "gold")){
                        segments[i] = "§e" + segments[i] + "§r";
                    }
                }
                StringBuilder finalString = new StringBuilder();
                if (Objects.equals(processedString[1], "gold")) {
                    finalString = new StringBuilder("  ");
                }
                for (String segment : segments){
                    finalString.append(segment);
                }

                ChatFormatting color = ChatFormatting.getByName(processedString[1]);
                assert color != null;
                consumer.accept(Component.literal(finalString.toString()).withStyle(color));
            }
        }
    }
}

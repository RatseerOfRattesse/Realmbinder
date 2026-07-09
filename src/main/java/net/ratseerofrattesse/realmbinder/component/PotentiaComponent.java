package net.ratseerofrattesse.realmbinder.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record PotentiaComponent(int potentia, int capacity) {

    public static final Codec<PotentiaComponent> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.INT.fieldOf("potentia").forGetter(PotentiaComponent::potentia),
                Codec.INT.fieldOf("capacity").forGetter(PotentiaComponent::capacity)
        ).apply(builder, PotentiaComponent::new);
    });
}

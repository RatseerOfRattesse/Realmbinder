package net.ratseerofrattesse.realmbinder.client;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.ARGB;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import org.jspecify.annotations.Nullable;

import java.awt.*;
import java.util.Map;
import java.util.Objects;

public record VanillaColourTintSource(int colour) implements ItemTintSource {

    public VanillaColourTintSource() {
        this(ARGB.opaque(0x00BFFF)); // Color code in hex format
    }

    public static final MapCodec<VanillaColourTintSource> MAP_CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    ExtraCodecs.RGB_COLOR_CODEC.fieldOf("color").forGetter(VanillaColourTintSource::colour)).apply(instance, VanillaColourTintSource::new)
    );

    static Map<String, Vec3> colours = Map.ofEntries(
            Map.entry("white", new Vec3(249, 255, 254)),
            Map.entry("light_gray", new Vec3(157, 157, 151)),
            Map.entry("gray", new Vec3(71, 79, 82)),
            Map.entry("black", new Vec3(29, 29, 33)),
            Map.entry("brown", new Vec3(131, 84, 50)),
            Map.entry("red", new Vec3(176, 46, 38)),
            Map.entry("orange", new Vec3(249, 128, 29)),
            Map.entry("yellow", new Vec3(254, 216, 61)),
            Map.entry("lime", new Vec3(128, 199, 31)),
            Map.entry("green", new Vec3(94, 124, 22)),
            Map.entry("cyan", new Vec3(22, 156, 156)),
            Map.entry("light_blue", new Vec3(58, 179, 218)),
            Map.entry("blue", new Vec3(60, 68, 170)),
            Map.entry("purple", new Vec3(137, 50, 184)),
            Map.entry("magenta", new Vec3(199, 78, 189)),
            Map.entry("pink", new Vec3(243, 139, 170))
    );



    @Override
    public int calculate(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity owner) {
        if (itemStack.has(ModComponents.VANILLA_COLOUR)) {
            String colourKey = Objects.requireNonNull(itemStack.get(ModComponents.VANILLA_COLOUR)).colour();
            return (255 << 24) | ((int) colours.get(colourKey).x << 16) | ((int) colours.get(colourKey).y << 8) | (int) colours.get(colourKey).z;
        }

        return ARGB.opaque(0xFFEFD5);
    }

    @Override
    public MapCodec<? extends ItemTintSource> type() {
        return MAP_CODEC;
    }
}

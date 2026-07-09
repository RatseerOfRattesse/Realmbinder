package net.ratseerofrattesse.realmbinder.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.ratseerofrattesse.realmbinder.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public ModEntityTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ModTags.SENTIENT)
                .addOptionalTag(EntityTypeTags.ILLAGER)
                .addOptionalTag(EntityTypeTags.ILLAGER_FRIENDS)
                .add(EntityType.VILLAGER)
                .add(EntityType.PLAYER)
                .add(EntityType.PIGLIN)
                .add(EntityType.RAVAGER)
                .add(EntityType.PIGLIN_BRUTE)
                .add(EntityType.ENDERMAN)
                .add(EntityType.WITCH)
                .setReplace(true);
        valueLookupBuilder(ModTags.NETHER)
                .add(EntityType.HAPPY_GHAST)
                .add(EntityType.STRIDER)
                .add(EntityType.MAGMA_CUBE)
                .add(EntityType.GHAST)
                .add(EntityType.HOGLIN)
                .setReplace(true);
        valueLookupBuilder(ModTags.END)
                .add(EntityType.SHULKER)
                .add(EntityType.PHANTOM)
                .setReplace(true);
        valueLookupBuilder(ModTags.ARCHMOB)
                .add(EntityType.CREAKING)
                .add(EntityType.WARDEN)
                .setReplace(true);
        valueLookupBuilder(ModTags.GOLEM)
                .add(EntityType.SNOW_GOLEM)
                .add(EntityType.IRON_GOLEM)
                .add(EntityType.COPPER_GOLEM)
                .add(EntityType.BLAZE)
                .add(EntityType.BREEZE)
                .add(EntityType.VEX)
                .add(EntityType.GUARDIAN)
                .add(EntityType.ELDER_GUARDIAN)
                .setReplace(true);
        valueLookupBuilder(ModTags.NON_ALIVE)
                .add(EntityType.AREA_EFFECT_CLOUD)
                .add(EntityType.MANNEQUIN)
                .add(EntityType.ARMOR_STAND)
                .add(EntityType.ARROW)
                .add(EntityType.EGG)
                .add(EntityType.ENDER_PEARL)
                .add(EntityType.END_CRYSTAL)
                .add(EntityType.EVOKER_FANGS)
                .add(EntityType.EYE_OF_ENDER)
                .add(EntityType.EXPERIENCE_ORB)
                .add(EntityType.FALLING_BLOCK)
                .add(EntityType.EXPERIENCE_BOTTLE)
                .add(EntityType.FISHING_BOBBER)
                .add(EntityType.INTERACTION)
                .add(EntityType.LIGHTNING_BOLT)
                .add(EntityType.LEASH_KNOT)
                .add(EntityType.LLAMA_SPIT)
                .add(EntityType.MARKER)
                .add(EntityType.PAINTING)
                .add(EntityType.TNT)
                .add(EntityType.TEXT_DISPLAY)
                .add(EntityType.SHULKER_BULLET)
                .add(EntityType.TRIDENT)
                .addOptionalTag(ConventionalEntityTypeTags.BOATS)
                .addOptionalTag(ConventionalEntityTypeTags.ITEM_FRAMES)
                .addOptionalTag(ConventionalEntityTypeTags.MINECARTS)
                .addOptionalTag(EntityTypeTags.ARROWS)
                .addOptionalTag(EntityTypeTags.IMPACT_PROJECTILES)
                .addOptionalTag(EntityTypeTags.REDIRECTABLE_PROJECTILE)
                .setReplace(true);
    }
}

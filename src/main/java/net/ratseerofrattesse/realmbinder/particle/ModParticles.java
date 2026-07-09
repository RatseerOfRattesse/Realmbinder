package net.ratseerofrattesse.realmbinder.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.ratseerofrattesse.realmbinder.Realmbinder;

public class ModParticles {

    public static void initialize() {
        Realmbinder.LOGGER.info("Registering {} particles", Realmbinder.MOD_ID);
    }

    /* PARTICLE TO POTENTIA THRESHOLDS
     * LORUHN = material, 0-20
     * LORAHN = material, 20-200
     * LODAHR = lower entity, 200-2000
     * TORAHN = middle entity, 2000-10000
     * LOVERUHKT = higher entity, 10000-20000
     * VOID = 20000+ wtf were you able to find on the mortal plane to show this shit
     */

    public static final SimpleParticleType LORUHN_PARTICLE = register("loruhn_particle", FabricParticleTypes.simple());
    public static final SimpleParticleType LORAHN_PARTICLE = register("lorahn_particle", FabricParticleTypes.simple());
    public static final SimpleParticleType LODAHR_PARTICLE = register("lodahr_particle", FabricParticleTypes.simple());
    public static final SimpleParticleType TORAHN_PARTICLE = register("torahn_particle", FabricParticleTypes.simple());
    public static final SimpleParticleType LOVERUHKT_PARTICLE = register("loveruhkt_particle", FabricParticleTypes.simple());
    public static final SimpleParticleType VOID_PARTICLE = register("void_particle", FabricParticleTypes.simple());


    public static SimpleParticleType register(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, name), particleType);
    }
}

package net.ratseerofrattesse.realmbinder.client.particle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.EndRodParticle;
import net.ratseerofrattesse.realmbinder.Realmbinder;
import net.ratseerofrattesse.realmbinder.particle.ModParticles;

public class ModParticleProviders {
    public static void initialize() {
        Realmbinder.LOGGER.info("Registering {} particle providers", Realmbinder.MOD_ID);

        ParticleProviderRegistry.getInstance().register(ModParticles.LORUHN_PARTICLE, EndRodParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.LORAHN_PARTICLE, EndRodParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.LODAHR_PARTICLE, EndRodParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.TORAHN_PARTICLE, EndRodParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.LOVERUHKT_PARTICLE, EndRodParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.VOID_PARTICLE, EndRodParticle.Provider::new);
    }
}

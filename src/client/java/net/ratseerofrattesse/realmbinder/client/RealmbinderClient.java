package net.ratseerofrattesse.realmbinder.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.color.item.ItemTintSources;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.resources.Identifier;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.ratseerofrattesse.realmbinder.Realmbinder;
import net.ratseerofrattesse.realmbinder.client.particle.ModParticleProviders;
import net.ratseerofrattesse.realmbinder.client.rendering.HudRenderingEntrypoint;
import net.ratseerofrattesse.realmbinder.component.ConditionalTooltipComponent;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class RealmbinderClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		HudRenderingEntrypoint.initialize();
		ModParticleProviders.initialize();

		ItemTintSources.ID_MAPPER.put(Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "vanilla_colour"), VanillaColourTintSource.MAP_CODEC);
		//Conditional Tooltip Detection
		ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
			if (client.player != null) {
				if (screen instanceof AbstractContainerScreen<?> abstractContainerScreen) {
					ScreenEvents.afterExtract(screen).register((screen1, graphics, mouseX, mouseY, tickProgress) -> {
						int guiMouseX = (mouseX - ((scaledWidth - abstractContainerScreen.width)/2));
						int guiMouseY = (mouseY - ((scaledHeight - abstractContainerScreen.height)/2));
						if (abstractContainerScreen.getHoveredSlot(guiMouseX, guiMouseY) !=null) {
							Slot slot = abstractContainerScreen.getHoveredSlot(guiMouseX, guiMouseY);
							if (slot.getItem() != null) {
								ItemStack hoveredItem = slot.getItem();
								if(hoveredItem.get(ModComponents.CONDITIONAL_TOOLTIP) != null) {
									if (InputConstants.isKeyDown(client.getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
										hoveredItem.set(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(Objects.requireNonNull(hoveredItem.get(ModComponents.CONDITIONAL_TOOLTIP)).lines(), Objects.requireNonNull(hoveredItem.get(ModComponents.CONDITIONAL_TOOLTIP)).modid(), "shift:true"));
									} else {
										hoveredItem.set(ModComponents.CONDITIONAL_TOOLTIP, new ConditionalTooltipComponent(Objects.requireNonNull(hoveredItem.get(ModComponents.CONDITIONAL_TOOLTIP)).lines(), Objects.requireNonNull(hoveredItem.get(ModComponents.CONDITIONAL_TOOLTIP)).modid(), "shift:false"));
									}
								}
							}
						}
					});
				}
			}
		});
	}
}
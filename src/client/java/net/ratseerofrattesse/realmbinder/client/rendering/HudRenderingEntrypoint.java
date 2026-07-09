package net.ratseerofrattesse.realmbinder.client.rendering;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.impl.resource.client.PackTooltipComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.*;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.Position;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.ratseerofrattesse.realmbinder.Realmbinder;
import net.ratseerofrattesse.realmbinder.component.ModComponents;
import net.ratseerofrattesse.realmbinder.component.PotentiaComponent;
import net.ratseerofrattesse.realmbinder.entity.attribute.ModAttributes;
import net.ratseerofrattesse.realmbinder.item.ModItems;
import net.ratseerofrattesse.realmbinder.item.lens.PotentiaGetter;
import net.ratseerofrattesse.realmbinder.particle.ModParticles;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HudRenderingEntrypoint{
    public static void initialize() {
        HudElementRegistry.addLast(Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "potentia"), (context, tickCounter) -> {
            Minecraft client = Minecraft.getInstance();
            if (client.player != null) {

                ItemStack mainHandStack = client.player.getMainHandItem();
                ItemStack offHandStack = client.player.getOffhandItem();

                if (mainHandStack.is(ModItems.PRECISE_RUNECARVER_LENS) || offHandStack.is(ModItems.PRECISE_RUNECARVER_LENS)) {

                    PotentiaGetter potentiaResult = getTargetPotentia(client.player, client.level, (Objects.requireNonNull(client.player.getAttribute(Attributes.BLOCK_INTERACTION_RANGE)).getValue()));

                    if (!((potentiaResult) == null)) {

                        double potentia;
                        double capacity;

                        if (potentiaResult.potentiaComponent() == null && potentiaResult.entityPotentia() == null) {
                            potentia = 0;
                            capacity = 0;
                        } else if (potentiaResult.entityPotentia() != null) {
                            potentia = potentiaResult.entityPotentia();
                            capacity = potentiaResult.entityCapacity();
                        } else {
                            potentia = potentiaResult.potentiaComponent().potentia();
                            capacity = potentiaResult.potentiaComponent().capacity();
                        }

                        Component title = Component.translatable("tooltip.realmbinder.potentia.info").withStyle(ChatFormatting.GOLD);

                        List<FormattedText> formattedLines = List.of(
                                FormattedText.of(String.valueOf(potentia), Style.EMPTY.withColor(ChatFormatting.LIGHT_PURPLE).withBold(true)),
                                FormattedText.of("/", Style.EMPTY.withColor(ChatFormatting.GRAY)),
                                FormattedText.of(String.valueOf(capacity), Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE)));

                        List<FormattedCharSequence> description = Language.getInstance().getVisualOrder(formattedLines);

                        List<ClientTooltipComponent> components = List.of(ClientTooltipComponent.create(new PackTooltipComponent(Optional.of(title), Optional.of(description))));

                        int screenWidth = client.getWindow().getGuiScaledWidth();
                        int screenHeight = client.getWindow().getGuiScaledHeight();

                        context.tooltip(client.font, components, screenWidth/2, screenHeight/2, DefaultTooltipPositioner.INSTANCE, null);
                    }
                } else if (mainHandStack.is(ModItems.RUNECARVER_LENS) || offHandStack.is(ModItems.PRECISE_RUNECARVER_LENS)) {

                    PotentiaGetter potentiaResult = getTargetPotentia(client.player, client.level, (Objects.requireNonNull(client.player.getAttribute(Attributes.BLOCK_INTERACTION_RANGE)).getValue()));

                    if (!((potentiaResult) == null)) {

                        double potentia;
                        Level level = client.level;

                        if (potentiaResult.potentiaComponent() == null && potentiaResult.entityPotentia() == null) {
                            potentia = 0;
                        } else if (potentiaResult.entityPotentia() != null) {
                            potentia = potentiaResult.entityPotentia();
                        } else {
                            potentia = potentiaResult.potentiaComponent().potentia();
                        }

                        if (level != null) {
                            double x = (Math.random() * (((potentiaResult.position().x()-0.4) - (potentiaResult.position().x()-0.4)) + 1)) + (potentiaResult.position().x()-0.5);
                            double y = (Math.random() * (((potentiaResult.position().y()-0.4) - (potentiaResult.position().y()-0.4)) + 1)) + (potentiaResult.position().y()-0.5);
                            double z = (Math.random() * (((potentiaResult.position().z()-0.4) - (potentiaResult.position().z()-0.4)) + 1)) + (potentiaResult.position().z()-0.5);

                            if (potentia < 20) {
                                level.addParticle(ModParticles.LORUHN_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
                            } else if (potentia < 200) {
                                level.addParticle(ModParticles.LORAHN_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
                            } else if (potentia < 2000) {
                                level.addParticle(ModParticles.LODAHR_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
                            } else if (potentia < 10000) {
                                level.addParticle(ModParticles.TORAHN_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
                            } else if (potentia < 20000) {
                                level.addParticle(ModParticles.LOVERUHKT_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
                            } else if (potentia > 20000) {
                                level.addParticle(ModParticles.VOID_PARTICLE, x, y, z, 0.0, 0.0, 0.0);
                            }
                        }
                    }
                }
            }
        });

        //in inventory tooltips
        ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof AbstractContainerScreen<?> abstractContainerScreen) {
                ScreenEvents.afterExtract(screen).register((screen1, graphics, mouseX, mouseY, tickProgress) -> {
                    Player player = client.player;
                    assert player != null;

                    if (player.gameMode() != null) {
                        if ( player.gameMode() == GameType.CREATIVE) {
                            CreativeModeInventoryScreen inventoryScreen = (CreativeModeInventoryScreen) abstractContainerScreen;
                            potentiaTooltip(inventoryScreen, mouseX, mouseY, scaledWidth, scaledHeight, graphics, client);
                        } else {
                            InventoryScreen inventoryScreen = (InventoryScreen) abstractContainerScreen;
                            potentiaTooltip(inventoryScreen, mouseX, mouseY, scaledWidth, scaledHeight, graphics, client);
                        }
                    }
                });
            }
        });
    }


    public static void potentiaTooltip(AbstractContainerScreen<?> inventoryScreen, int mouseX, int mouseY, int scaledWidth, int scaledHeight, GuiGraphicsExtractor graphics, Minecraft client) {
        ItemStack heldStack = inventoryScreen.getMenu().getCarried();

        int guiMouseX = (mouseX - ((scaledWidth - inventoryScreen.width)/2));
        int guiMouseY = (mouseY - ((scaledHeight - inventoryScreen.height)/2));

        if (heldStack.is(ModItems.PRECISE_RUNECARVER_LENS)) {
            if (inventoryScreen.getHoveredSlot(guiMouseX, guiMouseY) !=null) {
                Slot slot = inventoryScreen.getHoveredSlot(guiMouseX, guiMouseY);
                if (slot.getItem() != null) {
                    ItemStack hoveredItem = slot.getItem();
                    if(hoveredItem.get(ModComponents.POTENTIA) != null) {
                        PotentiaComponent potentiaComponent = hoveredItem.get(ModComponents.POTENTIA);

                        assert potentiaComponent != null;
                        int potentia = potentiaComponent.potentia();
                        int capacity = potentiaComponent.capacity();

                        Component title = Component.translatable("tooltip.realmbinder.potentia.info").withStyle(ChatFormatting.GOLD);

                        List<FormattedText> formattedLines = List.of(
                                FormattedText.of(String.valueOf(potentia), Style.EMPTY.withColor(ChatFormatting.LIGHT_PURPLE).withBold(true)),
                                FormattedText.of("/", Style.EMPTY.withColor(ChatFormatting.GRAY)),
                                FormattedText.of(String.valueOf(capacity), Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE)));

                        List<FormattedCharSequence> description = Language.getInstance().getVisualOrder(formattedLines);

                        List<ClientTooltipComponent> components = List.of(ClientTooltipComponent.create(new PackTooltipComponent(Optional.of(title), Optional.of(description))));

                        graphics.tooltip(client.font, components, guiMouseX, guiMouseY, DefaultTooltipPositioner.INSTANCE, null);
                    }
                }
            }
        } else if (heldStack.is(ModItems.RUNECARVER_LENS)) {
            if (inventoryScreen.getHoveredSlot(guiMouseX, guiMouseY) !=null) {
                Slot slot = inventoryScreen.getHoveredSlot(guiMouseX, guiMouseY);
                if (slot.getItem() != null) {
                    ItemStack hoveredItem = slot.getItem();
                    if(hoveredItem.get(ModComponents.POTENTIA) != null) {
                        PotentiaComponent potentiaComponent = hoveredItem.get(ModComponents.POTENTIA);
                        /*
                        DeltaTracker tickCounter = DeltaTracker.Timer.ZERO;
                        float totalTickProgress = 0;
                        totalTickProgress += tickCounter.getGameTimeDeltaPartialTick(true);
                        float v = 0;
                        float epsilon = 0.000001f;

                        if (Math.abs(totalTickProgress % 16) < epsilon) {
                            v++;
                        }

                         */

                        assert potentiaComponent != null;
                        int potentia = potentiaComponent.potentia();

                        if (potentia < 20) {
                            /*
                            SpriteId spriteId = new SpriteId(
                                    AtlasIds.GUI,
                                    Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/gui/sprites/loruhn_particle.png")
                                    //TODO how tf do animated sprites work
                            );
                            texture = spriteId.texture();
                             */
                            Identifier texture = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/particle/loruhn_particle/frame0001.png");
                            graphics.blit(RenderPipelines.GUI_TEXTURED, texture, guiMouseX, guiMouseY, 0, 0, 16, 16, 16, 16);
                        } else if (potentia < 200) {
                            Identifier texture = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/particle/lorahn_particle/frame0001.png");
                            graphics.blit(RenderPipelines.GUI_TEXTURED, texture, guiMouseX, guiMouseY, 0, 0, 16, 16, 16, 16);
                        } else if (potentia < 2000) {
                            Identifier texture = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/particle/lodahr_particle/frame0001.png");
                            graphics.blit(RenderPipelines.GUI_TEXTURED, texture, guiMouseX, guiMouseY, 0, 0, 16, 16, 16, 16);
                        } else if (potentia < 10000) {
                            Identifier texture = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/particle/torahn_particle/frame0001.png");
                            graphics.blit(RenderPipelines.GUI_TEXTURED, texture, guiMouseX, guiMouseY, 0, 0, 16, 16, 16, 16);
                        } else if (potentia < 20000) {
                            Identifier texture = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/particle/loveruhkt_particle/frame0001.png");
                            graphics.blit(RenderPipelines.GUI_TEXTURED, texture, guiMouseX, guiMouseY, 0, 0, 16, 16, 16, 16);
                        } else if (potentia > 20000) {
                            Identifier texture = Identifier.fromNamespaceAndPath(Realmbinder.MOD_ID, "textures/particle/void_particle/frame0001.png");
                            graphics.blit(RenderPipelines.GUI_TEXTURED, texture, guiMouseX, guiMouseY, 0, 0, 16, 16, 16, 16);
                        }
                    }
                }
            }
        }
    }



    public static PotentiaGetter getTargetPotentia(Player player, Level level, double reachDistance) {
        assert player != null;
        Minecraft client =  Minecraft.getInstance();
        HitResult hitResult = player.pick(reachDistance, 1.0F, false);
        Entity targetedEntity = client.crosshairPickEntity;

        if(hitResult != null || targetedEntity !=null) {
            if (targetedEntity instanceof LivingEntity) {
                LivingEntity livingEntity = targetedEntity.asLivingEntity();
                assert livingEntity != null;
                double entityPotentia = livingEntity.getAttributeValue(ModAttributes.POTENTIA);
                double entityCapacity = livingEntity.getAttributeValue(ModAttributes.CAPACITY);
                Position entityPosition = livingEntity.position();
                return new PotentiaGetter(null, entityPotentia, entityCapacity, entityPosition);
            } else {
                BlockHitResult blockHitResult = (BlockHitResult) hitResult;
                Position blockPosition = blockHitResult.getBlockPos().getCenter();
                Block block = level.getBlockState(blockHitResult.getBlockPos()).getBlock();
                if (block != Blocks.AIR || block != Blocks.CAVE_AIR || block != Blocks.VOID_AIR || block != Blocks.WATER || block != Blocks.LAVA) {
                    PotentiaComponent blockPotentia = block.asItem().getDefaultInstance().get(ModComponents.POTENTIA);
                    return new PotentiaGetter(blockPotentia, null, null, blockPosition);
                }
            }
        }

        return new PotentiaGetter(null, null, null, null);
    }
}

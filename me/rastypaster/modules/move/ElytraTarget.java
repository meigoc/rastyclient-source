// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import me.rastypaster.utill.elytra.InventoryUtil;
import java.util.Iterator;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.Minecraft;
import io.netty.util.ResourceLeakDetector;
import me.rastypaster.utill.elytra.events.impl.player.EventUpdate;
import java.util.HashSet;
import net.minecraft.entity.player.PlayerEntity;
import java.util.Set;
import me.rastypaster.Module;

public class ElytraTarget extends Module
{
    public Set<PlayerEntity> targetedPlayers;
    public boolean isTargeting;
    public long lastFireworkTime;
    public long fireworkCooldown;
    public long lastChatMessageTime;
    public long chatMessageInterval;
    
    public ElytraTarget() {
        this.targetedPlayers = new HashSet<PlayerEntity>();
        this.isTargeting = false;
        this.lastFireworkTime = 0L;
        this.fireworkCooldown = 750L;
        this.lastChatMessageTime = 0L;
        this.chatMessageInterval = 5000L;
        this.name = "ElytraTarget";
    }
    
    public void onUpdate(final EventUpdate eventUpdate) {
        if (ResourceLeakDetector.isEnabled() && !this.isTargeting) {
            if (Minecraft.getInstance().player.isElytraFlying()) {
                this.targetPlayer();
            }
        }
        else if (ResourceLeakDetector.isEnabled() && this.isTargeting) {
            if (Minecraft.getInstance().player.isElytraFlying()) {
                this.updateRotationToPlayer();
                this.useFirework();
                this.checkChatMessage();
            }
            else {
                this.stopTargeting();
            }
        }
        else if (!ResourceLeakDetector.isEnabled() && this.isTargeting) {
            this.stopTargeting();
        }
    }
    
    public void targetPlayer() {
        final ClientWorld world = Minecraft.getInstance().world;
        if (world != null) {
            for (final Entity entity : world.getEntitiesWithinAABBExcludingEntity(Minecraft.getInstance().player, new AxisAlignedBB(Minecraft.getInstance().player.getPosX() - 10.0, Minecraft.getInstance().player.getPosY() - 5.0, Minecraft.getInstance().player.getPosZ() - 10.0, Minecraft.getInstance().player.getPosX() + 10.0, Minecraft.getInstance().player.getPosY() + 5.0, Minecraft.getInstance().player.getPosZ() + 10.0))) {
                if (entity instanceof PlayerEntity && entity.isAlive()) {
                    final PlayerEntity rotationToPlayer = (PlayerEntity)entity;
                    if (!this.targetedPlayers.contains(rotationToPlayer)) {
                        this.targetedPlayers.clear();
                        this.targetedPlayers.add(rotationToPlayer);
                        this.isTargeting = true;
                        this.setRotationToPlayer(rotationToPlayer);
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    public void setRotationToPlayer(final PlayerEntity playerEntity) {
        if (playerEntity != null) {
            final double n = playerEntity.getPosX() - Minecraft.getInstance().player.getPosX();
            final double n2 = playerEntity.getPosZ() - Minecraft.getInstance().player.getPosZ();
            final double n3 = playerEntity.getPosY() - Minecraft.getInstance().player.getPosY();
            final double n4 = Math.toDegrees(Math.atan2(n2, n)) - 90.0;
            final double n5 = -Math.toDegrees(Math.atan2(n3, Math.sqrt(n * n + n2 * n2)));
            Minecraft.getInstance().player.rotationYaw = (float)n4;
            Minecraft.getInstance().player.rotationPitch = (float)n5;
        }
    }
    
    public void updateRotationToPlayer() {
        if (!this.targetedPlayers.isEmpty()) {
            this.setRotationToPlayer(this.targetedPlayers.iterator().next());
        }
    }
    
    public void useFirework() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastFireworkTime >= this.fireworkCooldown) {
            final int fireWorks = InventoryUtil.getFireWorks();
            if (fireWorks == -1) {
                return;
            }
            final int currentItem = Minecraft.getInstance().player.inventory.currentItem;
            Minecraft.getInstance().player.connection.sendPacket(new CHeldItemChangePacket(fireWorks));
            Minecraft.getInstance().player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
            Minecraft.getInstance().player.connection.sendPacket(new CHeldItemChangePacket(currentItem));
            this.lastFireworkTime = currentTimeMillis;
            if (Minecraft.getInstance().player.getDistance(this.targetedPlayers.iterator().next()) > 30.0) {
                this.fireworkCooldown = 500L;
            }
            else {
                this.fireworkCooldown = 750L;
            }
        }
    }
    
    public void stopTargeting() {
        this.targetedPlayers.clear();
        this.isTargeting = false;
    }
    
    public void checkChatMessage() {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastChatMessageTime >= this.chatMessageInterval) {
            if (!this.targetedPlayers.isEmpty()) {
                final PlayerEntity playerEntity = this.targetedPlayers.iterator().next();
            }
            this.lastChatMessageTime = currentTimeMillis;
        }
    }
    
    public PlayerEntity[] getTargetedPlayers() {
        return this.targetedPlayers.toArray(new PlayerEntity[0]);
    }
}

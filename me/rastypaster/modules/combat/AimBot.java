// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import net.minecraft.entity.player.PlayerEntity;
import me.rastypaster.Module;

public class AimBot extends Module
{
    public AimBot() {
        this.name = "AimBot";
    }
    
    @Override
    public void onUpdate() {
        final PlayerEntity playerEntity = AimBot.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)AimBot::lambda$onUpdate$0).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)AimBot::lambda$onUpdate$1)).filter((Predicate<? super PlayerEntity>)AimBot::lambda$onUpdate$2).orElse(null);
        if (this.isEnable && AimBot.mc.player != null && playerEntity != null && AimBot.mc.player.canEntityBeSeen(playerEntity)) {
            AimBot.mc.player.rotationYaw = this.rotations(playerEntity)[0];
            AimBot.mc.player.rotationPitch = this.rotations(playerEntity)[1];
        }
    }
    
    public float[] rotations(final PlayerEntity playerEntity) {
        final double n = playerEntity.getPosX() - AimBot.mc.player.getPosX();
        final double n2 = playerEntity.getPosY() - (AimBot.mc.player.getPosY() + AimBot.mc.player.getEyeHeight()) + 1.5;
        final double n3 = playerEntity.getPosZ() - AimBot.mc.player.getPosZ();
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0), (float)(-MathHelper.atan2(n2, MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".AimBot")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                AimBot.mc.player.addChatMessage("AimBot on");
            }
            else {
                AimBot.mc.player.addChatMessage("AimBot off");
            }
        }
    }
    
    public static boolean lambda$onUpdate$2(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(AimBot.mc.player) <= 5.0f;
    }
    
    public static Float lambda$onUpdate$1(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(AimBot.mc.player);
    }
    
    public static boolean lambda$onUpdate$0(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != AimBot.mc.player;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.entity.Entity;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.item.Items;
import java.util.Iterator;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import me.rastypaster.commands.Friend;
import me.rastypaster.Manager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.PlayerEntity;
import me.rastypaster.Module;

public class RageBow extends Module
{
    public boolean gogo;
    public static float fd;
    public PlayerEntity target;
    
    public RageBow() {
        this.name = "RageBow";
    }
    
    public void trigger() {
        if (this.target != null) {
            RageBow.mc.player.rotationYaw = this.rotations(this.target)[0];
            RageBow.mc.player.rotationPitch = this.rotations(this.target)[1];
        }
    }
    
    public float[] rotations(final PlayerEntity playerEntity) {
        final double n = playerEntity.getPosX() - RageBow.mc.player.getPosX();
        final double n2 = playerEntity.getPosY() - (RageBow.mc.player.getPosY() + RageBow.mc.player.getEyeHeight()) + 1.5;
        final double n3 = playerEntity.getPosZ() - RageBow.mc.player.getPosZ();
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0), (float)(-MathHelper.atan2(n2, MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    public boolean canAttack(final PlayerEntity playerEntity) {
        int n = 0;
        final Iterator<Friend> iterator = Manager.friendmanag.getMyfriends().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(this.target.getScoreboardName())) {
                n = 1;
            }
        }
        if (n == 1) {
            this.target = RageBow.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)RageBow::lambda$canAttack$0).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)RageBow::lambda$canAttack$1)).filter((Predicate<? super PlayerEntity>)RageBow::lambda$canAttack$2).orElse(null);
            return true;
        }
        return false;
    }
    
    @Override
    public void onUpdate() {
        this.target = RageBow.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)RageBow::lambda$onUpdate$3).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)RageBow::lambda$onUpdate$4)).filter((Predicate<? super PlayerEntity>)RageBow::lambda$onUpdate$5).orElse(null);
        if (this.isEnable && this.target != null && this.canAttack(this.target)) {
            if (RageBow.mc.player != null && RageBow.mc.player.getHeldItemOffhand().getItem() == Items.BOW) {
                RageBow.mc.gameSettings.keyBindUseItem.setPressed(false);
                if (RageBow.mc.player.ticksExisted % 16 == 0) {
                    this.trigger();
                }
                if (RageBow.mc.player.ticksExisted % 17 == 0) {
                    this.trigger();
                }
                if (RageBow.mc.player.ticksExisted % 18 == 0) {
                    this.trigger();
                    RageBow.mc.gameSettings.keyBindUseItem.setPressed(true);
                }
            }
            if (RageBow.mc.player.getHeldItemMainhand().getItem() == Items.BOW) {
                RageBow.mc.gameSettings.keyBindUseItem.setPressed(false);
                if (RageBow.mc.player.ticksExisted % 16 == 0) {
                    this.trigger();
                }
                if (RageBow.mc.player.ticksExisted % 17 == 0) {
                    this.trigger();
                }
                if (RageBow.mc.player.ticksExisted % 18 == 0) {
                    this.trigger();
                    RageBow.mc.gameSettings.keyBindUseItem.setPressed(true);
                }
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".fastbow")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                RageBow.mc.player.addChatMessage("FastBow on");
            }
            else {
                RageBow.mc.player.addChatMessage("FastBow off");
            }
        }
    }
    
    public static boolean lambda$onUpdate$5(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(RageBow.mc.player) <= 25.0;
    }
    
    public static Float lambda$onUpdate$4(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(RageBow.mc.player);
    }
    
    public static boolean lambda$onUpdate$3(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != RageBow.mc.player;
    }
    
    public static boolean lambda$canAttack$2(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(RageBow.mc.player) <= 50.0f;
    }
    
    public static Float lambda$canAttack$1(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(RageBow.mc.player);
    }
    
    public static boolean lambda$canAttack$0(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != RageBow.mc.player;
    }
}

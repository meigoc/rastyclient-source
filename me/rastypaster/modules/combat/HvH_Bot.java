// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import java.util.Iterator;
import me.rastypaster.commands.Friend;
import me.rastypaster.Manager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import net.minecraft.potion.Effect;
import net.minecraft.item.ThrowablePotionItem;
import net.minecraft.entity.Entity;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import net.minecraft.entity.player.PlayerEntity;
import me.rastypaster.Module;

public class HvH_Bot extends Module
{
    public PlayerEntity target;
    
    public HvH_Bot() {
        this.name = "AutoFighter";
    }
    
    @Override
    public void onUpdate() {
        this.target = HvH_Bot.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)HvH_Bot::lambda$onUpdate$0).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)HvH_Bot::lambda$onUpdate$1)).filter((Predicate<? super PlayerEntity>)HvH_Bot::lambda$onUpdate$2).orElse(null);
        if (this.isEnable) {
            if (this.target == null) {
                return;
            }
            if (HvH_Bot.mc.player != null && this.target != null) {
                if (this.canAttack(this.target)) {
                    if (this.target.getDistance(HvH_Bot.mc.player) < 8.0f) {
                        if (HvH_Bot.mc.player.ticksExisted % 2 == 0) {
                            HvH_Bot.mc.gameSettings.keyBindJump.setPressed(false);
                        }
                        HvH_Bot.mc.gameSettings.keyBindForward.setPressed(false);
                    }
                    else if (this.target.getDistance(HvH_Bot.mc.player) > 6.0f) {
                        HvH_Bot.mc.gameSettings.keyBindJump.setPressed(true);
                        HvH_Bot.mc.player.rotationYaw = this.rotations(this.target)[0];
                        HvH_Bot.mc.player.rotationPitch = this.rotations(this.target)[1];
                        HvH_Bot.mc.gameSettings.keyBindForward.setPressed(false);
                    }
                    for (int i = 0; i < 9; i += 6866, i -= 6865) {
                        if (HvH_Bot.mc.player.inventory.getStackInSlot(i).getItem() instanceof ThrowablePotionItem && !HvH_Bot.mc.player.isPotionActive(Effect.get(1))) {
                            HvH_Bot.mc.player.rotationPitch = 90.0f;
                            HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(i));
                            HvH_Bot.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                            HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(HvH_Bot.mc.player.inventory.currentItem));
                        }
                    }
                    for (int j = 0; j < 9; j += 12844, j -= 12843) {
                        if (HvH_Bot.mc.player.inventory.getStackInSlot(j).getItem() instanceof ThrowablePotionItem && !HvH_Bot.mc.player.isPotionActive(Effect.get(12))) {
                            HvH_Bot.mc.player.rotationPitch = 90.0f;
                            HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(j));
                            HvH_Bot.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                            HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(HvH_Bot.mc.player.inventory.currentItem));
                        }
                    }
                    for (int k = 0; k < 9; k -= 27785, k += 27786) {
                        if (HvH_Bot.mc.player.inventory.getStackInSlot(k).getItem() instanceof ThrowablePotionItem && !HvH_Bot.mc.player.isPotionActive(Effect.get(5))) {
                            HvH_Bot.mc.player.rotationPitch = 90.0f;
                            HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(k));
                            HvH_Bot.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                            HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(HvH_Bot.mc.player.inventory.currentItem));
                        }
                    }
                    if (this.target.getDistance(HvH_Bot.mc.player) > 16.0f) {
                        for (int l = 0; l < 9; l += 17035, l -= 17034) {
                            if (HvH_Bot.mc.player.inventory.getStackInSlot(l).getItem() instanceof EnderPearlItem && HvH_Bot.mc.player.ticksExisted % 25 == 0) {
                                if (this.target.getDistance(HvH_Bot.mc.player) > 16.0f) {
                                    HvH_Bot.mc.player.rotationPitch = -20.0f;
                                }
                                if (this.target.getDistance(HvH_Bot.mc.player) > 25.0f) {
                                    HvH_Bot.mc.player.rotationPitch = -30.0f;
                                }
                                HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(l));
                                HvH_Bot.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                                HvH_Bot.mc.player.connection.sendPacket(new CHeldItemChangePacket(HvH_Bot.mc.player.inventory.currentItem));
                            }
                        }
                    }
                }
                if (HvH_Bot.mc.player.isInWater()) {
                    HvH_Bot.mc.gameSettings.keyBindJump.setPressed(true);
                }
            }
        }
    }
    
    public float[] rotations(final PlayerEntity playerEntity) {
        final double n = playerEntity.getPosX() - HvH_Bot.mc.player.getPosX();
        final double n2 = playerEntity.getPosY() - (HvH_Bot.mc.player.getPosY() + HvH_Bot.mc.player.getEyeHeight()) + 1.5;
        final double n3 = playerEntity.getPosZ() - HvH_Bot.mc.player.getPosZ();
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
            this.target = HvH_Bot.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)HvH_Bot::lambda$canAttack$3).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)HvH_Bot::lambda$canAttack$4)).filter((Predicate<? super PlayerEntity>)HvH_Bot::lambda$canAttack$5).orElse(null);
            return true;
        }
        return false;
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".AutoFighter")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                HvH_Bot.mc.player.addChatMessage("Fighter on");
            }
            else {
                HvH_Bot.mc.player.addChatMessage("Fighter off");
            }
        }
    }
    
    public static boolean lambda$canAttack$5(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(HvH_Bot.mc.player) <= 50.0f;
    }
    
    public static Float lambda$canAttack$4(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(HvH_Bot.mc.player);
    }
    
    public static boolean lambda$canAttack$3(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != HvH_Bot.mc.player;
    }
    
    public static boolean lambda$onUpdate$2(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(HvH_Bot.mc.player) <= 50.0;
    }
    
    public static Float lambda$onUpdate$1(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(HvH_Bot.mc.player);
    }
    
    public static boolean lambda$onUpdate$0(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != HvH_Bot.mc.player;
    }
}

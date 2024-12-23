// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import me.rastypaster.commands.Friend;
import me.rastypaster.Manager;
import net.minecraft.entity.player.PlayerEntity;
import me.rastypaster.Module;

public class Aura extends Module
{
    public static float fd;
    public static PlayerEntity target;
    public static boolean chich;
    public static boolean duel;
    public static int hih;
    
    public static boolean canAttack(final PlayerEntity playerEntity) {
        int n = 0;
        final Iterator<Friend> iterator = Manager.friendmanag.getMyfriends().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(Aura.target.getScoreboardName())) {
                n = 1;
            }
        }
        if (n == 1) {
            Aura.target = Aura.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)Aura::lambda$canAttack$0).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)Aura::lambda$canAttack$1)).filter((Predicate<? super PlayerEntity>)Aura::lambda$canAttack$2).orElse(null);
            return true;
        }
        return false;
    }
    
    public Aura() {
        this.name = "Aura";
    }
    
    @Override
    public void onUpdate() {
        Aura.target = Aura.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)Aura::lambda$onUpdate$3).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)Aura::lambda$onUpdate$4)).filter((Predicate<? super PlayerEntity>)Aura::lambda$onUpdate$5).orElse(null);
        if (this.isEnable && Aura.target != null && canAttack(Aura.target) && Aura.mc.player != null && !Aura.target.isElytraFlying()) {
            if (Aura.target.getPosY() <= Aura.mc.player.getPosY() + 1.5) {
                if (!Aura.target.getShouldBeDead()) {
                    switch (Aura.hih) {
                        case 1: {
                            Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                            break;
                        }
                        case 2: {
                            if (Aura.mc.player.fallDistance < 0.1) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 16.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.11) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 18.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.12) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 20.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.13) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 22.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.14) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 24.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.15) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 26.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.16) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 28.0f;
                            }
                            if (Aura.mc.player.fallDistance == 0.17) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 30.0f;
                            }
                            if (Aura.mc.player.fallDistance > 0.2) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                Aura.mc.player.rotationPitch = 34.0f;
                                break;
                            }
                            break;
                        }
                        case 3: {
                            if (Aura.mc.player.fallDistance > 0.11) {
                                Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                                break;
                            }
                            break;
                        }
                        case 4: {
                            Aura.mc.player.rotationYaw = rotations(Aura.target)[0];
                            if (Aura.target.getPosX() - Aura.mc.player.getPosX() > 0.10000000149011612 || Aura.target.getPosZ() - Aura.mc.player.getPosZ() < 0.10000000149011612) {
                                Aura.mc.player.rotationPitch = 54.0f;
                            }
                            if (Aura.target.getPosX() - Aura.mc.player.getPosX() > 0.10000000149011612 || Aura.target.getPosZ() - Aura.mc.player.getPosZ() > 0.10000000149011612) {
                                Aura.mc.player.rotationPitch = 45.0f;
                            }
                            if (Aura.target.getPosX() - Aura.mc.player.getPosX() > 0.5 || Aura.target.getPosZ() - Aura.mc.player.getPosZ() > 0.5) {
                                Aura.mc.player.rotationPitch = 28.0f;
                            }
                            if (Aura.target.getPosX() - Aura.mc.player.getPosX() > 1.0 || Aura.target.getPosZ() - Aura.mc.player.getPosZ() > 1.0) {
                                Aura.mc.player.rotationPitch = 24.0f;
                            }
                            if (Aura.target.getPosX() - Aura.mc.player.getPosX() > 1.5 || Aura.target.getPosZ() - Aura.mc.player.getPosZ() > 1.5) {
                                Aura.mc.player.rotationPitch = 25.0f;
                            }
                            if (Aura.target.getPosX() - Aura.mc.player.getPosX() > 2.0 || Aura.target.getPosZ() - Aura.mc.player.getPosZ() > 2.0) {
                                Aura.mc.player.rotationPitch = 15.0f;
                                break;
                            }
                            break;
                        }
                        case 5: {}
                        case 6: {}
                        case 8: {
                            if (Aura.target != null) {
                                final double n = Aura.target.getPosX() - Aura.mc.player.getPosX();
                                final double n2 = Aura.target.getPosY() + Aura.target.getEyeHeight() - Aura.mc.player.getPosY();
                                final double n3 = Aura.target.getPosZ() - Aura.mc.player.getPosZ();
                                final double n4 = MathHelper.sqrt(n * n + n2 * n2 + n3 * n3);
                                final float rotationYaw = (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0);
                                final float rotationPitch = (float)(MathHelper.atan2(n2, n4) * 57.29577951308232);
                                Aura.mc.player.rotationYaw = rotationYaw;
                                Aura.mc.player.rotationPitch = rotationPitch;
                                break;
                            }
                            break;
                        }
                    }
                    if (Aura.mc.player.fallDistance > 0.12 && Aura.mc.player.getCooledAttackStrength(2.0f) == 1.0f) {
                        Aura.mc.playerController.attackEntity(Aura.mc.player, Aura.target);
                        Aura.mc.player.swingArm(Hand.MAIN_HAND);
                        Aura.mc.player.resetCooldown();
                    }
                    if ((Aura.mc.player.isInLava() || Aura.mc.player.isInLava()) && Aura.mc.player.getCooledAttackStrength(2.0f) == 1.0f) {
                        Aura.mc.playerController.attackEntity(Aura.mc.player, Aura.target);
                        Aura.mc.player.swingArm(Hand.MAIN_HAND);
                        Aura.mc.player.resetCooldown();
                    }
                    if (Minecraft.getInstance().world.getBlockState(new BlockPos(Minecraft.getInstance().player.getPosX(), Aura.mc.player.getPosY() + 2.0, Aura.mc.player.getPosZ())).getBlock() != Blocks.AIR && Aura.mc.player.getCooledAttackStrength(2.0f) == 1.0f) {
                        Aura.mc.playerController.attackEntity(Aura.mc.player, Aura.target);
                        Aura.mc.player.swingArm(Hand.MAIN_HAND);
                        Aura.mc.player.resetCooldown();
                        Aura.mc.player.resetCooldown();
                    }
                }
            }
        }
    }
    
    public static float[] rotations(final PlayerEntity playerEntity) {
        final double n = playerEntity.getPosX() - Aura.mc.player.getPosX();
        final double n2 = playerEntity.getPosY() - (Aura.mc.player.getPosX() + Aura.mc.player.getEyeHeight());
        final double n3 = playerEntity.getPosZ() - Aura.mc.player.getPosZ();
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 94.0), (float)(-MathHelper.atan2(n2, MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    public static float randomizeFloat(final float n, final float n2) {
        return (float)(n + (n2 - n) * Math.random());
    }
    
    public static float getFixedRotation(final float n) {
        return getDeltaMouse(n) * getGCDValue();
    }
    
    public static float getDeltaMouse(final float n) {
        return (float)Math.round(n / getGCDValue());
    }
    
    public static float getGCDValue() {
        return (float)(getGCD() * 0.15);
    }
    
    public static float getGCD() {
        final float n;
        return (n = (float)(Aura.mc.gameSettings.mouseSensitivity * 0.6 + 0.2)) * n * n * 8.0f;
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".aura")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Aura.mc.player.addChatMessage("aura on");
            }
            else {
                Aura.mc.player.addChatMessage("aura off");
            }
        }
    }
    
    public static boolean lambda$onUpdate$5(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(Aura.mc.player) <= Aura.fd;
    }
    
    public static Float lambda$onUpdate$4(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(Aura.mc.player);
    }
    
    public static boolean lambda$onUpdate$3(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != Aura.mc.player;
    }
    
    public static boolean lambda$canAttack$2(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(Aura.mc.player) <= Aura.fd;
    }
    
    public static Float lambda$canAttack$1(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(Aura.mc.player);
    }
    
    public static boolean lambda$canAttack$0(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != Aura.mc.player;
    }
    
    static {
        Aura.fd = 3.0f;
        Aura.hih = 1;
    }
}

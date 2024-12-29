// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import me.rastypaster.commands.Friend;
import me.rastypaster.Manager;
import net.minecraft.entity.Entity;
import org.lwjgl.glfw.GLFW;
import net.minecraft.entity.player.PlayerEntity;
import me.rastypaster.Module;

public class BowAim extends Module
{
    public PlayerEntity target;
    public GLFW f;
    
    public BowAim() {
        this.name = "BowAim";
    }
    
    public boolean canAttack(final Entity entity) {
        int n = 0;
        final Iterator<Friend> iterator = Manager.friendmanag.getMyfriends().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(this.target.getScoreboardName())) {
                n = 1;
            }
        }
        if (n == 1) {
            this.target = BowAim.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)BowAim::lambda$canAttack$0).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)BowAim::lambda$canAttack$1)).filter((Predicate<? super PlayerEntity>)BowAim::lambda$canAttack$2).orElse(null);
            return true;
        }
        return false;
    }
    
    public float[] rotations(final PlayerEntity playerEntity) {
        final double n = playerEntity.getPosX() - BowAim.mc.player.getPosX();
        final double n2 = playerEntity.getPosY() - (BowAim.mc.player.getPosY() + BowAim.mc.player.getEyeHeight()) + 1.5;
        final double n3 = playerEntity.getPosZ() - BowAim.mc.player.getPosZ();
        return new float[] { (float)(MathHelper.atan2(n3, n) * 57.29577951308232 - 90.0), (float)(-MathHelper.atan2(n2, MathHelper.sqrt(n * n + n3 * n3)) * 57.29577951308232) };
    }
    
    public void trigger() {
        if (this.canAttack(this.target) && this.target != null && BowAim.mc.player.canEntityBeSeen(this.target)) {
            BowAim.mc.player.rotationYaw = this.rotations(this.target)[0];
            BowAim.mc.player.rotationPitch = this.rotations(this.target)[1];
        }
    }
    
    @Override
    public void onUpdate() {
        if (BowAim.mc.player != null && BowAim.mc.world != null) {
            this.target = BowAim.mc.world.getPlayers().stream().filter((Predicate<? super PlayerEntity>)BowAim::lambda$onUpdate$3).min(Comparator.comparing((Function<? super PlayerEntity, ? extends Comparable>)BowAim::lambda$onUpdate$4)).filter((Predicate<? super PlayerEntity>)BowAim::lambda$onUpdate$5).orElse(null);
            if (BowAim.mc.player.getActiveHand() == Hand.MAIN_HAND) {
                if (BowAim.mc.player.getHeldItemMainhand().getItem() == Items.BOW && BowAim.mc.player.isHandActive()) {
                    this.trigger();
                }
            }
            else if (BowAim.mc.player.getActiveHand() == Hand.OFF_HAND && BowAim.mc.player.getHeldItemOffhand().getItem() == Items.BOW && BowAim.mc.player.isHandActive()) {
                this.trigger();
            }
        }
    }
    
    public static boolean lambda$onUpdate$5(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(BowAim.mc.player) <= 15.0;
    }
    
    public static Float lambda$onUpdate$4(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(BowAim.mc.player);
    }
    
    public static boolean lambda$onUpdate$3(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != BowAim.mc.player;
    }
    
    public static boolean lambda$canAttack$2(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(BowAim.mc.player) <= 5.0;
    }
    
    public static Float lambda$canAttack$1(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity.getDistance(BowAim.mc.player);
    }
    
    public static boolean lambda$canAttack$0(final AbstractClientPlayerEntity abstractClientPlayerEntity) {
        return abstractClientPlayerEntity != BowAim.mc.player;
    }
}

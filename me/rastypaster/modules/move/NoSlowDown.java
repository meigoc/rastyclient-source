// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.MovementInput;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import me.rastypaster.Module;

public class NoSlowDown extends Module
{
    public static int hih;
    
    public NoSlowDown() {
        this.name = "NoSlowDown";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && NoSlowDown.mc.player != null) {
            switch (NoSlowDown.hih) {
                case 1: {
                    if (!NoSlowDown.mc.player.isHandActive()) {
                        break;
                    }
                    final MovementInput movementInput = NoSlowDown.mc.player.movementInput;
                    movementInput.moveStrafe *= 1.2f;
                    final MovementInput movementInput2 = NoSlowDown.mc.player.movementInput;
                    movementInput2.moveForward *= 1.2f;
                    if (NoSlowDown.mc.player.isOnGround()) {
                        final Vector3d motion = NoSlowDown.mc.player.getMotion();
                        motion.x *= 1.4;
                        final Vector3d motion2 = NoSlowDown.mc.player.getMotion();
                        motion2.z *= 1.4;
                        if (NoSlowDown.mc.player.ticksExisted % 2 == 0) {
                            final Vector3d motion3 = NoSlowDown.mc.player.getMotion();
                            motion3.x *= 1.13;
                            final Vector3d motion4 = NoSlowDown.mc.player.getMotion();
                            motion4.z *= 1.13;
                            break;
                        }
                        break;
                    }
                    else {
                        if (NoSlowDown.mc.player.fallDistance > 0.7) {
                            final Vector3d motion5 = NoSlowDown.mc.player.getMotion();
                            motion5.x *= 1.115;
                            final Vector3d motion6 = NoSlowDown.mc.player.getMotion();
                            motion6.z *= 1.115;
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    if (!NoSlowDown.mc.player.isHandActive()) {
                        break;
                    }
                    NoSlowDown.mc.player.setSprinting(false);
                    NoSlowDown.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.OFF_HAND));
                    NoSlowDown.mc.player.speedInAir = 0.24f;
                    final MovementInput movementInput3 = NoSlowDown.mc.player.movementInput;
                    movementInput3.moveStrafe *= 2.3f;
                    final MovementInput movementInput4 = NoSlowDown.mc.player.movementInput;
                    movementInput4.moveForward *= 2.3f;
                    if (NoSlowDown.mc.player.isOnGround()) {
                        final Vector3d motion7 = NoSlowDown.mc.player.getMotion();
                        motion7.x *= 1.52;
                        final Vector3d motion8 = NoSlowDown.mc.player.getMotion();
                        motion8.z *= 1.52;
                    }
                    if (NoSlowDown.mc.player.fallDistance < 0.7) {
                        NoSlowDown.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.OFF_HAND));
                        final Vector3d motion9 = NoSlowDown.mc.player.getMotion();
                        motion9.x *= 1.00075;
                        final Vector3d motion10 = NoSlowDown.mc.player.getMotion();
                        motion10.z *= 1.00075;
                    }
                    if (NoSlowDown.mc.player.fallDistance < 0.3) {
                        NoSlowDown.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.OFF_HAND));
                        final Vector3d motion11 = NoSlowDown.mc.player.getMotion();
                        motion11.x *= 1.00035;
                        final Vector3d motion12 = NoSlowDown.mc.player.getMotion();
                        motion12.z *= 1.00035;
                    }
                    if (NoSlowDown.mc.player.fallDistance > 0.8) {
                        NoSlowDown.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.OFF_HAND));
                        final Vector3d motion13 = NoSlowDown.mc.player.getMotion();
                        motion13.x *= 1.00145;
                        final Vector3d motion14 = NoSlowDown.mc.player.getMotion();
                        motion14.z *= 1.00145;
                    }
                    if (NoSlowDown.mc.player.fallDistance > 0.98) {
                        NoSlowDown.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.OFF_HAND));
                        final Vector3d motion15 = NoSlowDown.mc.player.getMotion();
                        motion15.x *= 1.00025;
                        final Vector3d motion16 = NoSlowDown.mc.player.getMotion();
                        motion16.z *= 1.00025;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".noslow")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                NoSlowDown.mc.player.addChatMessage("Noslowdown on");
            }
            else {
                NoSlowDown.mc.player.addChatMessage("Noslowdown off");
            }
        }
    }
    
    static {
        NoSlowDown.hih = 1;
    }
}

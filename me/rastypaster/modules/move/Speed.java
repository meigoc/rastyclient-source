// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.util.math.vector.Vector3d;
import me.rastypaster.Module;

public class Speed extends Module
{
    public static int f;
    
    public Speed() {
        this.name = "Speed";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && Speed.mc.player != null) {
            switch (Speed.f) {
                case 1: {
                    if (Speed.mc.player.isOnGround()) {
                        Speed.mc.player.jump();
                    }
                    final double n = Speed.mc.player.getMotion().x * 1.0E-4;
                    final double n2 = Speed.mc.player.getMotion().z * 1.0E-4;
                    final Vector3d motion = Speed.mc.player.getMotion();
                    motion.x += n;
                    final Vector3d motion2 = Speed.mc.player.getMotion();
                    motion2.z += n2;
                    if (Speed.mc.player.fallDistance >= 0.07) {
                        break;
                    }
                    Speed.mc.player.getMotion().y += 2.3E-4;
                    if (Speed.mc.player.ticksExisted % 4 == 0) {
                        Speed.mc.player.getMotion().y -= 4.6E-4;
                        break;
                    }
                    break;
                }
                case 2: {}
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".speed")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Speed.mc.player.addChatMessage("Speed on");
            }
            else {
                Speed.mc.player.addChatMessage("Speed off");
            }
        }
    }
    
    static {
        Speed.f = 1;
    }
}

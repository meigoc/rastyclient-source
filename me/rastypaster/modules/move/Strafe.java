// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import me.rastypaster.utill.move.MovementUtill;
import me.rastypaster.Module;

public class Strafe extends Module
{
    public static boolean needSwap;
    
    public Strafe() {
        this.name = "Strafe";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && Strafe.mc.player != null && MovementUtill.isMoving()) {
            if (Strafe.mc.player.rotationYaw == 90.0f) {
                Strafe.mc.player.moveForward = 1.0f;
                Strafe.mc.player.moveStrafing = 1.0f;
                Strafe.mc.player.setSprinting(false);
            }
            else {
                Strafe.mc.player.moveForward = 1.0f;
                Strafe.mc.player.moveStrafing = 1.0f;
                Strafe.mc.player.setSprinting(false);
            }
            Strafe.mc.player.speedInAir = 0.01022f;
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".strafe")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Strafe.mc.player.addChatMessage("Strafe on");
            }
            else {
                Strafe.mc.player.addChatMessage("Strafe off");
            }
        }
    }
}

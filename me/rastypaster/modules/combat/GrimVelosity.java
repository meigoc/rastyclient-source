// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.network.IPacket;
import me.rastypaster.Module;

public class GrimVelosity extends Module
{
    public GrimVelosity() {
        this.name = "Test";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && GrimVelosity.mc.player != null && GrimVelosity.mc.player.hurtTime > 0) {
            GrimVelosity.mc.player.setVelocity(0.0, 0.0, 0.0);
        }
    }
    
    public void EventSendPacket(final IPacket packet) {
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".test")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                GrimVelosity.mc.player.addChatMessage("Velocity on");
            }
            else {
                GrimVelosity.mc.player.addChatMessage("Velocity off");
            }
        }
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.network.IPacket;
import me.rastypaster.Module;

public class Velocity extends Module
{
    public Velocity() {
        this.name = "Velocity";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    public void EventSendPacket(final IPacket packet) {
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".velocity")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Velocity.mc.player.addChatMessage("Velocity on");
            }
            else {
                Velocity.mc.player.addChatMessage("Velocity off");
            }
        }
    }
}

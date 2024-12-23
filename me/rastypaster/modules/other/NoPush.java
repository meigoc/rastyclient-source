// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.other;

import me.rastypaster.Module;

public class NoPush extends Module
{
    public NoPush() {
        this.name = "NoPush";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".NoPush")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                NoPush.mc.player.addChatMessage("NoPush on");
            }
            else {
                NoPush.mc.player.addChatMessage("NoPush off");
            }
        }
    }
}

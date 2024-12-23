// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class Watermark extends Module
{
    public Watermark() {
        this.name = "Watermark";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".Watermark")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Watermark.mc.player.addChatMessage("Watermark on");
            }
            else {
                Watermark.mc.player.addChatMessage("Watermark off");
            }
        }
    }
}

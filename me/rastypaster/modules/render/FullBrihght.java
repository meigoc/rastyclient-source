// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class FullBrihght extends Module
{
    public FullBrihght() {
        this.name = "FullBright";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {
            FullBrihght.mc.gameSettings.gamma = 100.0;
        }
        else {
            FullBrihght.mc.gameSettings.gamma = 0.0;
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".FullBrihght")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                FullBrihght.mc.player.addChatMessage("FullBrihght on");
            }
            else {
                FullBrihght.mc.player.addChatMessage("FullBrihght off");
            }
        }
    }
}

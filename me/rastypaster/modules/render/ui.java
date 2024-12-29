// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class ui extends Module
{
    public ui() {
        this.name = "ClickGui";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".ui")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                ui.mc.player.addChatMessage("ui on");
            }
            else {
                ui.mc.player.addChatMessage("ui off");
            }
        }
    }
}

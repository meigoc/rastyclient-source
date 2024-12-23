// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class TargetHUD extends Module
{
    public TargetHUD() {
        this.name = "TargetHUD";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".TargetHud")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                TargetHUD.mc.player.addChatMessage("TargetHud on");
            }
            else {
                TargetHUD.mc.player.addChatMessage("TargetHud off");
            }
        }
    }
}

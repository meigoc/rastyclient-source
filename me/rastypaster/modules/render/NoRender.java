// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class NoRender extends Module
{
    public static boolean fire;
    public static boolean pumpkin;
    
    public NoRender() {
        this.name = "NoRender";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".norender")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                NoRender.mc.player.addChatMessage("NoRender on");
            }
            else {
                NoRender.mc.player.addChatMessage("NoRender off");
            }
        }
    }
}

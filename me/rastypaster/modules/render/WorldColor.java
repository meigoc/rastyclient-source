// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class WorldColor extends Module
{
    public WorldColor() {
        this.name = "WorldColor";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".worldcolor")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                WorldColor.mc.player.addChatMessage("worldcolor on");
            }
            else {
                WorldColor.mc.player.addChatMessage("worldcolor off");
            }
        }
    }
}

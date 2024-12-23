// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class Arraylist extends Module
{
    public static int f;
    
    public Arraylist() {
        this.name = "Arraylist";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".arraylist")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Arraylist.mc.player.addChatMessage("Arraylist on");
            }
            else {
                Arraylist.mc.player.addChatMessage("Arraylist off");
            }
        }
    }
    
    static {
        Arraylist.f = 1;
    }
}

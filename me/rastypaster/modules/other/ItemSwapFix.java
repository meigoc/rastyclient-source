// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.other;

import me.rastypaster.Module;

public class ItemSwapFix extends Module
{
    public ItemSwapFix() {
        this.name = "ItemSwapFix";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".ItemSwapFix")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                ItemSwapFix.mc.player.addChatMessage("itemfix on");
            }
            else {
                ItemSwapFix.mc.player.addChatMessage("itemfix off");
            }
        }
    }
}

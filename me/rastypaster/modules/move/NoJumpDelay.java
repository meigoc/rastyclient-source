// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import me.rastypaster.Module;

public class NoJumpDelay extends Module
{
    public NoJumpDelay() {
        this.name = "NoJumpDelay";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && NoJumpDelay.mc.player != null) {
            NoJumpDelay.mc.player.jumpTicks = 0;
        }
    }
}

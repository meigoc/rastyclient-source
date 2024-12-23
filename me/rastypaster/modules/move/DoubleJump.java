// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import me.rastypaster.Module;

public class DoubleJump extends Module
{
    public DoubleJump() {
        this.name = "DoubleJump";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && DoubleJump.mc.player != null && DoubleJump.mc.player.isJumping) {
            DoubleJump.mc.player.jump();
        }
    }
}

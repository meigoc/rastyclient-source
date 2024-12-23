// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import me.rastypaster.utill.move.MovementUtill;
import me.rastypaster.Module;

public class Sprint extends Module
{
    public Sprint() {
        this.name = "Sprint";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && Sprint.mc.player != null && MovementUtill.isMoving()) {
            Sprint.mc.player.setSprinting(false);
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".sprint")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Sprint.mc.player.addChatMessage("Sprint on");
            }
            else {
                Sprint.mc.player.addChatMessage("Sprint off");
            }
        }
    }
}

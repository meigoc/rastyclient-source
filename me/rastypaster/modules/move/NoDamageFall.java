// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import me.rastypaster.Module;

public class NoDamageFall extends Module
{
    public static int f;
    
    public NoDamageFall() {
        this.name = "NoDamageFall";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && NoDamageFall.mc.player != null) {
            NoDamageFall.mc.player.getMotion().y = 1.0E-4;
            if (NoDamageFall.mc.player.ticksExisted % 2 == 0) {
                NoDamageFall.mc.player.getMotion().y = -1.0E-4;
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".speed")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                NoDamageFall.mc.player.addChatMessage("Speed on");
            }
            else {
                NoDamageFall.mc.player.addChatMessage("Speed off");
            }
        }
    }
    
    static {
        NoDamageFall.f = 1;
    }
}

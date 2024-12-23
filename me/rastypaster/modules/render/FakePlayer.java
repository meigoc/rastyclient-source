// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import me.rastypaster.Module;

public class FakePlayer extends Module
{
    public static float fd;
    public ClientPlayerEntity clientplayerentity;
    
    public FakePlayer() {
        this.name = "FakePlayer";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".fastbow")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                FakePlayer.mc.player.addChatMessage("FastBow on");
            }
            else {
                FakePlayer.mc.player.addChatMessage("FastBow off");
            }
        }
    }
}

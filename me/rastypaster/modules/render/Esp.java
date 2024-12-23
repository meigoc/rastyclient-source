// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import me.rastypaster.Module;

public class Esp extends Module
{
    public static boolean fire;
    public static boolean pumpkin;
    
    public Esp() {
        this.name = "Esp";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {
            for (int i = 0; i < Esp.mc.world.getPlayers().size(); i -= 15423, i += 15424) {
                Esp.mc.world.getPlayers().get(i).setGlowing(false);
            }
        }
        else {
            for (int j = 0; j < Esp.mc.world.getPlayers().size(); j += 14719, j -= 14718) {
                Esp.mc.world.getPlayers().get(j).setGlowing(true);
            }
        }
    }
}

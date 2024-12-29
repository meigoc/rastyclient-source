// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.item.Items;
import me.rastypaster.Module;

public class FastBow extends Module
{
    public boolean gogo;
    public static float fd;
    
    public FastBow() {
        this.name = "FastBow";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && FastBow.mc.player != null && FastBow.mc.player.getHeldItemOffhand().getItem() == Items.BOW) {
            FastBow.mc.gameSettings.keyBindUseItem.setPressed(false);
            if (FastBow.mc.player.ticksExisted % 14 == 0) {
                FastBow.mc.gameSettings.keyBindUseItem.setPressed(true);
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".fastbow")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                FastBow.mc.player.addChatMessage("FastBow on");
            }
            else {
                FastBow.mc.player.addChatMessage("FastBow off");
            }
        }
    }
}

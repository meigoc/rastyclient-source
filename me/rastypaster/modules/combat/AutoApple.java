// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.item.Items;
import me.rastypaster.Module;

public class AutoApple extends Module
{
    public static float fd;
    public boolean use;
    
    public AutoApple() {
        this.use = false;
        this.name = "AutoApple";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && AutoApple.mc.player != null) {
            if (AutoApple.mc.player.getHeldItemOffhand().getItem() == Items.GOLDEN_APPLE && AutoApple.mc.player.getHealth() <= AutoApple.fd) {
                this.use = true;
                AutoApple.mc.gameSettings.keyBindUseItem.setPressed(false);
            }
            else if (this.use) {
                AutoApple.mc.gameSettings.keyBindUseItem.setPressed(true);
                this.use = false;
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".autoapple")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                AutoApple.mc.player.addChatMessage("AutoApple on");
            }
            else {
                AutoApple.mc.player.addChatMessage("AutoApple off");
            }
        }
    }
    
    static {
        AutoApple.fd = 15.75f;
    }
}

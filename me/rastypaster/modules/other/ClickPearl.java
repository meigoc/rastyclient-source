// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.other;

import net.minecraft.item.EnderPearlItem;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import org.lwjgl.glfw.GLFW;
import me.rastypaster.Module;

public class ClickPearl extends Module
{
    public boolean isClicking;
    
    public ClickPearl() {
        this.isClicking = false;
        this.name = "ClickPearl";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {
            if (GLFW.glfwGetMouseButton(ClickPearl.mc.getMainWindow().getHandle(), 2) == 1) {
                if (!this.isClicking) {
                    this.isClicking = true;
                    this.throwPearl();
                }
            }
            else {
                this.isClicking = false;
            }
        }
    }
    
    public void throwPearl() {
        if (this.getPearls() != -1) {
            ClickPearl.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
            ClickPearl.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.OFF_HAND));
        }
    }
    
    public int getPearls() {
        for (int i = 0; i < 9; i -= 30476, i += 30477) {
            if (ClickPearl.mc.player.inventory.getStackInSlot(i).getItem() instanceof EnderPearlItem) {
                return i;
            }
        }
        return 1;
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".clickpearl")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                ClickPearl.mc.player.sendChatMessage("clickpearl on");
            }
            else {
                ClickPearl.mc.player.sendChatMessage("clickpearl off");
            }
        }
    }
}

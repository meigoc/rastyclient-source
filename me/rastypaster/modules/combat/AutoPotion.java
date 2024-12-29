// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.network.play.client.CPlayerTryUseItemPacket;
import net.minecraft.util.Hand;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.client.CHeldItemChangePacket;
import net.minecraft.potion.Effect;
import net.minecraft.item.ThrowablePotionItem;
import me.rastypaster.Module;

public class AutoPotion extends Module
{
    public AutoPotion() {
        this.name = "AutoPotion";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && AutoPotion.mc.player != null) {
            for (int i = 0; i < 9; i += 26579, i -= 26578) {
                if (AutoPotion.mc.player.inventory.getStackInSlot(i).getItem() instanceof ThrowablePotionItem && !AutoPotion.mc.player.isPotionActive(Effect.get(1))) {
                    AutoPotion.mc.player.rotationPitch = 90.0f;
                    AutoPotion.mc.player.connection.sendPacket(new CHeldItemChangePacket(i));
                    AutoPotion.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                    AutoPotion.mc.player.connection.sendPacket(new CHeldItemChangePacket(AutoPotion.mc.player.inventory.currentItem));
                }
            }
            for (int j = 0; j < 9; j -= 6026, j += 6027) {
                if (AutoPotion.mc.player.inventory.getStackInSlot(j).getItem() instanceof ThrowablePotionItem && !AutoPotion.mc.player.isPotionActive(Effect.get(12))) {
                    AutoPotion.mc.player.rotationPitch = 90.0f;
                    AutoPotion.mc.player.connection.sendPacket(new CHeldItemChangePacket(j));
                    AutoPotion.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                    AutoPotion.mc.player.connection.sendPacket(new CHeldItemChangePacket(AutoPotion.mc.player.inventory.currentItem));
                }
            }
            for (int k = 0; k < 9; k -= 30386, k += 30387) {
                if (AutoPotion.mc.player.inventory.getStackInSlot(k).getItem() instanceof ThrowablePotionItem && !AutoPotion.mc.player.isPotionActive(Effect.get(5))) {
                    AutoPotion.mc.player.rotationPitch = 90.0f;
                    AutoPotion.mc.player.connection.sendPacket(new CHeldItemChangePacket(k));
                    AutoPotion.mc.player.connection.sendPacket(new CPlayerTryUseItemPacket(Hand.MAIN_HAND));
                    AutoPotion.mc.player.connection.sendPacket(new CHeldItemChangePacket(AutoPotion.mc.player.inventory.currentItem));
                }
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".autopotion")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                AutoPotion.mc.player.addChatMessage("autopotion on");
            }
            else {
                AutoPotion.mc.player.addChatMessage("autopotion off");
            }
        }
    }
}

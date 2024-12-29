// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.item.Items;
import net.optifine.Config;
import net.minecraft.world.World;
import me.rastypaster.Module;

public class Fly extends Module
{
    public static int f;
    public World world2;
    
    public Fly() {
        this.world2 = Config.getMinecraft().world;
        this.name = "Fly";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && Fly.mc.player != null) {
            switch (Fly.f) {
                case 1: {
                    if (Fly.mc.player.isInWater()) {
                        if (Fly.mc.player.getHeldItemOffhand().getItem() == Items.TRIDENT) {
                            Fly.mc.gameSettings.keyBindUseItem.setPressed(false);
                            if (Fly.mc.player.ticksExisted % 14 == 0) {
                                Fly.mc.gameSettings.keyBindUseItem.setPressed(true);
                            }
                        }
                        if (Fly.mc.player.getHeldItemMainhand().getItem() == Items.TRIDENT) {
                            Fly.mc.gameSettings.keyBindUseItem.setPressed(false);
                            if (Fly.mc.player.ticksExisted % 14 == 0) {
                                Fly.mc.gameSettings.keyBindUseItem.setPressed(true);
                            }
                        }
                    }
                    if (!Fly.mc.world.getWorldInfo().isRaining() && !Fly.mc.world.getWorldInfo().isThundering()) {
                        break;
                    }
                    if (Fly.mc.player.getHeldItemMainhand().getItem() == Items.TRIDENT) {
                        Fly.mc.gameSettings.keyBindUseItem.setPressed(false);
                        if (Fly.mc.player.ticksExisted % 14 == 0) {
                            Fly.mc.gameSettings.keyBindUseItem.setPressed(true);
                        }
                    }
                    if (Fly.mc.player.getHeldItemOffhand().getItem() != Items.TRIDENT) {
                        break;
                    }
                    Fly.mc.gameSettings.keyBindUseItem.setPressed(false);
                    if (Fly.mc.player.ticksExisted % 14 == 0) {
                        Fly.mc.gameSettings.keyBindUseItem.setPressed(true);
                        break;
                    }
                    break;
                }
                case 2: {
                    if (Fly.mc.player.hurtTime > 0) {
                        Fly.mc.player.getMotion().y += 0.6;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".fly")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Fly.mc.player.addChatMessage("Fly on");
            }
            else {
                Fly.mc.player.addChatMessage("Fly off");
            }
        }
    }
    
    static {
        Fly.f = 1;
    }
}

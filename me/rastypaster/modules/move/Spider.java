// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import me.rastypaster.Module;

public class Spider extends Module
{
    public boolean use;
    
    public Spider() {
        this.name = "Spider";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && Spider.mc.player != null) {
            if (Minecraft.getInstance().world.getBlockState(new BlockPos(Minecraft.getInstance().player.getPosX() + 0.4, Spider.mc.player.getPosY(), Spider.mc.player.getPosZ() + 0.4)).getBlock() != Blocks.AIR) {
                if (Spider.mc.player.getHeldItemMainhand() != null) {
                    this.use = true;
                    Spider.mc.player.rotationPitch = 81.0f;
                    Spider.mc.gameSettings.keyBindUseItem.setPressed(false);
                    if (Spider.mc.player.ticksExisted % 6 == 0) {
                        Spider.mc.player.jump();
                        Spider.mc.player.jump();
                    }
                }
                else if (this.use) {
                    Spider.mc.gameSettings.keyBindUseItem.setPressed(true);
                    this.use = false;
                }
            }
            if (Minecraft.getInstance().world.getBlockState(new BlockPos(Minecraft.getInstance().player.getPosX() - 0.4, Spider.mc.player.getPosY(), Spider.mc.player.getPosZ() - 0.4)).getBlock() != Blocks.AIR) {
                if (Spider.mc.player.getHeldItemMainhand() != null) {
                    this.use = true;
                    Spider.mc.player.rotationPitch = 81.0f;
                    Spider.mc.gameSettings.keyBindUseItem.setPressed(false);
                    if (Spider.mc.player.ticksExisted % 6 == 0) {
                        Spider.mc.player.jump();
                        Spider.mc.player.jump();
                    }
                }
                else if (this.use) {
                    Spider.mc.gameSettings.keyBindUseItem.setPressed(true);
                    this.use = false;
                }
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".spider")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Spider.mc.player.addChatMessage("Spider on");
            }
            else {
                Spider.mc.player.addChatMessage("Spider off");
            }
        }
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;
import me.rastypaster.Module;

public class Jesus extends Module
{
    public Jesus() {
        this.name = "Jesus";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && Jesus.mc.player != null) {
            if (Minecraft.getInstance().world.getBlockState(new BlockPos(Minecraft.getInstance().player.getPosX(), Jesus.mc.player.getPosY(), Jesus.mc.player.getPosZ())).getBlock() == Blocks.WATER) {
                Jesus.mc.player.getMotion().y = 0.0053900000639259815;
            }
            if (Minecraft.getInstance().world.getBlockState(new BlockPos(Minecraft.getInstance().player.getPosX(), Jesus.mc.player.getPosY() + 0.3, Jesus.mc.player.getPosZ())).getBlock() == Blocks.AIR) {
                Jesus.mc.player.getMotion().y = -0.12999999523162842;
            }
        }
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".jesus")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                Jesus.mc.player.addChatMessage("Jesus on");
            }
            else {
                Jesus.mc.player.addChatMessage("Jesus off");
            }
        }
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.move;

import net.minecraft.util.math.vector.Vector3d;
import me.rastypaster.Module;

public class ReverseStep extends Module
{
    public ReverseStep() {
        this.name = "ReverseStep";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable && ReverseStep.mc.player != null && ReverseStep.mc.player.fallDistance != 0.0) {
            final Vector3d motion = ReverseStep.mc.player.getMotion();
            motion.y -= 2.0;
        }
    }
}

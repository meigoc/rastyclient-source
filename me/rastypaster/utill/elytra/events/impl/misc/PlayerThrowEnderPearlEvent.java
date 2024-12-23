// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.misc;

import net.minecraft.util.math.vector.Vector3d;
import me.rastypaster.utill.elytra.events.Event;

public class PlayerThrowEnderPearlEvent extends Event
{
    public Vector3d targetPosition;
    public final String throwingPlayer;
    public final double targetX;
    public final double targetY;
    public final double targetZ;
    
    public PlayerThrowEnderPearlEvent(final String throwingPlayer, final double targetX, final double targetY, final double targetZ) {
        this.throwingPlayer = throwingPlayer;
        this.targetX = targetX;
        this.targetY = targetY;
        this.targetPosition = this.targetPosition;
        this.targetZ = targetZ;
    }
    
    public String getThrowingPlayer() {
        return this.throwingPlayer;
    }
    
    public double getTargetX() {
        return this.targetX;
    }
    
    public double getTargetY() {
        return this.targetY;
    }
    
    public double getTargetZ() {
        return this.targetZ;
    }
    
    public String getTargetPlayer() {
        return this.throwingPlayer;
    }
    
    public Vector3d getTargetPosition() {
        return this.targetPosition;
    }
}

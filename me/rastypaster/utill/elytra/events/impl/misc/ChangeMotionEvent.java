// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.misc;

import java.util.ArrayDeque;
import java.util.Queue;
import me.rastypaster.utill.elytra.events.Event;

public class ChangeMotionEvent extends Event
{
    public double x;
    public double y;
    public double z;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean isCrouching;
    public boolean isSprinting;
    public boolean canceled;
    public Queue<Runnable> postActions;
    
    public ChangeMotionEvent(final double x, final double y, final double z, final float yaw, final float pitch, final boolean onGround, final boolean isCrouching, final boolean isSprinting) {
        this.postActions = new ArrayDeque<Runnable>();
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
        this.isCrouching = isCrouching;
        this.isSprinting = isSprinting;
    }
    
    public boolean isCanceled() {
        return this.canceled;
    }
    
    public void setCanceled(final boolean canceled) {
        this.canceled = canceled;
    }
    
    public String getName() {
        return "motion_event";
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import me.rastypaster.utill.elytra.events.Event;

public class EventStrafe extends Event
{
    public float yaw;
    
    public EventStrafe(final float yaw) {
        this.yaw = yaw;
    }
}

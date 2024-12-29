// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import me.rastypaster.utill.elytra.events.Event;

public class EventRotation extends Event
{
    public float yaw;
    public float pitch;
    
    public EventRotation(final float yaw, final float pitch) {
        this.yaw = yaw;
        this.pitch = pitch;
    }
}

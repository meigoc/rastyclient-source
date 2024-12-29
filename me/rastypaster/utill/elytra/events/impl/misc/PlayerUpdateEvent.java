// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.misc;

import me.rastypaster.utill.elytra.events.Event;

public class PlayerUpdateEvent extends Event
{
    public final boolean sprinting;
    
    public PlayerUpdateEvent(final boolean sprinting) {
        this.sprinting = sprinting;
    }
    
    public boolean isSprinting() {
        return this.sprinting;
    }
}

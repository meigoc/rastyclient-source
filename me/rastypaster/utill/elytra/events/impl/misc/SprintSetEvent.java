// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.misc;

import me.rastypaster.utill.elytra.events.Event;

public class SprintSetEvent extends Event
{
    public boolean value;
    
    public void disableSprint() {
        this.value = false;
    }
    
    public void enableSprint() {
        this.value = true;
    }
}

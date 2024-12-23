// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.game;

import net.minecraft.entity.Entity;
import me.rastypaster.utill.elytra.events.Event;

public class EventRemoveEntityFromWorld extends Event
{
    public final Entity entity;
    
    public EventRemoveEntityFromWorld(final Entity entity) {
        this.entity = entity;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
}

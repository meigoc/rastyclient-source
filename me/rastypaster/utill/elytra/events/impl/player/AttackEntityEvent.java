// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.entity.Entity;
import me.rastypaster.utill.elytra.events.Event;

public final class AttackEntityEvent extends Event
{
    public final Entity targetEntity;
    
    public AttackEntityEvent(final Entity targetEntity) {
        this.targetEntity = targetEntity;
    }
    
    public boolean hasTarget() {
        return this.targetEntity != null;
    }
    
    public Entity getTarget() {
        return this.targetEntity;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import me.rastypaster.utill.elytra.events.Event;

public class EventDamage extends Event
{
    public final DamageType damageType;
    
    public EventDamage(final DamageType damageType) {
        this.damageType = damageType;
    }
    
    public DamageType getDamageType() {
        return this.damageType;
    }
    
    public enum DamageType
    {
        FALL, 
        ARROW, 
        ENDER_PEARL;
        
        public static final DamageType[] $VALUES;
        
        static {
            $VALUES = new DamageType[] { DamageType.FALL, DamageType.ARROW, DamageType.ENDER_PEARL };
        }
    }
}

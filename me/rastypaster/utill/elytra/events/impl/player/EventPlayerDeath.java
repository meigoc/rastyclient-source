// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.entity.player.PlayerEntity;
import me.rastypaster.utill.elytra.events.Event;

public class EventPlayerDeath extends Event
{
    public final PlayerEntity player;
    
    public EventPlayerDeath(final PlayerEntity player) {
        this.player = player;
    }
}

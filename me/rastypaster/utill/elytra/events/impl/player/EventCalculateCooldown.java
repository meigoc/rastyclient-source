// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.item.Item;
import me.rastypaster.utill.elytra.events.Event;

public class EventCalculateCooldown extends Event
{
    public Item itemStack;
    public float cooldown;
    
    public EventCalculateCooldown(final Item itemStack) {
        this.itemStack = itemStack;
    }
}

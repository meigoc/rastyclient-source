// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.misc;

import net.minecraft.entity.item.EnderPearlEntity;
import me.rastypaster.utill.elytra.events.Event;

public class EnderPearlThrownEvent extends Event
{
    public final EnderPearlEntity enderPearlEntity;
    
    public EnderPearlThrownEvent(final EnderPearlEntity enderPearlEntity) {
        this.enderPearlEntity = enderPearlEntity;
    }
    
    public EnderPearlEntity getEnderPearlEntity() {
        return this.enderPearlEntity;
    }
}

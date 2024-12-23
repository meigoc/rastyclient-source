// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.util.math.vector.Vector3d;
import me.rastypaster.utill.elytra.events.Event;

public class PlayerMovementEvent extends Event
{
    public final Vector3d playerPosition;
    
    public PlayerMovementEvent(final Vector3d playerPosition) {
        this.playerPosition = playerPosition;
    }
    
    public Vector3d getPlayerPosition() {
        return this.playerPosition;
    }
}

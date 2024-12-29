// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import me.rastypaster.utill.elytra.events.Event;

public class EventOverlaysRender extends Event
{
    public final OverlayType overlayType;
    
    public EventOverlaysRender(final OverlayType overlayType) {
        this.overlayType = overlayType;
    }
    
    public enum OverlayType
    {
        FIRE_OVERLAY, 
        BOSS_LINE, 
        SCOREBOARD, 
        TITLES, 
        TOTEM, 
        FOG;
        
        public static final OverlayType[] $VALUES;
        
        static {
            $VALUES = new OverlayType[] { OverlayType.FIRE_OVERLAY, OverlayType.BOSS_LINE, OverlayType.SCOREBOARD, OverlayType.TITLES, OverlayType.TOTEM, OverlayType.FOG };
        }
    }
}

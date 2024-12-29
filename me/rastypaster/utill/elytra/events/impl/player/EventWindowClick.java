// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.inventory.container.ClickType;
import me.rastypaster.utill.elytra.events.Event;

public class EventWindowClick extends Event
{
    public final int windowId;
    public final int slot;
    public final int button;
    public final ClickType clickType;
    public final ClickStage clickStage;
    
    public EventWindowClick(final ClickStage clickStage, final int windowId, final int slot, final int button, final ClickType clickType) {
        this.clickStage = clickStage;
        this.windowId = windowId;
        this.slot = slot;
        this.button = button;
        this.clickType = clickType;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public int getSlot() {
        return this.slot;
    }
    
    public int getButton() {
        return this.button;
    }
    
    public ClickType getClickType() {
        return this.clickType;
    }
    
    public ClickStage getClickStage() {
        return this.clickStage;
    }
    
    public enum ClickStage
    {
        PRE, 
        POST;
        
        public static final ClickStage[] $VALUES;
        
        static {
            $VALUES = new ClickStage[] { ClickStage.PRE, ClickStage.POST };
        }
    }
}

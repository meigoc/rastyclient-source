// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.client.renderer.entity.PlayerRenderer;
import me.rastypaster.utill.elytra.events.Event;

public class EventModelRender extends Event
{
    public PlayerRenderer renderer;
    public Runnable entityRenderer;
    
    public EventModelRender(final PlayerRenderer renderer, final Runnable entityRenderer) {
        this.renderer = renderer;
        this.entityRenderer = entityRenderer;
    }
    
    public void render() {
        this.entityRenderer.run();
    }
}

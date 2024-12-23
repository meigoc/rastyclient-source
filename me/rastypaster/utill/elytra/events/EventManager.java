// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events;

import net.minecraft.client.Minecraft;

public class EventManager
{
    public static void call(final Event event) {
        if (Minecraft.getInstance().player == null || Minecraft.getInstance().world == null) {
            return;
        }
        if (event.isCancel()) {
            return;
        }
    }
}

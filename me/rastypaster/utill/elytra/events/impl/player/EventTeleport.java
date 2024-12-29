// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.network.play.client.CPlayerPacket;
import me.rastypaster.utill.elytra.events.Event;

public class EventTeleport extends Event
{
    public CPlayerPacket response;
    public double posX;
    public double posY;
    public double posZ;
    public float yaw;
    public float pitch;
}

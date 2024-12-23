// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.packet;

import net.minecraft.network.IPacket;
import me.rastypaster.utill.elytra.events.Event;

public class EventPacket extends Event
{
    public IPacket packet;
    public final PacketType packetType;
    
    public EventPacket(final IPacket packet, final PacketType packetType) {
        this.packet = packet;
        this.packetType = packetType;
    }
    
    public IPacket getPacket() {
        return this.packet;
    }
    
    public void setPacket(final IPacket packet) {
        this.packet = packet;
    }
    
    public boolean isReceivePacket() {
        return this.packetType == PacketType.RECEIVE;
    }
    
    public boolean isSendPacket() {
        return this.packetType == PacketType.SEND;
    }
    
    public enum PacketType
    {
        SEND, 
        RECEIVE;
        
        public static final PacketType[] $VALUES;
        
        static {
            $VALUES = new PacketType[] { PacketType.SEND, PacketType.RECEIVE };
        }
    }
}

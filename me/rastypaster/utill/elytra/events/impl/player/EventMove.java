// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import me.rastypaster.utill.elytra.events.Event;

public class EventMove extends Event
{
    public Vector3d from;
    public Vector3d to;
    public Vector3d motion;
    public boolean toGround;
    public AxisAlignedBB aabbFrom;
    public boolean ignoreHorizontal;
    public boolean ignoreVertical;
    public boolean collidedHorizontal;
    public boolean collidedVertical;
    
    public EventMove(final Vector3d from, final Vector3d to, final Vector3d motion, final boolean toGround, final boolean collidedHorizontal, final boolean collidedVertical, final AxisAlignedBB aabbFrom) {
        this.from = from;
        this.to = to;
        this.motion = motion;
        this.toGround = toGround;
        this.collidedHorizontal = collidedHorizontal;
        this.collidedVertical = collidedVertical;
        this.aabbFrom = aabbFrom;
    }
    
    public void setIgnoreHorizontalCollision() {
        this.ignoreHorizontal = true;
    }
    
    public void setIgnoreVerticalCollision() {
        this.ignoreVertical = true;
    }
    
    public boolean isIgnoreHorizontal() {
        return this.ignoreHorizontal;
    }
    
    public AxisAlignedBB getAABBFrom() {
        return this.aabbFrom;
    }
    
    public boolean isIgnoreVertical() {
        return this.ignoreVertical;
    }
    
    public boolean isCollidedHorizontal() {
        return this.collidedHorizontal;
    }
    
    public boolean isCollidedVertical() {
        return this.collidedVertical;
    }
    
    public boolean toGround() {
        return this.toGround;
    }
    
    public Vector3d from() {
        return this.from;
    }
    
    public Vector3d to() {
        return this.to;
    }
    
    public Vector3d motion() {
        return this.motion;
    }
}

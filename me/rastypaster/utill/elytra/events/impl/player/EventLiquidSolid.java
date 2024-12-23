// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.player;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.FlowingFluidBlock;
import me.rastypaster.utill.elytra.events.Event;

public class EventLiquidSolid extends Event
{
    public final FlowingFluidBlock blockLiquid;
    public final BlockPos pos;
    public VoxelShape collision;
    
    public EventLiquidSolid(final FlowingFluidBlock blockLiquid, final BlockPos pos) {
        this.blockLiquid = blockLiquid;
        this.pos = pos;
        this.collision = VoxelShapes.empty();
    }
    
    public FlowingFluidBlock getBlock() {
        return this.blockLiquid;
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public VoxelShape getCollision() {
        return this.collision;
    }
    
    public void setCollision(final VoxelShape collision) {
        this.collision = collision;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.elytra.events.impl.render;

import net.minecraft.util.math.vector.Matrix4f;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.MainWindow;
import me.rastypaster.utill.elytra.events.Event;

public class EventRender extends Event
{
    public float partialTicks;
    public MainWindow scaledResolution;
    public Type type;
    public MatrixStack matrixStack;
    public Matrix4f matrix;
    
    public EventRender(final float partialTicks, final MatrixStack matrixStack, final MainWindow scaledResolution, final Type type, final Matrix4f matrix) {
        this.partialTicks = partialTicks;
        this.scaledResolution = scaledResolution;
        this.matrixStack = matrixStack;
        this.type = type;
        this.matrix = matrix;
    }
    
    public boolean isRender3D() {
        return this.type == Type.RENDER3D;
    }
    
    public boolean isRender2D() {
        return this.type == Type.RENDER2D;
    }
    
    public enum Type
    {
        RENDER3D, 
        RENDER2D;
        
        public static final Type[] $VALUES;
        
        static {
            $VALUES = new Type[] { Type.RENDER3D, Type.RENDER2D };
        }
    }
}

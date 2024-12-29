// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.draggable;

import net.minecraft.util.math.MathHelper;

public class DrugComponent
{
    public final String name;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean drag;
    public int prevX;
    public int prevY;
    
    public String getName() {
        return this.name;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public void setWidth(final int width) {
        this.width = width;
    }
    
    public void setHeight(final int height) {
        this.height = height;
    }
    
    public DrugComponent(final String name, final int x, final int y, final int width, final int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void draw(final int n, final int n2) {
        if (this.drag) {
            this.x = n - this.prevX;
            this.y = n2 - this.prevY;
        }
    }
    
    public void click(final int n, final int n2) {
        if (MathHelper.isMouseHoveringOnRect(this.x, this.y, this.width, this.height, n, n2)) {
            this.drag = true;
            this.prevX = n - this.x;
            this.prevY = n2 - this.y;
        }
    }
    
    public void release() {
        this.drag = false;
    }
    
    public boolean allowDraw() {
        return false;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class Inventory extends Module
{
    public static int mode;
    
    public Inventory() {
        this.name = "Inventory";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    static {
        Inventory.mode = 1;
    }
}

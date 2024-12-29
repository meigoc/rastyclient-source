// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.render;

import me.rastypaster.Module;

public class Themes extends Module
{
    public static int mode;
    
    public Themes() {
        this.name = "Themes";
    }
    
    @Override
    public void onUpdate() {
        if (this.isEnable) {}
    }
    
    static {
        Themes.mode = 1;
    }
}

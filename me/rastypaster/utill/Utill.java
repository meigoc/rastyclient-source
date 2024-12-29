// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;

public class Utill
{
    public static Minecraft mc;
    public ScaledResolution sr;
    
    public Utill() {
        this.sr = new ScaledResolution(Utill.mc);
    }
    
    static {
        Utill.mc = Minecraft.getInstance();
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster;

import net.minecraft.client.Minecraft;

public class Module
{
    public static Minecraft mc;
    public boolean isEnable;
    public String name;
    public int bind;
    
    public void onUpdate() {
    }
    
    public void bind() {
    }
    
    public void sendChatMessage(final String s) {
    }
    
    static {
        Module.mc = Minecraft.getInstance();
    }
}

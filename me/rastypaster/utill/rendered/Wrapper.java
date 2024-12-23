// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.rendered;

import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;

public interface Wrapper
{
    public static final Minecraft MC = Minecraft.getInstance();
    public static final MainWindow WINDOW = Wrapper.MC.getMainWindow();
}

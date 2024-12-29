// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.rendered;

import java.awt.Color;

public class ColorHelper
{
    public static Color injectAlpha(final Color color, final int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
    }
    
    public static Color injectAlpha(final Color color, final float n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), (int)(n * 255.0f));
    }
    
    public static Color getColor(final int n) {
        return new Color(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, n >> 24 & 0xFF);
    }
    
    public static float[] getColorComps(final Color color) {
        return new float[] { color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f };
    }
}

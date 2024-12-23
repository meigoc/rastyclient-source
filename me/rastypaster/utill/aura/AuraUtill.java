// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.aura;

import me.rastypaster.utill.Utill;

public class AuraUtill extends Utill
{
    public static float getFixedRotation(final float n) {
        return getDeltaMouse(n) * getGCDValue();
    }
    
    public static float getGCDValue() {
        return (float)(getGCD() * 0.15);
    }
    
    public static float getGCD() {
        final float n;
        return (n = (float)(AuraUtill.mc.gameSettings.mouseSensitivity * 0.6 + 0.2)) * n * n * 8.0f;
    }
    
    public static float getDeltaMouse(final float n) {
        return (float)Math.round(n / getGCDValue());
    }
}

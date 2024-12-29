// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.move;

import me.rastypaster.utill.Utill;

public class Timer extends Utill
{
    public long last;
    
    public Timer() {
        this.updateLastTime();
    }
    
    public boolean hasPassed(final double n) {
        return this.getTime() - this.last >= n;
    }
    
    public long getTime() {
        return System.nanoTime() / 1000000L;
    }
    
    public long getElapsedTime() {
        return this.getTime() - this.last;
    }
    
    public void updateLastTime() {
        this.last = this.getTime();
    }
}

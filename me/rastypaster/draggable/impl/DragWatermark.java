// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.draggable.impl;

import me.rastypaster.Manager;
import me.rastypaster.Module;
import me.rastypaster.draggable.DrugComponent;

public class DragWatermark extends DrugComponent
{
    public DragWatermark() {
        super("WaterMark", 3, 20, 4, 1);
    }
    
    @Override
    public boolean allowDraw() {
        return Manager.render.get(3).isEnable;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.draggable.impl;

import me.rastypaster.Manager;
import me.rastypaster.Module;
import me.rastypaster.draggable.DrugComponent;

public class DragArraylist extends DrugComponent
{
    public DragArraylist() {
        super("WaterMark", 3, 40, 4, 1);
    }
    
    @Override
    public boolean allowDraw() {
        return Manager.render.get(2).isEnable;
    }
}

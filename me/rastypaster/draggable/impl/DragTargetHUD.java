// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.draggable.impl;

import me.rastypaster.Manager;
import me.rastypaster.Module;
import me.rastypaster.draggable.DrugComponent;

public class DragTargetHUD extends DrugComponent
{
    public DragTargetHUD() {
        super("WaterMark", 300, 400, 4, 1);
    }
    
    @Override
    public boolean allowDraw() {
        return Manager.render.get(5).isEnable;
    }
}

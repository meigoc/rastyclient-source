// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.draggable.impl;

import java.util.Iterator;
import com.google.common.collect.Lists;
import me.rastypaster.draggable.DrugComponent;
import java.util.List;
import me.rastypaster.draggable.DragScreen;

public class DragHud
{
    public DragScreen screen;
    public final List<DrugComponent> components;
    
    public DragHud() {
        this.screen = new DragScreen();
        (this.components = Lists.newArrayList()).add(new DragWatermark());
        this.components.add(new DragTargetHUD());
        this.components.add(new DragArraylist());
    }
    
    public DragScreen getScreen() {
        return this.screen;
    }
    
    public List<DrugComponent> getComponents() {
        return this.components;
    }
    
    public DrugComponent getDraggableComponentByClass(final Class<? extends DrugComponent> clazz) {
        for (final DrugComponent drugComponent : this.components) {
            if (drugComponent.getClass() == clazz) {
                return drugComponent;
            }
        }
        return null;
    }
}

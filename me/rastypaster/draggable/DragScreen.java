// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.draggable;

import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import me.rastypaster.Manager;

public class DragScreen
{
    public void draw(final int n, final int n2) {
        for (final DrugComponent drugComponent : Manager.getDragHud().getComponents()) {
            if (drugComponent.allowDraw()) {
                this.drawComponent(n, n2, drugComponent);
            }
        }
    }
    
    public void drawComponent(final int n, final int n2, final DrugComponent drugComponent) {
        drugComponent.draw(n, n2);
        MathHelper.isMouseHoveringOnRect(drugComponent.getX(), drugComponent.getY(), drugComponent.getWidth(), drugComponent.getHeight(), n, n2);
    }
    
    public void click(final int n, final int n2) {
        for (final DrugComponent drugComponent : Manager.getDragHud().getComponents()) {
            if (drugComponent.allowDraw()) {
                drugComponent.click(n, n2);
            }
        }
    }
    
    public void release() {
        final Iterator<DrugComponent> iterator = Manager.getDragHud().getComponents().iterator();
        while (iterator.hasNext()) {
            iterator.next().release();
        }
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.commands;

import me.rastypaster.utill.Utill;

public class CommandConstructor extends Utill
{
    public String name;
    public String howtouse;
    public String description;
    
    public void execute(final String[] array) {
    }
    
    public CommandConstructor(final String name, final String description) {
        this.name = name;
        this.howtouse = this.howtouse;
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public String getName() {
        return this.name;
    }
}

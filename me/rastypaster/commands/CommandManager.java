// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.commands;

import java.util.Iterator;
import java.util.ArrayList;

public class CommandManager
{
    public ArrayList<CommandConstructor> commands;
    public static ArrayList<CommandConstructor> bindsmove;
    
    public CommandManager() {
        this.commands = new ArrayList<CommandConstructor>();
    }
    
    public boolean execute(final String s) {
        final String[] split = s.substring(1).split(" ");
        if (split.length > 0) {
            final Iterator<CommandConstructor> iterator = this.commands.iterator();
            if (iterator.hasNext()) {
                iterator.next().execute(split);
                return false;
            }
        }
        return true;
    }
    
    public void addCommands() {
        this.commands.add(new FriendCommand());
        this.commands.add(new AltCommand());
    }
    
    public void addbinds() {
    }
    
    static {
        CommandManager.bindsmove = new ArrayList<CommandConstructor>();
    }
}

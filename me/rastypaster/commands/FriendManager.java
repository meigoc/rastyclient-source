// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.commands;

import java.util.ArrayList;

public class FriendManager
{
    public ArrayList<Friend> myfriends;
    
    public FriendManager() {
        this.myfriends = new ArrayList<Friend>();
    }
    
    public void add(final String s) {
        this.myfriends.add(new Friend(s));
    }
    
    public void remove(final String s) {
        this.myfriends.removeIf(FriendManager::lambda$remove$0);
    }
    
    public boolean is(final String s) {
        return this.myfriends.stream().anyMatch(FriendManager::lambda$is$1);
    }
    
    public Friend get(final String s) {
        return this.myfriends.stream().filter(FriendManager::lambda$get$2).findFirst().get();
    }
    
    public ArrayList<Friend> getMyfriends() {
        return this.myfriends;
    }
    
    public static boolean lambda$get$2(final String s, final Friend friend) {
        return friend.getName().equals(s);
    }
    
    public static boolean lambda$is$1(final String s, final Friend friend) {
        return friend.getName().equals(s);
    }
    
    public static boolean lambda$remove$0(final String s, final Friend friend) {
        return friend.getName().equals(s);
    }
}

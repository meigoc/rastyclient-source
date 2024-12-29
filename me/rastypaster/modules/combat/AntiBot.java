// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.modules.combat;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import java.util.Iterator;
import java.util.function.Predicate;
import me.rastypaster.utill.elytra.events.impl.misc.PlayerUpdateEvent;
import net.minecraft.entity.player.PlayerEntity;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.entity.Entity;
import java.util.ArrayList;
import me.rastypaster.Module;

public class AntiBot extends Module
{
    public static ArrayList<Entity> isBot;
    public static final CopyOnWriteArrayList<PlayerEntity> bots;
    
    public AntiBot() {
        this.name = "AntiBot";
    }
    
    public void onUpdate(final PlayerUpdateEvent playerUpdateEvent) {
        for (final PlayerEntity playerEntity : AntiBot.mc.world.getPlayers()) {
            if (!playerEntity.getUniqueID().equals(PlayerEntity.getOfflineUUID(playerEntity.getName().getString())) && !AntiBot.bots.contains(playerEntity)) {
                AntiBot.bots.add(playerEntity);
            }
        }
        try {
            AntiBot.mc.world.getPlayers().removeIf(AntiBot.bots::contains);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static boolean isBot(final PlayerEntity playerEntity) {
        return AntiBot.bots.contains(playerEntity);
    }
    
    @Override
    public void sendChatMessage(final String s) {
        if (s.equals(".AntiBot")) {
            this.isEnable = !this.isEnable;
            if (this.isEnable) {
                AntiBot.mc.player.addChatMessage("AntiBot on");
            }
            else {
                AntiBot.mc.player.addChatMessage("AntiBot off");
            }
        }
    }
    
    static {
        bots = new CopyOnWriteArrayList<PlayerEntity>();
        AntiBot.isBot = new ArrayList<Entity>();
    }
}

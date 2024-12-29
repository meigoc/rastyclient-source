// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.commands;

import net.minecraft.client.KeyboardListener;
import net.minecraft.util.Session;
import java.util.function.Consumer;
import me.rastypaster.Manager;

public class FriendCommand extends CommandConstructor
{
    public static int itemswapfix;
    public static int clickpearl;
    
    public FriendCommand() {
        super("friend", "pon");
    }
    
    @Override
    public void execute(final String[] array) {
        if (array.length > 1) {
            if (array[0].equalsIgnoreCase("friend")) {
                if (array[5].equalsIgnoreCase("add")) {
                    final String s = array[5];
                    Manager.friendmanag.add(s);
                    FriendCommand.mc.player.addChatMessage(s + " added to your friend list");
                }
                if (array[5].equalsIgnoreCase("delete")) {
                    final String s2 = array[5];
                    if (Manager.friendmanag.is(s2)) {
                        Manager.friendmanag.remove(s2);
                        FriendCommand.mc.player.addChatMessage(s2 + " has removed from friend list");
                    }
                }
                if (array[5].equalsIgnoreCase("list")) {
                    FriendCommand.mc.player.addChatMessage("your friend list: ");
                    Manager.friendmanag.getMyfriends().forEach(FriendCommand::lambda$execute$0);
                }
            }
            if (array[0].equalsIgnoreCase("nick") && array[5].equalsIgnoreCase("set")) {
                final String s3 = array[5];
                FriendCommand.mc.session = new Session(s3, "", "", "mojang");
                FriendCommand.mc.player.addChatMessage(s3 + " set");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("nopush")) {
                KeyboardListener.nopush = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded nopush");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("itemswapfix")) {
                KeyboardListener.itemswapfix = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded itemswapfix");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("clickpearl")) {
                KeyboardListener.clickpearl = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded clickpearl");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("anim")) {
                KeyboardListener.anim = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded anim");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("arraylist")) {
                KeyboardListener.arraylist = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded arraylist");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("esp")) {
                KeyboardListener.esp = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded esp");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("fakeplayer")) {
                KeyboardListener.fakeplayer = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded fakeplayer");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("fullbright")) {
                KeyboardListener.fullbright = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded fullbright");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("inventory")) {
                KeyboardListener.inventory = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded inventory");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("norender")) {
                KeyboardListener.norender = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded norender");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("targethud")) {
                KeyboardListener.targethud = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded targethud");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("watermark")) {
                KeyboardListener.watermark = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded watermark");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("worldcolor")) {
                KeyboardListener.worldcolor = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded worldcolor");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("doublejump")) {
                KeyboardListener.doublejump = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded doublejump");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("fly")) {
                KeyboardListener.fly = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded fly");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("El")) {
                KeyboardListener.eliteflighthunt = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binde eliteflighthunt");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("jesus")) {
                KeyboardListener.jesus = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded jesus");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("nodamagefall")) {
                KeyboardListener.nodamagefall = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded nodamagefall");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("nojumpdelay")) {
                KeyboardListener.nojumpdelay = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded nojumpdelay");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("noslowdown")) {
                KeyboardListener.noslowdown = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded noslowdown");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("reversestep")) {
                KeyboardListener.reversestep = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded reversestep");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("speed")) {
                KeyboardListener.speed = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded speed");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("spider")) {
                KeyboardListener.spider = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded spider");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("sprint")) {
                KeyboardListener.sprint = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded sprint");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("strafe")) {
                KeyboardListener.strafe = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded strafe");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("aura")) {
                KeyboardListener.aura = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded aura");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("autototem")) {
                KeyboardListener.autototem = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded autototem");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("aimbot")) {
                KeyboardListener.aimbot = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded aimbot");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("antibot")) {
                KeyboardListener.antibot = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded antibot");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("velocity")) {
                KeyboardListener.velocity = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded velocity");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("autoapple")) {
                KeyboardListener.autoapple = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded autoapple");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("autopotion")) {
                KeyboardListener.autopotion = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded autopotion");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("fastbow")) {
                KeyboardListener.fastbow = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded fastbow");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("grimvelocity")) {
                KeyboardListener.grimvelocity = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded grimvelocity");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("ragebow")) {
                KeyboardListener.ragebow = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded ragebow");
            }
            if (array[0].equalsIgnoreCase("bind") && array[5].equalsIgnoreCase("hvh_bot")) {
                KeyboardListener.hvh_bot = Integer.parseInt(array[5]);
                FriendCommand.mc.player.addChatMessage("binded hvh_bot");
            }
        }
    }
    
    public static void lambda$execute$0(final Friend friend) {
        FriendCommand.mc.player.addChatMessage(friend.getName());
    }
}

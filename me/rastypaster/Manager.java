// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import me.rastypaster.ui.clickui.settings.render.InventorySettings;
import me.rastypaster.ui.clickui.settings.render.NoRenderSetting;
import me.rastypaster.ui.clickui.settings.render.ThemeSettings;
import me.rastypaster.ui.clickui.settings.render.FullBrightSettings;
import me.rastypaster.ui.clickui.settings.render.FakePlayerSettings;
import me.rastypaster.ui.clickui.settings.render.TargetHUDSettings;
import me.rastypaster.ui.clickui.settings.render.EspSettings;
import me.rastypaster.ui.clickui.settings.render.WaterSetting;
import me.rastypaster.ui.clickui.settings.render.ArraySetting;
import me.rastypaster.ui.clickui.settings.render.WorldColorSettings;
import me.rastypaster.ui.clickui.settings.render.UiSettings;
import me.rastypaster.ui.clickui.settings.move.ElytraTargetSettings;
import me.rastypaster.ui.clickui.settings.move.NoDamageFallSettings;
import me.rastypaster.ui.clickui.settings.move.SpiderSettings;
import me.rastypaster.ui.clickui.settings.move.FlySettings;
import me.rastypaster.ui.clickui.settings.move.ReverseStepSettings;
import me.rastypaster.ui.clickui.settings.move.NoJumDelaySettings;
import me.rastypaster.ui.clickui.settings.move.DoubleJumpSettings;
import me.rastypaster.ui.clickui.settings.move.NoSlowSetting;
import me.rastypaster.ui.clickui.settings.move.SpeedSetting;
import me.rastypaster.ui.clickui.settings.move.JesusSettings;
import me.rastypaster.ui.clickui.settings.move.StrafeSettings;
import me.rastypaster.ui.clickui.settings.move.SprintSettings;
import me.rastypaster.ui.clickui.settings.combat.HvH_BotSettings;
import me.rastypaster.ui.clickui.settings.combat.RageBowSettings;
import me.rastypaster.ui.clickui.settings.combat.GrimVelocitySettings;
import me.rastypaster.ui.clickui.settings.combat.FastBowSetting;
import me.rastypaster.ui.clickui.settings.combat.AutoPotionSetting;
import me.rastypaster.ui.clickui.settings.combat.AppleSetting;
import me.rastypaster.ui.clickui.settings.combat.VelocitySetting;
import me.rastypaster.ui.clickui.settings.combat.AntiBotSetting;
import me.rastypaster.ui.clickui.settings.combat.AimbotSetings;
import me.rastypaster.ui.clickui.settings.combat.TotemSetting;
import me.rastypaster.ui.clickui.settings.combat.Setting;
import me.rastypaster.modules.other.NoPush;
import me.rastypaster.modules.other.ClickPearl;
import me.rastypaster.modules.other.ItemSwapFix;
import me.rastypaster.modules.combat.HvH_Bot;
import me.rastypaster.modules.combat.RageBow;
import me.rastypaster.modules.combat.GrimVelosity;
import me.rastypaster.modules.combat.FastBow;
import me.rastypaster.modules.combat.AutoPotion;
import me.rastypaster.modules.combat.AutoApple;
import me.rastypaster.modules.combat.Velocity;
import me.rastypaster.modules.combat.AntiBot;
import me.rastypaster.modules.combat.AimBot;
import me.rastypaster.modules.combat.AutoTotem;
import me.rastypaster.modules.combat.Aura;
import me.rastypaster.modules.move.ElytraTarget;
import me.rastypaster.modules.move.NoDamageFall;
import me.rastypaster.modules.move.Spider;
import me.rastypaster.modules.move.Fly;
import me.rastypaster.modules.move.ReverseStep;
import me.rastypaster.modules.move.NoJumpDelay;
import me.rastypaster.modules.move.DoubleJump;
import me.rastypaster.modules.move.NoSlowDown;
import me.rastypaster.modules.move.Speed;
import me.rastypaster.modules.move.Jesus;
import me.rastypaster.modules.move.Strafe;
import me.rastypaster.modules.move.Sprint;
import me.rastypaster.modules.render.Inventory;
import me.rastypaster.modules.render.NoRender;
import me.rastypaster.modules.render.Themes;
import me.rastypaster.modules.render.FullBrihght;
import me.rastypaster.modules.render.FakePlayer;
import me.rastypaster.modules.render.TargetHUD;
import me.rastypaster.modules.render.Esp;
import me.rastypaster.modules.render.Watermark;
import me.rastypaster.modules.render.Arraylist;
import me.rastypaster.modules.render.WorldColor;
import me.rastypaster.modules.render.ui;
import me.rastypaster.draggable.DrugComponent;
import me.rastypaster.commands.CommandManager;
import me.rastypaster.commands.FriendManager;
import me.rastypaster.commands.AltCommand;
import me.rastypaster.draggable.impl.DragHud;
import net.minecraft.client.gui.screen.Screen;
import java.util.ArrayList;

public class Manager
{
    public static String VERSION;
    public static ArrayList<Module> combat;
    public static ArrayList<Module> movement;
    public static ArrayList<Module> render;
    public static ArrayList<Module> other;
    public static ArrayList<Module> hud;
    public static ArrayList<Screen> settingCombat;
    public static ArrayList<Screen> settingMovement;
    public static ArrayList<Screen> settingRender;
    public static ArrayList<Screen> settingOther;
    public static ArrayList<Screen> settingHud;
    public static DragHud dragHud;
    public static AltCommand altCommand;
    public static String CONFIG_FILE_NAME;
    public static FriendManager friendmanag;
    public static CommandManager commandManager;
    
    public static DragHud getDragHud() {
        return Manager.dragHud;
    }
    
    public static FriendManager friendManager() {
        return Manager.friendmanag;
    }
    
    public static DrugComponent getDragHudComp(final Class<? extends DrugComponent> clazz) {
        return Manager.dragHud.getDraggableComponentByClass(clazz);
    }
    
    public static void addModule() {
        Manager.dragHud = new DragHud();
        Manager.render.add(new ui());
        Manager.render.add(new WorldColor());
        Manager.render.add(new Arraylist());
        Manager.render.add(new Watermark());
        Manager.render.add(new Esp());
        Manager.render.add(new TargetHUD());
        Manager.render.add(new FakePlayer());
        Manager.render.add(new FullBrihght());
        Manager.render.add(new Themes());
        Manager.render.add(new NoRender());
        Manager.render.add(new Inventory());
        Manager.movement.add(new Sprint());
        Manager.movement.add(new Strafe());
        Manager.movement.add(new Jesus());
        Manager.movement.add(new Speed());
        Manager.movement.add(new NoSlowDown());
        Manager.movement.add(new DoubleJump());
        Manager.movement.add(new NoJumpDelay());
        Manager.movement.add(new ReverseStep());
        Manager.movement.add(new Fly());
        Manager.movement.add(new Spider());
        Manager.movement.add(new NoDamageFall());
        Manager.movement.add(new ElytraTarget());
        Manager.combat.add(new Aura());
        Manager.combat.add(new AutoTotem());
        Manager.combat.add(new AimBot());
        Manager.combat.add(new AntiBot());
        Manager.combat.add(new Velocity());
        Manager.combat.add(new AutoApple());
        Manager.combat.add(new AutoPotion());
        Manager.combat.add(new FastBow());
        Manager.combat.add(new GrimVelosity());
        Manager.combat.add(new RageBow());
        Manager.combat.add(new HvH_Bot());
        Manager.other.add(new ItemSwapFix());
        Manager.other.add(new ClickPearl());
        Manager.other.add(new NoPush());
        Manager.settingCombat.add(new Setting());
        Manager.settingCombat.add(new TotemSetting());
        Manager.settingCombat.add(new AimbotSetings());
        Manager.settingCombat.add(new AntiBotSetting());
        Manager.settingCombat.add(new VelocitySetting());
        Manager.settingCombat.add(new AppleSetting());
        Manager.settingCombat.add(new AutoPotionSetting());
        Manager.settingCombat.add(new FastBowSetting());
        Manager.settingCombat.add(new GrimVelocitySettings());
        Manager.settingCombat.add(new RageBowSettings());
        Manager.settingCombat.add(new HvH_BotSettings());
        Manager.settingMovement.add(new SprintSettings());
        Manager.settingMovement.add(new StrafeSettings());
        Manager.settingMovement.add(new JesusSettings());
        Manager.settingMovement.add(new SpeedSetting());
        Manager.settingMovement.add(new NoSlowSetting());
        Manager.settingMovement.add(new DoubleJumpSettings());
        Manager.settingMovement.add(new NoJumDelaySettings());
        Manager.settingMovement.add(new ReverseStepSettings());
        Manager.settingMovement.add(new FlySettings());
        Manager.settingMovement.add(new SpiderSettings());
        Manager.settingMovement.add(new NoDamageFallSettings());
        Manager.settingMovement.add(new ElytraTargetSettings());
        Manager.settingRender.add(new UiSettings());
        Manager.settingRender.add(new WorldColorSettings());
        Manager.settingRender.add(new ArraySetting());
        Manager.settingRender.add(new WaterSetting());
        Manager.settingRender.add(new EspSettings());
        Manager.settingRender.add(new TargetHUDSettings());
        Manager.settingRender.add(new FakePlayerSettings());
        Manager.settingRender.add(new FullBrightSettings());
        Manager.settingRender.add(new ThemeSettings());
        Manager.settingRender.add(new NoRenderSetting());
        Manager.settingRender.add(new InventorySettings());
        createConfigFile();
        (Manager.commandManager = new CommandManager()).addCommands();
        Manager.friendmanag = new FriendManager();
        Manager.commandManager.addbinds();
    }
    
    public static void createConfigFile() {
        final File file = new File(Manager.CONFIG_FILE_NAME);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                writeDefaultConfig(file);
            }
            else {
                System.out.println("File already exists.");
            }
        }
        catch (final IOException ex) {
            System.out.println("An error occurred while creating the file.");
            ex.printStackTrace();
        }
    }
    
    public static void writeDefaultConfig(final File file) {
        try (final FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("{\n  \"key\": \"value\"\n}");
            System.out.println("Default config written to the file.");
        }
        catch (final IOException ex) {
            System.out.println("An error occurred while writing default config to the file.");
            ex.printStackTrace();
        }
    }
    
    public static void sendchatMessge(final String s) {
        for (int i = 0; i < Manager.combat.size(); i += 11559, i -= 11558) {
            Manager.combat.get(i).sendChatMessage(s);
        }
        for (int j = 0; j < Manager.movement.size(); j -= 24507, j += 24508) {
            Manager.movement.get(j).sendChatMessage(s);
        }
        for (int k = 0; k < Manager.render.size(); k -= 30291, k += 30292) {
            Manager.render.get(k).sendChatMessage(s);
        }
    }
    
    public void keyPressed(final int n) {
    }
    
    public static void sendchatMessge2(final String s) {
        sendchatMessge(s);
    }
    
    static {
        Manager.VERSION = "1.15";
        Manager.combat = new ArrayList<Module>();
        Manager.movement = new ArrayList<Module>();
        Manager.render = new ArrayList<Module>();
        Manager.other = new ArrayList<Module>();
        Manager.hud = new ArrayList<Module>();
        Manager.settingCombat = new ArrayList<Screen>();
        Manager.settingMovement = new ArrayList<Screen>();
        Manager.settingRender = new ArrayList<Screen>();
        Manager.settingOther = new ArrayList<Screen>();
        Manager.settingHud = new ArrayList<Screen>();
        Manager.CONFIG_FILE_NAME = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "config.json";
    }
}

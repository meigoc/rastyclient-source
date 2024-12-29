// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.fonts;

public final class Fonts
{
    public static GlyphPageFontRenderer mntsb20;
    public static GlyphPageFontRenderer mntsb15;
    public static GlyphPageFontRenderer mntsb30;
    public static GlyphPageFontRenderer mntsb12;
    public static GlyphPageFontRenderer bold30;
    public static GlyphPageFontRenderer bold18;
    public static GlyphPageFontRenderer bold20;
    public static GlyphPageFontRenderer bold16;
    public static GlyphPageFontRenderer bold22;
    public static GlyphPageFontRenderer bold23;
    public static GlyphPageFontRenderer bold24;
    public static GlyphPageFontRenderer bold25;
    public String end;
    
    public Fonts() {
        this.end = ".ttf";
    }
    
    public static void initAll() {
        try {
            Fonts.mntsb20 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/mntsb.ttf", 20, false, false, false);
            Fonts.mntsb15 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/mntsb.ttf", 15, false, false, false);
            Fonts.mntsb12 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/mntsb.ttf", 12, false, false, false);
            Fonts.mntsb30 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/mntsb.ttf", 30, false, false, false);
            Fonts.bold30 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 30, false, false, false);
            Fonts.bold20 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 16, false, false, false);
            Fonts.bold18 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 18, false, false, false);
            Fonts.bold16 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 16, false, false, false);
            Fonts.bold22 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 16, false, false, false);
            Fonts.bold23 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 16, false, false, false);
            Fonts.bold24 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 16, false, false, false);
            Fonts.bold25 = GlyphPageFontRenderer.create("/assets/minecraft/rastypaster/fonts/bold.otf", 16, false, false, false);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}

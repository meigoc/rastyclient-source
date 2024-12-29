// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.rendered;

import java.io.IOException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import me.rastypaster.Manager;
import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL30;
import com.mojang.blaze3d.platform.GlStateManager;

public class Shader implements Wrapper
{
    public static final int VERTEX_SHADER;
    public int programId;
    
    public Shader(final String s) {
        final int program = GlStateManager.createProgram();
        try {
            final int shader = GlStateManager.createShader(35632);
            GlStateManager.shaderSource(shader, getShaderSource(s));
            GlStateManager.compileShader(shader);
            if (GL30.glGetShaderi(shader, 35713) == 0) {
                GlStateManager.deleteShader(shader);
                System.err.println("Fragment shader couldn't compile. It has been deleted.");
            }
            GlStateManager.attachShader(program, Shader.VERTEX_SHADER);
            GlStateManager.attachShader(program, shader);
            GlStateManager.linkProgram(program);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        this.programId = program;
    }
    
    public void load() {
        GlStateManager.useProgram(this.programId);
    }
    
    public void unload() {
        GlStateManager.useProgram(0);
    }
    
    public int getUniform(final String s) {
        return GL30.glGetUniformLocation(this.programId, (CharSequence)s);
    }
    
    public void setUniformf(final String s, final float[] array) {
        final int glGetUniformLocation = GL30.glGetUniformLocation(this.programId, (CharSequence)s);
        switch (array.length) {
            case 1: {
                GL30.glUniform1f(glGetUniformLocation, array[0]);
                break;
            }
            case 2: {
                GL30.glUniform2f(glGetUniformLocation, array[0], array[1]);
                break;
            }
            case 3: {
                GL30.glUniform3f(glGetUniformLocation, array[0], array[1], array[2]);
                break;
            }
            case 4: {
                GL30.glUniform4f(glGetUniformLocation, array[0], array[1], array[2], array[3]);
                break;
            }
        }
    }
    
    public void setUniformi(final String s, final int[] array) {
        final int glGetUniformLocation = GL30.glGetUniformLocation(this.programId, (CharSequence)s);
        switch (array.length) {
            case 1: {
                GL30.glUniform1i(glGetUniformLocation, array[0]);
                break;
            }
            case 2: {
                GL30.glUniform2i(glGetUniformLocation, array[0], array[1]);
                break;
            }
            case 3: {
                GL30.glUniform3i(glGetUniformLocation, array[0], array[1], array[2]);
                break;
            }
            case 4: {
                GL30.glUniform4i(glGetUniformLocation, array[0], array[1], array[2], array[3]);
                break;
            }
        }
    }
    
    public void setUniformfb(final String s, final FloatBuffer floatBuffer) {
        GL30.glUniform1fv(GL30.glGetUniformLocation(this.programId, (CharSequence)s), floatBuffer);
    }
    
    public static void draw() {
        draw(0.0, 0.0, Shader.WINDOW.getScaledWidth(), Shader.WINDOW.getScaledHeight());
    }
    
    public static void draw(final double n, final double n2, final double n3, final double n4) {
        GL30.glBegin(7);
        GL30.glTexCoord2d(0.0, 0.0);
        GL30.glVertex2d(n, n2);
        GL30.glTexCoord2d(0.0, 1.0);
        GL30.glVertex2d(n, n2 + n4);
        GL30.glTexCoord2d(1.0, 1.0);
        GL30.glVertex2d(n + n3, n2 + n4);
        GL30.glTexCoord2d(1.0, 0.0);
        GL30.glVertex2d(n + n3, n2);
        GL30.glEnd();
    }
    
    public static String getShaderSource(final String s) {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Manager.class.getResourceAsStream("/assets/minecraft/rasty/shader/" + s)));
        final String s2 = bufferedReader.lines().filter(Shader::lambda$getShaderSource$0).map((Function<? super String, ?>)Shader::lambda$getShaderSource$1).collect((Collector<? super Object, ?, String>)Collectors.joining("\n"));
        try {
            bufferedReader.close();
        }
        catch (final IOException ex) {}
        return s2;
    }
    
    public static String lambda$getShaderSource$1(String s) {
        final String s2 = s;
        s = "\t";
        return s2;
    }
    
    public static boolean lambda$getShaderSource$0(final String s) {
        return !s.isEmpty();
    }
    
    static {
        GlStateManager.shaderSource(VERTEX_SHADER = GlStateManager.createShader(35633), getShaderSource("vertex.vert"));
        GlStateManager.compileShader(Shader.VERTEX_SHADER);
    }
}

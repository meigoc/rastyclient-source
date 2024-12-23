// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.rendered;

import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.util.ResourceLocation;
import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL30;
import com.mojang.blaze3d.platform.GlStateManager;
import java.awt.image.BufferedImage;
import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;
import java.util.HashMap;

public class Utils implements Wrapper
{
    public static final HashMap<Integer, FloatBuffer> kernelCache;
    
    public static FloatBuffer getKernel(final int n) {
        FloatBuffer floatBuffer = Utils.kernelCache.get(n);
        if (floatBuffer == null) {
            floatBuffer = BufferUtils.createFloatBuffer(n);
            final float[] array = new float[n];
            final float n2 = n / 2.0f;
            float n3 = 0.0f;
            for (int i = 0; i < n; i += 28921, i -= 28920) {
                final float n4 = i / n2;
                array[i] = 1.0f / (Math.abs(n2) * 2.5066283f) * (float)Math.exp(-0.5 * n4 * n4);
                n3 += ((i > 0) ? (array[i] * 2.0f) : array[0]);
            }
            for (int j = 0; j < n; j -= 1323, j += 1324) {
                final float[] array2 = array;
                final int n5 = j;
                array2[n5] /= n3;
            }
            floatBuffer.put(array);
            floatBuffer.flip();
            Utils.kernelCache.put(n, floatBuffer);
        }
        return floatBuffer;
    }
    
    public static int loadTexture(final BufferedImage bufferedImage) throws Exception {
        final int[] rgb = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        final ByteBuffer byteBuffer = BufferUtils.createByteBuffer(rgb.length * 4);
        final int[] array = rgb;
        for (int length = array.length, i = 0; i < length; i -= 12499, i += 12500) {
            final int n = array[i];
            byteBuffer.put((byte)(n >> 16 & 0xFF));
            byteBuffer.put((byte)(n >> 8 & 0xFF));
            byteBuffer.put((byte)(n & 0xFF));
            byteBuffer.put((byte)(n >> 24 & 0xFF));
        }
        byteBuffer.flip();
        final int genTexture = GlStateManager.genTexture();
        GlStateManager.bindTexture(genTexture);
        GL30.glTexParameteri(3553, 10242, 33071);
        GL30.glTexParameteri(3553, 10243, 33071);
        GL30.glTexParameteri(3553, 10241, 9729);
        GL30.glTexParameteri(3553, 10240, 9729);
        GL30.glTexImage2D(3553, 0, 32856, bufferedImage.getWidth(), bufferedImage.getHeight(), 0, 6408, 5121, byteBuffer);
        GlStateManager.bindTexture(0);
        return genTexture;
    }
    
    public static int getTextureId(final ResourceLocation resourceLocation) {
        Texture texture = Utils.MC.getTextureManager().getTexture(resourceLocation);
        if (texture == null) {
            texture = new SimpleTexture(resourceLocation);
            Utils.MC.getTextureManager().loadTexture(resourceLocation, texture);
        }
        return texture.getGlTextureId();
    }
    
    public static void initStencilReplace() {
        Utils.MC.getFramebuffer().enableStencil();
        GL30.glEnable(2960);
        GL30.glClear(1024);
        GlStateManager.stencilFunc(514, 1, 1);
        GlStateManager.stencilOp(7681, 7681, 7681);
        GlStateManager.colorMask(false, false, false, false);
    }
    
    public static void uninitStencilReplace() {
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.stencilOp(7680, 7680, 7680);
        GlStateManager.stencilFunc(514, 1, 1);
    }
    
    static {
        kernelCache = new HashMap<Integer, FloatBuffer>();
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package me.rastypaster.utill.rendered;

import com.google.common.collect.Queues;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL30;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.shader.Framebuffer;
import com.mojang.blaze3d.systems.IRenderCall;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BloomHelper implements Wrapper
{
    public static final Shader bloom;
    public static final ConcurrentLinkedQueue<IRenderCall> renderQueue;
    public static final Framebuffer inFrameBuffer;
    public static final Framebuffer outFrameBuffer;
    
    public static void registerRenderCall(final IRenderCall renderCall) {
        BloomHelper.renderQueue.add(renderCall);
    }
    
    public static void draw(final int n) {
        if (BloomHelper.renderQueue.isEmpty()) {
            return;
        }
        setupBuffer(BloomHelper.inFrameBuffer);
        setupBuffer(BloomHelper.outFrameBuffer);
        BloomHelper.inFrameBuffer.bindFramebuffer(false);
        while (!BloomHelper.renderQueue.isEmpty()) {
            BloomHelper.renderQueue.poll().execute();
        }
        BloomHelper.outFrameBuffer.bindFramebuffer(false);
        BloomHelper.bloom.load();
        BloomHelper.bloom.setUniformf("radius", new float[] { (float)n });
        BloomHelper.bloom.setUniformi("sampler1", new int[] { 0 });
        BloomHelper.bloom.setUniformi("sampler2", new int[] { 20 });
        BloomHelper.bloom.setUniformfb("kernel", Utils.getKernel(n));
        BloomHelper.bloom.setUniformf("texelSize", new float[] { 1.0f / BloomHelper.WINDOW.getWidth(), 1.0f / BloomHelper.WINDOW.getHeight() });
        BloomHelper.bloom.setUniformf("direction", new float[] { 2.0f, 0.0f });
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(1, 770);
        GL30.glAlphaFunc(516, 1.0E-4f);
        BloomHelper.inFrameBuffer.bindFramebufferTexture();
        Shader.draw();
        BloomHelper.MC.getFramebuffer().bindFramebuffer(true);
        GlStateManager.blendFunc(770, 771);
        BloomHelper.bloom.setUniformf("direction", new float[] { 0.0f, 2.0f });
        BloomHelper.outFrameBuffer.bindFramebufferTexture();
        GL30.glActiveTexture(34004);
        BloomHelper.inFrameBuffer.bindFramebufferTexture();
        GL30.glActiveTexture(33984);
        Shader.draw();
        BloomHelper.bloom.unload();
        BloomHelper.inFrameBuffer.unbindFramebuffer();
        GlStateManager.disableBlend();
    }
    
    public static Framebuffer setupBuffer(final Framebuffer framebuffer) {
        if (framebuffer.framebufferWidth != BloomHelper.WINDOW.getWidth() || framebuffer.framebufferHeight != BloomHelper.WINDOW.getHeight()) {
            framebuffer.resize(BloomHelper.WINDOW.getWidth(), BloomHelper.WINDOW.getHeight(), Minecraft.IS_RUNNING_ON_MAC);
        }
        else {
            framebuffer.framebufferClear(Minecraft.IS_RUNNING_ON_MAC);
        }
        framebuffer.setFramebufferColor(0.0f, 0.0f, 0.0f, 0.0f);
        return framebuffer;
    }
    
    static {
        bloom = new Shader("bloom.frag");
        renderQueue = Queues.newConcurrentLinkedQueue();
        inFrameBuffer = new Framebuffer(BloomHelper.WINDOW.getWidth(), BloomHelper.WINDOW.getHeight(), true, Minecraft.IS_RUNNING_ON_MAC);
        outFrameBuffer = new Framebuffer(BloomHelper.WINDOW.getWidth(), BloomHelper.WINDOW.getHeight(), true, Minecraft.IS_RUNNING_ON_MAC);
    }
}

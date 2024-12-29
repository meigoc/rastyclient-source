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

public class BlurHelper implements Wrapper
{
    public static final Shader blur;
    public static final ConcurrentLinkedQueue<IRenderCall> renderQueue;
    public static final Framebuffer inFrameBuffer;
    public static final Framebuffer outFrameBuffer;
    
    public static void registerRenderCall(final IRenderCall renderCall) {
        BlurHelper.renderQueue.add(renderCall);
    }
    
    public static void draw(final int n) {
        if (BlurHelper.renderQueue.isEmpty()) {
            return;
        }
        setupBuffer(BlurHelper.inFrameBuffer);
        setupBuffer(BlurHelper.outFrameBuffer);
        BlurHelper.inFrameBuffer.bindFramebuffer(false);
        while (!BlurHelper.renderQueue.isEmpty()) {
            BlurHelper.renderQueue.poll().execute();
        }
        BlurHelper.outFrameBuffer.bindFramebuffer(false);
        BlurHelper.blur.load();
        BlurHelper.blur.setUniformf("radius", new float[] { (float)n });
        BlurHelper.blur.setUniformi("sampler1", new int[] { 0 });
        BlurHelper.blur.setUniformi("sampler2", new int[] { 20 });
        BlurHelper.blur.setUniformfb("kernel", Utils.getKernel(n));
        BlurHelper.blur.setUniformf("texelSize", new float[] { 1.0f / BlurHelper.WINDOW.getWidth(), 1.0f / BlurHelper.WINDOW.getHeight() });
        BlurHelper.blur.setUniformf("direction", new float[] { 2.0f, 0.0f });
        GlStateManager.disableBlend();
        GlStateManager.blendFuncSeparate(770, 771, 1, 0);
        BlurHelper.MC.getFramebuffer().bindFramebufferTexture();
        Shader.draw();
        BlurHelper.MC.getFramebuffer().bindFramebuffer(false);
        BlurHelper.blur.setUniformf("direction", new float[] { 0.0f, 2.0f });
        BlurHelper.outFrameBuffer.bindFramebufferTexture();
        GL30.glActiveTexture(34004);
        BlurHelper.inFrameBuffer.bindFramebufferTexture();
        GL30.glActiveTexture(33984);
        Shader.draw();
        BlurHelper.blur.unload();
        BlurHelper.inFrameBuffer.unbindFramebufferTexture();
        GlStateManager.disableBlend();
    }
    
    public static Framebuffer setupBuffer(final Framebuffer framebuffer) {
        if (framebuffer.framebufferWidth != (int)(BlurHelper.WINDOW.getWidth() / 2.0) || framebuffer.framebufferHeight != (int)(BlurHelper.WINDOW.getHeight() / 2.0)) {
            framebuffer.resize((int)(BlurHelper.WINDOW.getWidth() / 2.0), (int)(BlurHelper.WINDOW.getHeight() / 2.0), Minecraft.IS_RUNNING_ON_MAC);
        }
        else {
            framebuffer.framebufferClear(Minecraft.IS_RUNNING_ON_MAC);
        }
        return framebuffer;
    }
    
    static {
        blur = new Shader("blur.frag");
        renderQueue = Queues.newConcurrentLinkedQueue();
        inFrameBuffer = new Framebuffer((int)(BlurHelper.WINDOW.getWidth() / 2.0), (int)(BlurHelper.WINDOW.getHeight() / 2.0), true, Minecraft.IS_RUNNING_ON_MAC);
        outFrameBuffer = new Framebuffer((int)(BlurHelper.WINDOW.getWidth() / 2.0), (int)(BlurHelper.WINDOW.getHeight() / 2.0), true, Minecraft.IS_RUNNING_ON_MAC);
    }
}

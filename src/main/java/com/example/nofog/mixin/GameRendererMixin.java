package com.example.nofog.mixin;

import net.minecraft.client.render.GameRenderer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    // Vanilla's EntityRenderer.setupFog(int, float). Runs every frame; we turn fog off after it configures it.
    @Inject(method = "renderFog", at = @At("TAIL"))
    private void nofog$disableFog(int i, float tickDelta, CallbackInfo ci) {
        GL11.glDisable(GL11.GL_FOG);
    }
}

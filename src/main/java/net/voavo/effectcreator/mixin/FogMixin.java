package net.voavo.effectcreator.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.voavo.effectcreator.effects.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(BackgroundRenderer.class)
public abstract class FogMixin {

    @Inject(method = "applyFog", at = @At(value="HEAD"), cancellable = true)
    private static void updateFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, CallbackInfo ci) {

        Entity entity = camera.getFocusedEntity();

        if(entity instanceof PlayerEntity player && player.world.isClient() && player.hasStatusEffect(ModEffects.ORANGEFOG)){

            float fogEnd = 9;
            float fogStart = 0.0f;

            RenderSystem.setShaderFogColor(1f,0.5f,0,0.8f);
            RenderSystem.setShaderFogStart(fogStart);
            RenderSystem.setShaderFogEnd(fogEnd);

            ci.cancel();
        }
    }
}

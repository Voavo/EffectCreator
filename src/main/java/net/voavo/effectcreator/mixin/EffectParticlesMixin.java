package net.voavo.effectcreator.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.voavo.effectcreator.effects.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(LivingEntity.class)
public abstract class EffectParticlesMixin {

    @Inject(method = "tickStatusEffects()V", at = @At(value="INVOKE", target = "Lnet/minecraft/world/World;addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)V",ordinal = 0),cancellable = true)
    public void hideParticles(CallbackInfo ci) {

        LivingEntity entity = ((LivingEntity) (Object) this);
        if(entity instanceof PlayerEntity player && player.world.isClient() && (player.hasStatusEffect(ModEffects.ORANGEFOG)))
            ci.cancel();
    }
}

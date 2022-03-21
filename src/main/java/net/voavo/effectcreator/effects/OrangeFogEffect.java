package net.voavo.effectcreator.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class OrangeFogEffect extends StatusEffect {

    public OrangeFogEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.BENEFICIAL, 0xC96416);
    }
}

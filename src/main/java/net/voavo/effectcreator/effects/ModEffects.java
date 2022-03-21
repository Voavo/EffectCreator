package net.voavo.effectcreator.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.voavo.effectcreator.EffectCreator;

public class ModEffects {

    public static final StatusEffect ORANGEFOG = registerEffect("orangefog",new OrangeFogEffect(null,0));

    private static StatusEffect registerEffect(String name, StatusEffect effect){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(EffectCreator.MOD_ID,name), effect);
    }

    public static void registerModEffects(){
        System.out.println("Registered mod effects "+ EffectCreator.MOD_ID);
    }
}

package dev.broman.fabricenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

/**
 * @author broman (ryan@broman.dev)
 * @since 2021-01-07
 */
public class PoisonedEdge extends Enchantment {

  public PoisonedEdge() {
    super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  }

  public static String getIdentifier() {
    return "poisoned-edge";
  }

  @Override
  public int getMinPower(int level) {
    return 10 * level;
  }

  @Override
  public int getMaxLevel() {
    return 3;
  }

  @Override
  public void onTargetDamaged(LivingEntity user, Entity target, int level) {
    if (target instanceof LivingEntity) {
      ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 2 * level, level - 1));
    }

    super.onTargetDamaged(user, target, level);
  }
}

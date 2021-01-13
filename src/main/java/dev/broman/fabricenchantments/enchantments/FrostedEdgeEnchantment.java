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
public class FrostedEdgeEnchantment extends Enchantment {

  public FrostedEdgeEnchantment() {
    super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  }

  public static String getIdentifier() {
    return "frosted-edge";
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
      ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20 * 2 * level, level - 1));
      ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 2 * level, level - 1));
    }

    super.onTargetDamaged(user, target, level);
  }
}

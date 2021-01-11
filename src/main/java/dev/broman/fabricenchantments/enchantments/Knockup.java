package dev.broman.fabricenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

/**
 * @author broman (ryan@broman.dev)
 * @since 20201-01-10
 */
public class Knockup extends Enchantment {
  public Knockup() {
    super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  }

  public static String getIdentifier() {
    return "knockup";
  }

  @Override
  public int getMinPower(int level) {
    return 10 * level;
  }

  @Override
  public int getMaxLevel() {
    return 5;
  }

  @Override
  public void onTargetDamaged(LivingEntity user, Entity target, int level) {
    if (target instanceof LivingEntity) {
      target.addVelocity(0, level * .1, 0);
    }

    super.onTargetDamaged(user, target, level);
  }
}

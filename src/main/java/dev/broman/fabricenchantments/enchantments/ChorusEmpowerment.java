package dev.broman.fabricenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
  * @author broman (ryan@broman.dev)
  * @since 2021-01-11
  */
public class ChorusEmpowerment extends Enchantment {
  public ChorusEmpowerment() {
    super(Enchantment.Rarity.COMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
  }

  public static String getIdentifier() {
    return "chorus-empowerment";
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
  public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
    if (attacker instanceof LivingEntity && ((LivingEntity) attacker).getRandom().nextInt(getMaxLevel() * 2 + 1) < level) {
      teleportPlayerChorus((LivingEntity) attacker);
    }
  }

  /**
   * Teleports a player with the same logic of a chorus fruit consumption
   *
   * @param target The player to teleport
   */
  private void teleportPlayerChorus(LivingEntity target) {
    World world = target.world;
    if (!world.isClient) {
      double d = target.getX();
      double e = target.getY();
      double f = target.getZ();

      for (int i = 0; i < 16; ++i) {
        double g = target.getX() + (target.getRandom().nextDouble() - 0.5D) * 16.0D;
        double h = MathHelper.clamp(target.getY() + (double) (target.getRandom().nextInt(16) - 8), 0.0D, world.getDimensionHeight() - 1);
        double j = target.getZ() + (target.getRandom().nextDouble() - 0.5D) * 16.0D;
        if (target.hasVehicle()) {
          target.stopRiding();
        }

        if (target.teleport(g, h, j, true)) {
          SoundEvent soundEvent = target instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
          world.playSound(null, d, e, f, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
          target.playSound(soundEvent, 1.0F, 1.0F);
          break;
        }
      }
    }
  }
}

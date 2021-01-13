package dev.broman.fabricenchantments.enchantments;

import dev.broman.fabricenchantments.FabricEnchantments;
import net.minecraft.client.options.KeyBinding;
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
public class EndBlessing extends Enchantment {
  public EndBlessing() {
    super(Enchantment.Rarity.COMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST});
  }

  public static String getIdentifier() {
    return "ender-blessing";
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
      double targetX = target.getX();
      double targetY = target.getY();
      double targetZ = target.getZ();

      for (int i = 0; i < 16; ++i) {
        double candidateX = targetX + (target.getRandom().nextDouble() - 0.5D) * 16.0D;
        double candidateY = MathHelper.clamp(targetY + (double) (target.getRandom().nextInt(16) - 8), 0.0D, world.getDimensionHeight() - 1);
        double candidateZ = targetZ + (target.getRandom().nextDouble() - 0.5D) * 16.0D;
        if (target.hasVehicle()) {
          target.stopRiding();
        }

        if (target.teleport(candidateX, candidateY, candidateZ, true)) {
          SoundEvent soundEvent = target instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
          world.playSound(null, targetX, targetY, targetZ, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
          target.playSound(soundEvent, 1.0F, 1.0F);
          break;
        }
      }
    }
  }
}

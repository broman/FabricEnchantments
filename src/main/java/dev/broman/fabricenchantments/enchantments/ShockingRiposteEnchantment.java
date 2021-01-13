package dev.broman.fabricenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

/**
  * @author broman (ryan@broman.dev)
  * @since 2021-01-10
  */
public class ShockingRiposteEnchantment extends Enchantment {
  public ShockingRiposteEnchantment() {
    super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.CHEST});
  }

  public static String getIdentifier() {
    return "shock";
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
  public int getProtectionAmount(int level, DamageSource source) {
    if(source == DamageSource.LIGHTNING_BOLT) return 300;
    else return super.getProtectionAmount(level, source);
  }

  @Override
  protected boolean canAccept(Enchantment other) {
    return super.canAccept(other) && !(other instanceof EndBlessingEnchantment);
  }

  @Override
  public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
    if (attacker instanceof LivingEntity) {
      Random rng = ((LivingEntity) attacker).getRandom();
      if (attacker.world.isSkyVisible(new BlockPos(attacker.getPos())) && rng.nextInt(getMaxLevel() * 2 + 1) < level + 2) {
        LightningEntity bolt = EntityType.LIGHTNING_BOLT.create(attacker.world);
        if (bolt != null) {
          bolt.move(MovementType.SELF, attacker.getPos());
          bolt.setChanneler(attacker instanceof ServerPlayerEntity ? (ServerPlayerEntity) attacker : null);
          attacker.world.spawnEntity(bolt);
        }
      }
    }
  }
}

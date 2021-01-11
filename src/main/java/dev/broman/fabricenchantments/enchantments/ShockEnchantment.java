package dev.broman.fabricenchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

import java.util.Random;


public class ShockEnchantment extends Enchantment {
  public ShockEnchantment() {
    super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[]{
        EquipmentSlot.CHEST,
        EquipmentSlot.FEET,
        EquipmentSlot.HEAD,
        EquipmentSlot.LEGS
    });
  }

  public static String getIdentifier() {
    return "shock";
  }

  @Override
  public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
    if (attacker instanceof LivingEntity) {
      Random rng = ((LivingEntity) attacker).getRandom();
      if (attacker.world.isSkyVisible(new BlockPos(attacker.getPos())) && rng.nextInt(1) < 0.1 + (.1 * level - 1)) {
        LightningEntity bolt = EntityType.LIGHTNING_BOLT.create(attacker.world);
        if (bolt != null) {
          bolt.move(MovementType.SELF, attacker.getPos());
          bolt.setChanneler(attacker instanceof ServerPlayerEntity ? (ServerPlayerEntity) attacker : null);
        }
        attacker.world.spawnEntity(bolt);
      }
    }
  }
}

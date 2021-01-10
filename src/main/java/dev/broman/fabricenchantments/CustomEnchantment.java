package dev.broman.fabricenchantments;

import dev.broman.fabricenchantments.enchantments.IEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/**
  * @author broman (ryan@broman.dev)
  * @since 2021-01-07
  */
public abstract class CustomEnchantment extends Enchantment implements IEnchantment {
    protected CustomEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
}

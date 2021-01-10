package dev.broman.fabricenchantments.enchantments;

import dev.broman.fabricenchantments.CustomEnchantment;
import dev.broman.fabricenchantments.FabricEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;

/**
 * @author broman (ryan@broman.dev)
 * @since 2021-01-10
 */
public class Criticality extends CustomEnchantment {
    public Criticality() {
        super(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
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
        if(target instanceof LivingEntity) {
            if(FabricEnchantments.RANDOM.nextInt(getMaxLevel() + 1)  > level) {
                target.damage(DamageSource.MAGIC, (float) (level / 2.0));
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    public String getIdentifier() {
        return "criticality";
    }
}

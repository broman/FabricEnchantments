package dev.broman.fabricenchantments;

import dev.broman.fabricenchantments.enchantments.FrostedEdge;
import dev.broman.fabricenchantments.enchantments.PoisonedEdge;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FabricEnchantments implements ModInitializer {
	// This code runs as soon as Minecraft is in a mod-load-ready state.
	// However, some things (like resources) may still be uninitialized.
	// Proceed with mild caution.
	private static final Enchantment FROST = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("fabricenchantments", "frosted-edge"),
			new FrostedEdge()
	);

	private static final Enchantment POISON = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("fabricenchantments", "poisoned-edge"),
			new PoisonedEdge()
	);

	public void onInitialize() {

	}
}

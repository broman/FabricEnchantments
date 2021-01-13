package dev.broman.fabricenchantments;

import dev.broman.fabricenchantments.enchantments.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static net.minecraft.util.registry.Registry.ENCHANTMENT;
import static net.minecraft.util.registry.Registry.register;

/**
 * @author broman (ryan@broman.dev)
 * @since 2021-01-07
 */
public class FabricEnchantments implements ModInitializer {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final Random RANDOM = new Random();

  private static final String NAMESPACE = "fabricenchantments";

  public static void info(String msg) {
    LOGGER.info(NAMESPACE + ": " + msg);
  }

  public void onInitialize() {
    info("Initializing!");
    register(ENCHANTMENT, new Identifier(NAMESPACE, CriticalityEnchantment.getIdentifier()), new CriticalityEnchantment());
    register(ENCHANTMENT, new Identifier(NAMESPACE, FrostedEdgeEnchantment.getIdentifier()), new FrostedEdgeEnchantment());
    register(ENCHANTMENT, new Identifier(NAMESPACE, KnockupEnchantment.getIdentifier()), new KnockupEnchantment());
    register(ENCHANTMENT, new Identifier(NAMESPACE, PoisonedEdgeEnchantment.getIdentifier()), new PoisonedEdgeEnchantment());
    register(ENCHANTMENT, new Identifier(NAMESPACE, EndBlessingEnchantment.getIdentifier()), new EndBlessingEnchantment());
    register(ENCHANTMENT, new Identifier(NAMESPACE, ShockingRiposteEnchantment.getIdentifier()), new ShockingRiposteEnchantment());

    info("All enchantments registered!");
  }
}

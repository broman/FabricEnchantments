package dev.broman.fabricenchantments;

import dev.broman.fabricenchantments.enchantments.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * @author broman (ryan@broman.dev)
 * @since 2021-01-07
 */
public class FabricEnchantments implements ModInitializer {
  public static final Logger LOGGER = LogManager.getLogger();
  public static final Random RANDOM = new Random();

  private static final String NAMESPACE = "fabricenchantments";

  public void onInitialize() {
    info("Initializing!");
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, CriticalityEnchantment.getIdentifier()), new CriticalityEnchantment());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, FrostedEdgeEnchantment.getIdentifier()), new FrostedEdgeEnchantment());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, KnockupEnchantment.getIdentifier()), new KnockupEnchantment());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, PoisonedEdgeEnchantment.getIdentifier()), new PoisonedEdgeEnchantment());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, EndBlessingEnchantment.getIdentifier()), new EndBlessingEnchantment());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, ShockingRiposteEnchantment.getIdentifier()), new ShockingRiposteEnchantment());

    info("All enchantments registered!");
  }

  public static void info(String msg) {
    LOGGER.info(NAMESPACE + ": " + msg);
  }

  public static void info(Object msg) {
    LOGGER.info(NAMESPACE + ": " + msg);
  }

  public void warn(String msg) {
    LOGGER.warn(NAMESPACE + ": " + msg);
  }

  public void error(String msg) {
    LOGGER.error(NAMESPACE + ": " + msg);
  }

  public void fatal(String msg) {
    LOGGER.fatal(NAMESPACE + ": " + msg);
  }

  public void debug(String msg) {
    LOGGER.debug(NAMESPACE + ": " + msg);
  }

  public void debug(Object msg) {
    LOGGER.debug(msg);
  }
}

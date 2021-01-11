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
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, Criticality.getIdentifier()), new Criticality());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, FrostedEdge.getIdentifier()), new FrostedEdge());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, Knockup.getIdentifier()), new Knockup());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, PoisonedEdge.getIdentifier()), new PoisonedEdge());
    Registry.register(Registry.ENCHANTMENT, new Identifier(NAMESPACE, ShockEnchantment.getIdentifier()), new ShockEnchantment());
    info("All enchantments registered!");
  }

  public void info(String msg) {
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

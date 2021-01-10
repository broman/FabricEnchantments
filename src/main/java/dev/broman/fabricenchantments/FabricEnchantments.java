package dev.broman.fabricenchantments;

import dev.broman.fabricenchantments.enchantments.FrostedEdge;
import dev.broman.fabricenchantments.enchantments.PoisonedEdge;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
  * @author broman (ryan@broman.dev)
  * @since 2021-01-07
  */
public class FabricEnchantments implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();

	public static final Random RANDOM = new Random();

	public void onInitialize() {
		LOGGER.info("Initializing!");
		ScanResult result = new ClassGraph()
				.whitelistPackages("dev.broman.fabricenchantments.enchantments")
				.scan();
		ClassInfoList list = result.getAllClasses();

		for(ClassInfo info: list) {
			try {
				Class<? extends CustomEnchantment> loaded = info.loadClass(CustomEnchantment.class);
				CustomEnchantment enchantment = loaded.getConstructor().newInstance();
				Registry.register(
						Registry.ENCHANTMENT,
						new Identifier("fabricenchantments", enchantment.getIdentifier()),
						enchantment
				);
				LOGGER.info("Registered " + enchantment.getIdentifier());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

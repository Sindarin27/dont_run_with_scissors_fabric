package sindarin.dontrunwithscissors;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.advancement.CriterionRegistry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DontRunWithScissors implements ModInitializer {
    public static final String MOD_ID = "dont-run-with-scissors";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final Identifier RAN_WITH_SCISSORS = new Identifier(MOD_ID, "ran_with_scissors");
	public static final RanWithScissorsCriterion RAN_WITH_SCISSORS_CRITERION = new RanWithScissorsCriterion(RAN_WITH_SCISSORS);
	public static       DontRunWithScissorsConfig config;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        CriterionRegistry.register(RAN_WITH_SCISSORS_CRITERION);
		AutoConfig.register(DontRunWithScissorsConfig.class, JanksonConfigSerializer::new);
		config                      = AutoConfig.getConfigHolder(DontRunWithScissorsConfig.class)
												.getConfig();
		LOGGER.info("Initialized! Stay safe!");
	}
}

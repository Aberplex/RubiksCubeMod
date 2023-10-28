package net.aredd.firstmod;

import net.aredd.firstmod.block.ModBlocks;
import net.aredd.firstmod.item.ModItemGroups;
import net.aredd.firstmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	public static final	String MOD_ID = "firstmod";
    public static final Logger LOGGER = LoggerFactory.getLogger("firstmod");

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
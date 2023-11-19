package net.aredd.firstmod;

import net.aredd.firstmod.block.ModBlocks;
import net.aredd.firstmod.datagen.ModWorldGenerator;
import net.aredd.firstmod.entity.ModEntities;
import net.aredd.firstmod.entity.custom.CubeGolemEntity;
import net.aredd.firstmod.item.ModItemGroups;
import net.aredd.firstmod.item.ModItems;
import net.aredd.firstmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.mob.MobEntity;
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

		FabricDefaultAttributeRegistry.register(ModEntities.CUBE_GOLEM, CubeGolemEntity.createCubeGolemAttributes());

		ModWorldGeneration.generateModWorldGen();
	}
}
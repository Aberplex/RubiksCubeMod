package net.aredd.firstmod.block;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.block.custom.CubeCraftStationBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CUBE_CRAFTING_STATION = registerBlock("cube_craft_station",
            new CubeCraftStationBlock(FabricBlockSettings.create().nonOpaque().strength(3, 10).requiresTool().mapColor(MapColor.LIGHT_BLUE)));
    public static final Block CUBE_ARTIFACT = registerBlock("cube_artifact",
            new CubeCraftStationBlock(FabricBlockSettings.create().nonOpaque().strength(3, 10).requiresTool().mapColor(MapColor.LIGHT_BLUE)));



    private static Block registerBlock(String name, Block block)  {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        FirstMod.LOGGER.info("Registering Mod Blocks for " + FirstMod.MOD_ID);
    }
}

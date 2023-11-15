package net.aredd.firstmod.item;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.item.custom.CubeDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBIKS_CUBE = registerItem("rubiks_cube", new Item(new FabricItemSettings()));
    public static final Item BLUE_FRAGMENT = registerItem("blue_fragment", new Item(new FabricItemSettings()));
    public static final Item RED_FRAGMENT = registerItem("red_fragment", new Item(new FabricItemSettings()));
    public static final Item GREEN_FRAGMENT = registerItem("green_fragment", new Item(new FabricItemSettings()));
    public static final Item ORANGE_FRAGMENT = registerItem("orange_fragment", new Item(new FabricItemSettings()));
    public static final Item YELLOW_FRAGMENT = registerItem("yellow_fragment", new Item(new FabricItemSettings()));
    public static final Item WHITE_FRAGMENT = registerItem("white_fragment", new Item(new FabricItemSettings()));

    public static final Item CUBE_DETECTOR = registerItem("cube_detector_2d",
            new CubeDetectorItem(new FabricItemSettings().maxDamage(350)));

    public static final Item CUBE_SWORD = registerItem("cube_sword", new SwordItem(ModToolMaterial.CUBE_TOOLS, 4, .6f, new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER .info("Registering Mod items for " + FirstMod.MOD_ID);
    }
}

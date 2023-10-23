package net.aredd.firstmod.item;

import net.aredd.firstmod.FirstMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBIKS_CUBE);
        entries.add(BLUE_FRAGMENT);
        entries.add(RED_FRAGMENT);
        entries.add(GREEN_FRAGMENT);
        entries.add(ORANGE_FRAGMENT);
        entries.add(YELLOW_FRAGMENT);
        entries.add(WHITE_FRAGMENT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FirstMod.LOGGER .info("Registering Mod items for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}

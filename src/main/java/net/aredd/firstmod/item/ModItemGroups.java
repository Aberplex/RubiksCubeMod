package net.aredd.firstmod.item;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CUBE_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(FirstMod.MOD_ID, "rubiks_cube"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rubiks_cube"))
                    .icon(() -> new ItemStack(ModItems.RUBIKS_CUBE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBIKS_CUBE);
                        entries.add(ModItems.WHITE_FRAGMENT);
                        entries.add(ModItems.BLUE_FRAGMENT);
                        entries.add(ModItems.RED_FRAGMENT);
                        entries.add(ModItems.YELLOW_FRAGMENT);
                        entries.add(ModItems.ORANGE_FRAGMENT);
                        entries.add(ModItems.GREEN_FRAGMENT);

                        entries.add(ModBlocks.CUBE_CRAFTING_STATION);

                        entries.add(ModItems.CUBE_DETECTOR);

                        entries.add(ModBlocks.CUBE_ARTIFACT);

                        entries.add(ModItems.CUBE_SWORD);

                        entries.add(ModItems.CUBE_GOLEM_SPAWN_EGG);

                    }).build());



    public static void registerItemGroups() {
        FirstMod.LOGGER.info("Registering Item Groups for " + FirstMod.MOD_ID);
    }
}

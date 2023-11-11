package net.aredd.firstmod.datagen;

import net.aredd.firstmod.block.ModBlocks;
import net.aredd.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CUBE_CRAFTING_STATION, 1)
                .pattern("rnb")
                .pattern("ycw")
                .pattern("odg")
                .input('b', Items.BLUE_CONCRETE)
                .input('n', Items.NETHERITE_INGOT)
                .input('r', Items.RED_CONCRETE)
                .input('w', Items.WHITE_CONCRETE)
                .input('c', ModItems.RUBIKS_CUBE)
                .input('y', Items.YELLOW_CONCRETE)
                .input('g', Items.GREEN_CONCRETE)
                .input('d', Items.DIAMOND)
                .input('o', Items.ORANGE_CONCRETE)
                .criterion(hasItem(Items.BLUE_CONCRETE), conditionsFromItem(Items.BLUE_CONCRETE))
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.RED_CONCRETE), conditionsFromItem(Items.RED_CONCRETE))
                .criterion(hasItem(Items.WHITE_CONCRETE), conditionsFromItem(Items.WHITE_CONCRETE))
                .criterion(hasItem(ModItems.RUBIKS_CUBE), conditionsFromItem(ModItems.RUBIKS_CUBE))
                .criterion(hasItem(Items.YELLOW_CONCRETE), conditionsFromItem(Items.YELLOW_CONCRETE))
                .criterion(hasItem(Items.GREEN_CONCRETE), conditionsFromItem(Items.GREEN_CONCRETE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .criterion(hasItem(Items.ORANGE_CONCRETE), conditionsFromItem(Items.ORANGE_CONCRETE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.CUBE_CRAFTING_STATION)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBIKS_CUBE,1)
                .input(ModItems.GREEN_FRAGMENT)
                .input(ModItems.BLUE_FRAGMENT)
                .input(ModItems.YELLOW_FRAGMENT)
                .input(ModItems.RED_FRAGMENT)
                .input(ModItems.WHITE_FRAGMENT)
                .input(ModItems.ORANGE_FRAGMENT)
                .criterion(hasItem(ModItems.GREEN_FRAGMENT), conditionsFromItem(ModItems.GREEN_FRAGMENT))
                .criterion(hasItem(ModItems.ORANGE_FRAGMENT), conditionsFromItem(ModItems.ORANGE_FRAGMENT))
                .criterion(hasItem(ModItems.BLUE_FRAGMENT), conditionsFromItem(ModItems.BLUE_FRAGMENT))
                .criterion(hasItem(ModItems.ORANGE_FRAGMENT), conditionsFromItem(ModItems.ORANGE_FRAGMENT))
                .criterion(hasItem(ModItems.RED_FRAGMENT), conditionsFromItem(ModItems.RED_FRAGMENT))
                .criterion(hasItem(ModItems.YELLOW_FRAGMENT), conditionsFromItem(ModItems.YELLOW_FRAGMENT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBIKS_CUBE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_FRAGMENT,1)
                .pattern("ccc")
                .pattern("cbc")
                .pattern("ccc")
                .input('c', Blocks.BLUE_CONCRETE_POWDER)
                .input('b', Items.LAPIS_LAZULI)
                .criterion(hasItem(Blocks.BLUE_CONCRETE_POWDER), conditionsFromItem(Blocks.BLUE_CONCRETE_POWDER))
                .criterion(hasItem(Items.LAPIS_LAZULI), conditionsFromItem(Items.LAPIS_LAZULI))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.BLUE_FRAGMENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RED_FRAGMENT,1)
                .pattern("ccc")
                .pattern("crc")
                .pattern("ccc")
                .input('c', Blocks.RED_CONCRETE_POWDER)
                .input('r', Items.REDSTONE)
                .criterion(hasItem(Blocks.RED_CONCRETE_POWDER), conditionsFromItem(Blocks.RED_CONCRETE_POWDER))
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RED_FRAGMENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.YELLOW_FRAGMENT,1)
                .pattern("ccc")
                .pattern("cyc")
                .pattern("ccc")
                .input('c', Blocks.YELLOW_CONCRETE_POWDER)
                .input('y', Items.GOLD_INGOT)
                .criterion(hasItem(Blocks.YELLOW_CONCRETE_POWDER), conditionsFromItem(Blocks.YELLOW_CONCRETE_POWDER))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.YELLOW_FRAGMENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_FRAGMENT,1)
                .pattern("ccc")
                .pattern("coc")
                .pattern("ccc")
                .input('c', Blocks.ORANGE_CONCRETE_POWDER)
                .input('o', Items.COPPER_INGOT)
                .criterion(hasItem(Blocks.ORANGE_CONCRETE_POWDER), conditionsFromItem(Blocks.ORANGE_CONCRETE_POWDER))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ORANGE_FRAGMENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GREEN_FRAGMENT,1)
                .pattern("ccc")
                .pattern("cgc")
                .pattern("ccc")
                .input('c', Blocks.GREEN_CONCRETE_POWDER)
                .input('g', Items.EMERALD)
                .criterion(hasItem(Blocks.GREEN_CONCRETE_POWDER), conditionsFromItem(Blocks.GREEN_CONCRETE_POWDER))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GREEN_FRAGMENT)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WHITE_FRAGMENT,1)
                .pattern("ccc")
                .pattern("cwc")
                .pattern("ccc")
                .input('c', Blocks.WHITE_CONCRETE_POWDER)
                .input('w', Items.IRON_INGOT)
                .criterion(hasItem(Blocks.WHITE_CONCRETE_POWDER), conditionsFromItem(Blocks.WHITE_CONCRETE_POWDER))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WHITE_FRAGMENT)));
    }
}

package net.aredd.firstmod.datagen;

import net.aredd.firstmod.block.ModBlocks;
import net.aredd.firstmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.CUBE_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.CUBE_ARTIFACT)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES);

    }
}

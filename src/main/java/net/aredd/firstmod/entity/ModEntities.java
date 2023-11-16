package net.aredd.firstmod.entity;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.entity.custom.CubeGolemEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<CubeGolemEntity> CUBE_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FirstMod.MOD_ID, "cube_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());

}

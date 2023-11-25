package net.aredd.firstmod.entity;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.entity.custom.CubeGolemEntity;
import net.aredd.firstmod.entity.custom.SwordProjectileEntity;
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
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CubeGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f,2.43f)).build());

    public static final EntityType<SwordProjectileEntity> SWORD_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FirstMod.MOD_ID, "sword_projectile"),
            FabricEntityTypeBuilder.<SwordProjectileEntity>create(SpawnGroup.MISC, SwordProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build());
}
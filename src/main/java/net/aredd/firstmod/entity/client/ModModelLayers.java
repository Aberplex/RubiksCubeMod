package net.aredd.firstmod.entity.client;

import net.aredd.firstmod.FirstMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer CUBE_GOLEM =
            new EntityModelLayer(new Identifier(FirstMod.MOD_ID, "cube_golem"), "name");
}

package net.aredd.firstmod.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier WOODLAND_MANSION_ID =
            new Identifier("minecraft", "structure/WoodLandMansionGenerator");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {


        });
    }
}

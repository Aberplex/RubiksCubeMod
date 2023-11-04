package net.aredd.firstmod.screen;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.screen.CubeCraftStationScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public abstract class CubeCraftStationScreen
        extends HandledScreen<CubeCraftStationScreenHandler>
        implements RecipeBookProvider {
    private static final Identifier TEXTURE = new Identifier(FirstMod.MOD_ID, "textures/gui/cube_craft_station.png");
    private final RecipeBookWidget recipeBook = new RecipeBookWidget();

    public CubeCraftStationScreen(CubeCraftStationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
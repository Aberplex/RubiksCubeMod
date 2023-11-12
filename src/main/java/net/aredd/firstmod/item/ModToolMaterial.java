package net.aredd.firstmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    CUBE_TOOLS(-1, 2500, 0f, 9, 26,
            () -> Ingredient.ofItems(ModItems.CUBE_SWORD));

    private final int mininglevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final int attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int mininglevel, int itemDurability, float miningSpeed, int attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.mininglevel = mininglevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.mininglevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

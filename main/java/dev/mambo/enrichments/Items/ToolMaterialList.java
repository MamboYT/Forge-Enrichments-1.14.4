package dev.mambo.enrichments.Items;

import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadBase;

import java.util.function.Supplier;

public enum ToolMaterialList implements IItemTier
{
    ENRICHED(3, 250, 8.0F, 3.0F, 18, () -> { return Ingredient.fromItems(ItemList.enriched_ingot);});

    /** The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD) */
    private final int harvestLevel;
    /** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
    private final int maxUses;
    /** The strength of this tool material against blocks which it is effective against. */
    private final float efficiency;
    /** Damage versus entities. */
    private final float attackDamage;
    /** Defines the natural enchantability factor of the material. */
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private ToolMaterialList(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
    {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
    }

    public int getMaxUses()
    {
        return this.maxUses;
    }

    public float getEfficiency()
    {
        return this.efficiency;
    }

    public float getAttackDamage()
    {
        return this.attackDamage;
    }

    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    public int getEnchantability()
    {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial()
    {
        return this.repairMaterial.getValue();
    }
}
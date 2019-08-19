package dev.mambo.enrichments;

import dev.mambo.enrichments.Items.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EnrichmentsItemGroup extends ItemGroup
{
    public EnrichmentsItemGroup()
    {
        super("enrichments");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemList.enriched_ingot);
    }
}

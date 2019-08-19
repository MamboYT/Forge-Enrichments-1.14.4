package dev.mambo.enrichments;

import dev.mambo.enrichments.Items.ArmorMaterialList;
import dev.mambo.enrichments.Items.BlockItemList;
import dev.mambo.enrichments.Items.ItemList;
import dev.mambo.enrichments.Items.ToolMaterialList;
import dev.mambo.enrichments.blocks.BlocksList;
import net.minecraft.advancements.criterion.EntityEquipmentPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.network.play.server.SEntityEquipmentPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.items.wrapper.EntityEquipmentInvWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod("enrichments")
public class Enrichments
{
    public static Enrichments main;
    public static final String MOD_ID = "enrichments";
    private static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ENRICHMENTS_ITEM_GROUP = new EnrichmentsItemGroup();

    public Enrichments()
    {
        main = this;

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    private void clientRegistries(final FMLCommonSetupEvent event)
    {

    }


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {

        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event)
        {
            event.getRegistry().registerAll
            (
                // ITEMS
                ItemList.enriched_ingot = new Item(new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_ingot")),

                ItemList.enriched_sword = new SwordItem(ToolMaterialList.ENRICHED, 3, -2.4f, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_sword")),
                ItemList.enriched_pickaxe = new PickaxeItem(ToolMaterialList.ENRICHED, 1, -2.8f, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_pickaxe")),
                ItemList.enriched_axe = new AxeItem(ToolMaterialList.ENRICHED, 5.0f, -3.0f, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_axe")),
                ItemList.enriched_shovel = new ShovelItem(ToolMaterialList.ENRICHED, 1.5f, -3.0f, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_shovel")),
                ItemList.enriched_hoe = new HoeItem(ToolMaterialList.ENRICHED, 0.0f, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_hoe")),

                ItemList.enriched_helmet = new ArmorItem(ArmorMaterialList.ENRICHED, EquipmentSlotType.HEAD, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_helmet")),
                ItemList.enriched_chestplate = new ArmorItem(ArmorMaterialList.ENRICHED, EquipmentSlotType.CHEST, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_chestplate")),
                ItemList.enriched_leggings = new ArmorItem(ArmorMaterialList.ENRICHED, EquipmentSlotType.LEGS, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_leggings")),
                ItemList.enriched_boots = new ArmorItem(ArmorMaterialList.ENRICHED, EquipmentSlotType.FEET, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(location("enriched_boots")),


                // BLOCKS
                BlockItemList.enriched_block = new BlockItem(BlocksList.enriched_block, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(Objects.requireNonNull(BlocksList.enriched_block.getRegistryName())),
                BlockItemList.enriched_ore = new BlockItem(BlocksList.enriched_ore, new Item.Properties().group(ENRICHMENTS_ITEM_GROUP)).setRegistryName(Objects.requireNonNull(BlocksList.enriched_ore.getRegistryName()))


                    // THINGS THAT NEED TO BE DONE.
                    /*

                    fix armor models,
                    fix ingot from block crafting amount,
                    add smelting recipe for ore to ingot.

                     */

            );
        }


        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event)
        {
            event.getRegistry().registerAll
            (
                BlocksList.enriched_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName("enriched_block"),
                BlocksList.enriched_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName("enriched_ore")
            );
        }

        private static ResourceLocation location(String name)
        {
           return new ResourceLocation(MOD_ID, name);
        }
    }
}

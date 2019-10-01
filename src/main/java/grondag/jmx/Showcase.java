package grondag.jmx;

import java.util.function.Function;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderLayer;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Showcase implements ModInitializer {

    public static String[] TARGETS = {"blue_concrete_powder",
            "blue_concrete",
            "blue_glazed_terracotta",
            "blue_ice",
            "blue_orchid",
            "blue_shulker_box",
            "blue_stained_glass_pane_top",
            "blue_stained_glass",
            "blue_terracotta",
            "blue_wool",
            "bone_block_side",
            "bone_block_top",
            "bookshelf",
            "brain_coral_block",
            "brain_coral_fan",
            "brain_coral",
            "bricks",
            "brown_concrete_powder",
            "brown_concrete",
            "brown_glazed_terracotta",
            "brown_terracotta",
            "brown_wool",
            "bubble_coral_block",
            "carved_pumpkin",
            "chiseled_quartz_block_top",
            "chiseled_quartz_block",
            "chiseled_red_sandstone",
            "chiseled_sandstone",
            "chiseled_stone_bricks",
            "clay",
            "coal_block",
            "coal_ore",
            "coarse_dirt",
            "cobblestone",
            "cracked_stone_bricks",
            "cut_red_sandstone",
            "cut_sandstone",
            "cyan_concrete_powder",
            "cyan_concrete",
            "cyan_glazed_terracotta",
            "cyan_terracotta",
            "cyan_wool",
            "dark_oak_leaves",
            "dark_oak_log_top",
            "dark_oak_log",
            "dark_oak_planks",
            "dark_prismarine",
            "dead_brain_coral_block",
            "dead_bubble_coral_block",
            "dead_fire_coral_block",
            "dead_horn_coral_block",
            "dead_tube_coral_block",
            "diamond_block",
            "diamond_ore",
            "diorite",
            "dirt",
            "emerald_block",
            "emerald_ore",
            "end_stone_bricks",
            "end_stone",
            "fire_coral_block",
            "glowstone",
            "gold_block",
            "gold_ore",
            "granite",
            "gravel",
            "gray_concrete_powder",
            "gray_concrete",
            "gray_glazed_terracotta",
            "gray_wool",
            "green_concrete_powder",
            "green_concrete",
            "green_glazed_terracotta",
            "green_terracotta",
            "green_wool",
            "hay_block_side",
            "hay_block_top",
            "horn_coral_block",
            "iron_block",
            "iron_ore",
            "jack_o_lantern"};
    public static final Function<Block, Item> ITEM_FUNCTION_STANDARD = block -> {
        return new BlockItem(block, new Item.Settings()
                .maxCount(64)
                .group(ItemGroup.BUILDING_BLOCKS));
    };
    
    
    public static Item register(Block block, String name, Function<Block, Item> itemFunc) {
        Identifier id = new Identifier("jmx", name);
        Registry.BLOCK.add(id, block);
        Item result = itemFunc.apply(block);
        Registry.ITEM.add(id, result);
        return result;
    }
    
    @Override
    public void onInitialize() {
        Block multiBlock = new Block(FabricBlockSettings.of(Material.STONE).strength(1, 1).build());
        register(multiBlock, "jmx_multi", ITEM_FUNCTION_STANDARD);
        BlockRenderLayerMap.INSTANCE.putBlock(multiBlock, BlockRenderLayer.CUTOUT);
        
        multiBlock = new Block(FabricBlockSettings.of(Material.STONE).strength(1, 1).build());
        register(multiBlock, "jmx_multi2", ITEM_FUNCTION_STANDARD);
        BlockRenderLayerMap.INSTANCE.putBlock(multiBlock, BlockRenderLayer.CUTOUT);
        
        for(String target : TARGETS) {
            register(new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1, 1).build()), target + "_slab", ITEM_FUNCTION_STANDARD);
            register(new FenceBlock(FabricBlockSettings.of(Material.STONE).strength(1, 1).build()), target + "_fence", ITEM_FUNCTION_STANDARD);
            register(new StairsBlock(Blocks.COBBLESTONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(1, 1).build()) {}, target + "_stairs", ITEM_FUNCTION_STANDARD);
        }
    }
}

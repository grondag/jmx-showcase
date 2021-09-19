package grondag.jmx;

import java.util.function.Function;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.material.Material;

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
		return new BlockItem(block, new Item.Properties()
				.stacksTo(64)
				.tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	};


	public static Item register(Block block, String name, Function<Block, Item> itemFunc) {
		final ResourceLocation id = new ResourceLocation("jmx", name);
		Registry.register(Registry.BLOCK, id, block);
		final Item result = itemFunc.apply(block);
		Registry.register(Registry.ITEM, id, result);
		return result;
	}

	public static final Block MULTIBLOCK_1 = new Block(FabricBlockSettings.of(Material.STONE).strength(1, 1));
	public static final Block MULTIBLOCK_2 = new Block(FabricBlockSettings.of(Material.STONE).strength(1, 1));

	@Override
	public void onInitialize() {
		register(MULTIBLOCK_1, "jmx_multi", ITEM_FUNCTION_STANDARD);
		register(MULTIBLOCK_2, "jmx_multi2", ITEM_FUNCTION_STANDARD);

		for(final String target : TARGETS) {
			register(new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1, 1)), target + "_slab", ITEM_FUNCTION_STANDARD);
			register(new FenceBlock(FabricBlockSettings.of(Material.STONE).strength(1, 1)), target + "_fence", ITEM_FUNCTION_STANDARD);
			register(new StairBlock(Blocks.COBBLESTONE.defaultBlockState(), FabricBlockSettings.of(Material.STONE).strength(1, 1)) {}, target + "_stairs", ITEM_FUNCTION_STANDARD);
		}
	}
}

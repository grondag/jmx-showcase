package grondag.jmx;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import grondag.jmx.api.JmxInitializer;
import grondag.jmx.api.RetexturedModelBuilder;

public class ShowcaseClient implements JmxInitializer {
	@Override
	public void onInitalizeJmx() {
		for(final String target : Showcase.TARGETS) {
			BlockRenderLayerMap.INSTANCE.putBlock(Showcase.MULTIBLOCK_1, RenderType.cutout());
			BlockRenderLayerMap.INSTANCE.putBlock(Showcase.MULTIBLOCK_2, RenderType.cutout());

			RetexturedModelBuilder.builder("minecraft:stone_slab", "jmx:" + target + "_slab")
			.mapSprite("minecraft:block/stone", "minecraft:block/" + target).completeBlockWithItem();

			RetexturedModelBuilder.builder("minecraft:acacia_fence", "jmx:" + target + "_fence")
			.mapSprite("minecraft:block/acacia_planks", "minecraft:block/" + target).completeBlockWithItem();

			RetexturedModelBuilder.builder("minecraft:cobblestone_stairs", "jmx:" + target + "_stairs")
			.mapSprite("minecraft:block/cobblestone", "minecraft:block/" + target).completeBlockWithItem();
		}
	}
}

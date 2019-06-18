package grondag.jmx;

import grondag.jmx.api.RetexturedModelBuilder;
import grondag.jmx.api.JmxInitializer;

public class ShowcaseClient implements JmxInitializer {
    @Override
    public void onInitalizeJmx() {
        for(String target : Showcase.TARGETS) {
            RetexturedModelBuilder.builder("minecraft:stone_slab", "jmx:" + target + "_slab")
                .mapSprite("minecraft:block/stone", "minecraft:block/" + target).completeBlockWithItem();
            
            RetexturedModelBuilder.builder("minecraft:acacia_fence", "jmx:" + target + "_fence")
                .mapSprite("minecraft:block/acacia_planks", "minecraft:block/" + target).completeBlockWithItem();
            
            RetexturedModelBuilder.builder("minecraft:cobblestone_stairs", "jmx:" + target + "_stairs")
            .mapSprite("minecraft:block/cobblestone", "minecraft:block/" + target).completeBlockWithItem();
        }
    }
}

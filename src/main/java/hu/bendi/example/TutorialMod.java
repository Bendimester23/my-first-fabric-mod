package hu.bendi.example;

import hu.bendi.example.blocks.ModBlocks;
import hu.bendi.example.dimensions.TutorialDimensions;
import hu.bendi.example.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.LakeFeature;
import net.minecraft.world.gen.feature.LakeFeatureConfig;

public class TutorialMod implements ModInitializer {

	public static LakeFeature ACID_LAKE;

	public static final String MODID = "test";

	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModItems.register();
		TutorialDimensions.register();

		ACID_LAKE = Registry.register(Registry.FEATURE, new Identifier("test", "acid_lake"),
				new LakeFeature(LakeFeatureConfig::deserialize));

		Biome.configureFeature(ACID_LAKE, new LakeFeatureConfig(ModBlocks.FIRST_BLOCK.getDefaultState()), Decorator.COUNT_RANGE,
				new RangeDecoratorConfig(2, 20, 80, 100));
	}
}

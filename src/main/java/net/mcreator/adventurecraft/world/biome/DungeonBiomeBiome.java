
package net.mcreator.adventurecraft.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.block.Blocks;

import net.mcreator.adventurecraft.AdventureCraftElements;

import com.google.common.collect.Lists;

@AdventureCraftElements.ModElement.Tag
public class DungeonBiomeBiome extends AdventureCraftElements.ModElement {
	@ObjectHolder("adventurecraft:dungeonbiome")
	public static final CustomBiome biome = null;
	public DungeonBiomeBiome(AdventureCraftElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.2f).scale(0.35f).temperature(0.54f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState())));
			setRegistryName("dungeonbiome");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.DEFAULT_FLOWER,
					IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(14)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.GRASS,
					new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Placement.COUNT_HEIGHTMAP_DOUBLE, new FrequencyConfig(19)));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Biome.createDecoratedFeature(Feature.RANDOM_SELECTOR,
							new MultipleRandomFeatureConfig(new Feature[]{Feature.MEGA_SPRUCE_TREE},
									new IFeatureConfig[]{IFeatureConfig.NO_FEATURE_CONFIG, IFeatureConfig.NO_FEATURE_CONFIG},
									new float[]{1f / 3, 1f / 3}, Feature.SPRUCE_TREE, IFeatureConfig.NO_FEATURE_CONFIG),
							Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(14, 0.1F, 1)));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Biome.createDecoratedFeature(Feature.DISK,
							new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2,
									Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState())),
							Placement.COUNT_TOP_SOLID, new FrequencyConfig(8)));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Biome.createDecoratedFeature(Feature.DISK,
							new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), 6, 2,
									Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState())),
							Placement.COUNT_TOP_SOLID, new FrequencyConfig(10)));
		}
	}
}

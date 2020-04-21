
package net.mcreator.adventurecraft.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.adventurecraft.block.DungeonBrickBlock;
import net.mcreator.adventurecraft.AdventureCraftElements;

@AdventureCraftElements.ModElement.Tag
public class DungeonBiome extends AdventureCraftElements.ModElement {
	@ObjectHolder("adventurecraft:dungeon")
	public static final CustomBiome biome = null;
	public DungeonBiome(AdventureCraftElements instance) {
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
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(DungeonBrickBlock.block.getDefaultState(),
							DungeonBrickBlock.block.getDefaultState(), DungeonBrickBlock.block.getDefaultState())));
			setRegistryName("dungeon");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}

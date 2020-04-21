
package net.mcreator.adventurecraft.world.biome;

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

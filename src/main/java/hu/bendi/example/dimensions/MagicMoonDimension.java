package hu.bendi.example.dimensions;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.biome.source.FixedBiomeSourceConfig;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;
import net.minecraft.world.gen.chunk.DebugChunkGeneratorConfig;

public class MagicMoonDimension extends Dimension {    
    
    private static final Vec3d FOG_COLOR = new Vec3d(0.54, 0.44, 0.16);

    public MagicMoonDimension(World world, DimensionType type) {
        super(world, type);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {        
        DebugChunkGeneratorConfig generatorConfig = new DebugChunkGeneratorConfig();
        FixedBiomeSourceConfig biomeConfig = BiomeSourceType.FIXED.getConfig().setBiome(Biomes.JUNGLE);
        return ChunkGeneratorType.DEBUG.create(world, BiomeSourceType.FIXED.applyConfig(biomeConfig), generatorConfig);
    }

    @Override
    public BlockPos getSpawningBlockInChunk(ChunkPos chunkPos, boolean checkMobSpawnValidity) {
        return new BlockPos(0, 100, 0);
    }

    @Override
    public BlockPos getTopSpawningBlockPosition(int x, int z, boolean checkMobSpawnValidity) {
        return new BlockPos(0, 100, 0);
    }

    @Override
    public float getSkyAngle(long timeOfDay, float tickDelta) {
        return 0.5f;
    }

    @Override
    public boolean hasVisibleSky() {
        return true;
    }

    @Override
    public Vec3d getFogColor(float skyAngle, float tickDelta) {
        return FOG_COLOR;
    }

    @Override
    public boolean canPlayersSleep() {
        return false;
    }

    @Override
    public boolean isFogThick(int x, int z) {
        return false;
    }

    @Override
    public DimensionType getType() {
        return TutorialDimensions.MAGIC_MOON;
    }
    
}

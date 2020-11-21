package hu.bendi.example.dimensions;

import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.biome.source.BiomeSource;
import hu.bendi.example.blocks.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class MagicMoonChunkGenerator extends ChunkGenerator {

    public MagicMoonChunkGenerator(IWorld world, BiomeSource biomeSource, ChunkGeneratorConfig config) {
        super(world, biomeSource, config);
    }

    @Override
    public void buildSurface(Chunk chunk) {
        chunk.setBlockState(new BlockPos(0,1,0), ModBlocks.FIRST_BLOCK.getDefaultState(), true);
    }

    @Override
    public int getSpawnHeight() {
        // TODO Auto-generated method stub
        return 50;
    }

    @Override
    public void populateNoise(IWorld world, Chunk chunk) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getHeightOnGround(int x, int z, Type heightmapType) {
        // TODO Auto-generated method stub
        return 1;
    }
    
}

package tankcmod.evadamant.world;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import tankcmod.evadamant.ModBlocks;
import tankcmod.evadamant.blocks.ADMTOre;

import java.util.Random;

public class OreGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0:
                generateOverworld(world, random, chunkX, chunkZ);
                break;
        }

    }

    public void generateOverworld(World world, Random rand, int x, int z) {
        generateOre(ModBlocks.admtOre, world, rand, x, z, 1, 10, 4, 1, 16, Blocks.STONE);
    }

    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
        int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
        int heightRange = maxY - minY;
        //block.getDefaultState();
        WorldGenMinable gen = new WorldGenMinable(ModBlocks.admtOre.getDefaultState(), vienSize,BlockStateMatcher.forBlock(Blocks.STONE));
        for(int i = 0; i < ADMTOre.chance; i++) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
        }
    }
}
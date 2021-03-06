package arcadia;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import arcadia.blocks.BlocksArcadia;
import arcadia.world.gen.WorldGenNetherMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId)
        {
               case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
               case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
               case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
        }
  }
 
  private void generateEnd(World world, Random random, int x, int z)
  {
       
  }

  private void generateSurface(World world, Random random, int x, int z)
  {
       this.addOreSpawn(BlocksArcadia.oreCopper, world, random, x , z, 16, 16,
    		   3 + random.nextInt(2), 6 , 40, 70);
       this.addOreSpawn(BlocksArcadia.oreTin, world, random, x , z, 16, 16,
    		   3 + random.nextInt(1), 5 , 30, 60);
       this.addOreSpawn(BlocksArcadia.oreLead, world, random, x , z, 16, 16,
    		   2 + random.nextInt(1), 4 , 20, 50);
       this.addOreSpawn(BlocksArcadia.oreSilver, world, random, x , z, 16, 16,
    		   2 + random.nextInt(2), 3 , 0, 40);
       this.addOreSpawn(BlocksArcadia.oreRuby, world, random, x , z, 16, 16,
    		   1 + random.nextInt(2), 2 , 0, 10);
       this.addOreSpawn(BlocksArcadia.oreSapphire, world, random, x , z, 16, 16,
    		   1 + random.nextInt(3), 2 , 10, 20);
       
  }

  private void generateNether(World world, Random random, int x, int z)
  {
	  int Xcoord = x + random.nextInt(16);
      int Ycoord = 10 + random.nextInt(128);
      int Zcoord = z + random.nextInt(16);
      (new WorldGenNetherMinable(BlocksArcadia.oreSilver.blockID, 0, 15)).generate(world, random, Xcoord, Ycoord, Zcoord);
  }
		
	
	
	/**
	 * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
	 *
	 * @param The Block to spawn
	 * @param The World to spawn in
	 * @param A Random object for retrieving random positions within the world to spawn the Block
	 * @param An int for passing the X-Coordinate for the Generation method
	 * @param An int for passing the Z-Coordinate for the Generation method
	 * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum size of a vein
	 * @param An int for the Number of chances available for the Block to spawn per-chunk
	 * @param An int for the minimum Y-Coordinate height at which this block may spawn
	 * @param An int for the maximum Y-Coordinate height at which this block may spawn
	 **/
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
	       @SuppressWarnings("unused")
	       int maxPossY = minY + (maxY - 1);
	       assert maxY > minY: "The maximum Y must be greater than the Minimum Y";
	       assert maxX > 0 && maxX <= 16: "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
	       assert minY > 0: "addOreSpawn: The Minimum Y must be greater than 0";
	       assert maxY < 256 && maxY > 0: "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
	       assert maxZ > 0 && maxZ <= 16: "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
	      
	       int diffBtwnMinMaxY = maxY - minY;
	       for(int x = 0; x < chancesToSpawn; x++)
	       {
	             int posX = blockXPos + random.nextInt(maxX);
	             int posY = minY + random.nextInt(diffBtwnMinMaxY);
	             int posZ = blockZPos + random.nextInt(maxZ);
	             (new WorldGenMinable(block.blockID, maxVeinSize)).generate(world, random, posX, posY, posZ);
	       }
	}

}

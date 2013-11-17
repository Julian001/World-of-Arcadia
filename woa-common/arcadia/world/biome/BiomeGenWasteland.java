package arcadia.world.biome;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenTrees;
import arcadia.entity.EntityBandit;
import arcadia.entity.EntityBanditArcher;

public class BiomeGenWasteland extends BiomeGenBase
{
	@SuppressWarnings("unchecked")
	public BiomeGenWasteland(int par1) {
		super(par1);
		this.topBlock = (byte) Block.hardenedClay.blockID;
		this.fillerBlock = (byte) Block.hardenedClay.blockID;
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 5, 10, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBandit.class, 5, 10, 10));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBanditArcher.class, 5, 10, 10));
		
		this.theBiomeDecorator.deadBushPerChunk = 5;
		this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.cactiPerChunk = 0;
        
		this.waterColorMultiplier = 86777215;
		this.worldGeneratorTrees = new WorldGenTrees(false);
        this.worldGeneratorBigTree = new WorldGenBigTree(false);
        this.worldGeneratorForest = new WorldGenForest(false);
	}

}

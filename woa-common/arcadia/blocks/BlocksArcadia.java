package arcadia.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import arcadia.arcadia;
import arcadia.items.ItemBlockRedRock;
import arcadia.lib.References;
import arcadia.lib.config.Ids;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class BlocksArcadia {
	//----Ores----//
    public static Block oreSilver;
    public static Block oreCopper;
    public static Block oreTin;
    public static Block oreLead;
    public static Block oreRuby;
    public static Block oreSapphire;
    //----OreBlocks----//       
    public static Block blockSilver;
    public static Block blockCopper;
    public static Block blockTin;
    public static Block blockLead;
    public static Block blockRuby;
    public static Block blockSapphire;
    public static Block blockBronze;
    //----Anvil----//
    public static Block anvilArcadia;
    //----RedRock----//
    public static Block redRock;
    //----Stairs----//
    public static Block stairRedRockCobble;
    public static Block stairRedRockBrick;
    //----PotionCombiner----//
    public static Block potionCombiner;
    public static Block potionCombiner_active;
    
    public static void init() {
       //----Ores----//
 	   oreSilver = new BlockArcadia(Ids.oreSilver, Material.rock).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreSilver");
 	   oreCopper = new BlockArcadia(Ids.oreCopper, Material.rock).setHardness(2.5F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreCopper");
 	   oreTin = new BlockArcadia(Ids.oreTin, Material.rock).setHardness(2.5F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreTin");
 	   oreLead = new BlockArcadia(Ids.oreLead, Material.rock).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreLead");
 	   oreRuby = new BlockArcadia(Ids.oreRuby, Material.rock).setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRuby");
 	   oreSapphire = new BlockArcadia(Ids.oreSapphire, Material.rock).setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreSapphire");
 	   //----OreBlocks----//
	   blockSilver = new BlockArcadia(Ids.blockSilver, Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockSilver");
	   blockCopper = new BlockArcadia(Ids.blockCopper, Material.iron).setHardness(2.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockCopper");
	   blockTin = new BlockArcadia(Ids.blockTin, Material.iron).setHardness(2.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockTin");
	   blockLead = new BlockArcadia(Ids.blockLead, Material.iron).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockLead");
	   blockRuby = new BlockArcadia(Ids.blockRuby, Material.iron).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockRuby");
	   blockSapphire = new BlockArcadia(Ids.blockSapphire, Material.iron).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockSapphire");
	   blockBronze = new BlockArcadia(Ids.blockBronze, Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockBronze");
	   
 	   //----Anvil----//
	   anvilArcadia = new BlockAnvil(Ids.anvilArcadia).setUnlocalizedName("anvil");
	   //----RedRock----//
	   redRock = new BlockRedRock(Ids.redRock, Material.rock).setUnlocalizedName("redRock");
	   //----Stairs----//
	   stairRedRockCobble = new BlockStair(Ids.stairRedRockCobble, BlocksArcadia.redRock, 1).setUnlocalizedName("stairRedRockCobble");
	   stairRedRockBrick = new BlockStair(Ids.stairRedRockBrick, BlocksArcadia.redRock, 2).setUnlocalizedName("stairRedRockBrick");
	   //-----PotionCombiner----//
	   potionCombiner = new BlockPotionCombiner(Ids.potionCombiner, false, Material.iron).setCreativeTab(arcadia.tabArcadiaBlocks).setUnlocalizedName("potionCombiner");
	   potionCombiner_active = new BlockPotionCombiner(Ids.potionCombiner_active, true, Material.iron).setUnlocalizedName("potionCombiner_active");
	   
 	   registerBlocks();
    }
    
    public static void registerBlocks() {
       //----Ores----//
 	   GameRegistry.registerBlock(oreSilver, References.ID + oreSilver.getUnlocalizedName().substring(5));
 	   GameRegistry.registerBlock(oreCopper, References.ID + oreCopper.getUnlocalizedName().substring(5));
 	   GameRegistry.registerBlock(oreTin, References.ID + oreTin.getUnlocalizedName().substring(5));
 	   GameRegistry.registerBlock(oreLead, References.ID + oreLead.getUnlocalizedName().substring(5));
 	   GameRegistry.registerBlock(oreRuby, References.ID + oreRuby.getUnlocalizedName().substring(5));
 	   GameRegistry.registerBlock(oreSapphire, References.ID + oreSapphire.getUnlocalizedName().substring(5));
 	   //----OreBlocks----//
	   GameRegistry.registerBlock(blockSilver, References.ID + blockSilver.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(blockCopper, References.ID + blockCopper.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(blockTin, References.ID + blockTin.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(blockLead, References.ID + blockLead.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(blockRuby, References.ID + blockRuby.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(blockSapphire, References.ID + blockSapphire.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(blockBronze, References.ID + blockBronze.getUnlocalizedName().substring(5));
 	   //----Anvil----//
 	   GameRegistry.registerBlock(anvilArcadia, References.ID + anvilArcadia.getUnlocalizedName().substring(5));
 	   //----RedRock----//
	   GameRegistry.registerBlock(redRock, ItemBlockRedRock.class, References.ID + (redRock.getUnlocalizedName().substring(5)));
	   //----Stairs----//
	   GameRegistry.registerBlock(stairRedRockCobble, References.ID + stairRedRockCobble.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(stairRedRockBrick, References.ID + stairRedRockBrick.getUnlocalizedName().substring(5));
	   //----PotionCombiner----//
	   GameRegistry.registerBlock(potionCombiner, References.ID + potionCombiner.getUnlocalizedName().substring(5));
	   GameRegistry.registerBlock(potionCombiner_active, References.ID + potionCombiner_active.getUnlocalizedName().substring(5));
	   
    }
    
    public static void addNames() {
       //----Ores----//
 	   LanguageRegistry.addName(oreSilver, "Silver Ore");
 	   LanguageRegistry.addName(oreCopper, "Copper Ore");
 	   LanguageRegistry.addName(oreTin, "Tin Ore");
 	   LanguageRegistry.addName(oreLead, "Lead Ore");
 	   LanguageRegistry.addName(oreRuby, "\u00a7cRuby Ore");
 	   LanguageRegistry.addName(oreSapphire, "\u00a7bSapphire Ore");
 	   //----OreBlocks----//
 	   LanguageRegistry.addName(blockSilver, "Block of Silver");
	   LanguageRegistry.addName(blockCopper, "Block of Copper");
	   LanguageRegistry.addName(blockTin, "Block of Tin");
	   LanguageRegistry.addName(blockLead, "Block of Lead");
	   LanguageRegistry.addName(blockRuby, "\u00a7cBlock of Ruby");
	   LanguageRegistry.addName(blockSapphire, "\u00a7bBlock of Sapphire");
	   LanguageRegistry.addName(blockBronze, "Block of Bronze");
 	   //----Anvil----//
 	   LanguageRegistry.addName(anvilArcadia, "Anvil Arcadia");
 	   //-----RedRock----//
 	   LanguageRegistry.addName(new ItemStack(redRock, 1, 0), "Red Rock");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 1), "Red Rock Cobblestone");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 2), "Red Rock Brick");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 3), "Red Rock Brick Carved");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 4), "Red Rock Brick Cracked");
  	   //----Stairs----//
  	   LanguageRegistry.addName(stairRedRockCobble, "Red Rock Cobble Stair");
 	   LanguageRegistry.addName(stairRedRockBrick, "Red Rock Brick Stair");
  	   //----PotionCombiner----//
  	   LanguageRegistry.addName(potionCombiner, "Potion Combiner");
	   
    }

}

package arcadia.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import arcadia.arcadia;
import arcadia.ItemBlockArcadiaRedRock;
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
    //----Anvil----//
    public static Block anvilArcadia;
    //----RedRock----//
    public static Block redRock;
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
 	   //----Anvil----//
	   anvilArcadia = new BlockAnvil(Ids.anvilArcadia).setUnlocalizedName("anvil");
	   //----RedRock----//
	   redRock = new BlockRedRock(Ids.redRock, Material.rock).setUnlocalizedName("redRock");
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
 	   //----Anvil----//
 	   GameRegistry.registerBlock(anvilArcadia, References.ID + anvilArcadia.getUnlocalizedName().substring(5));
 	   //----RedRock----//
	   GameRegistry.registerBlock(redRock, ItemBlockArcadiaRedRock.class, References.ID + (redRock.getUnlocalizedName().substring(5)));
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
 	   //----Anvil----//
 	   LanguageRegistry.addName(anvilArcadia, "Anvil Arcadia");
 	   //-----RedRock----//
 	   LanguageRegistry.addName(new ItemStack(redRock, 1, 0), "Red Rock");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 1), "Red Rock Cobblestone");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 2), "Red Rock Brick");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 3), "Red Rock Brick Carved");
  	   LanguageRegistry.addName(new ItemStack(redRock, 1, 4), "Red Rock Brick Cracked");
  	   //----PotionCombiner----//
  	   LanguageRegistry.addName(potionCombiner, "Potion Combiner");
	   
    }

}

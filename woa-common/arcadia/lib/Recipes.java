package arcadia.lib;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import arcadia.arcadia;
import arcadia.blocks.BlocksArcadia;
import arcadia.items.ItemsArcadia;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void addRecipes()
    {
		//----Ores----//
		FurnaceRecipes.smelting().addSmelting(BlocksArcadia.oreSilver.blockID, 0, new ItemStack(ItemsArcadia.ingotSilver), 0.5F);
		FurnaceRecipes.smelting().addSmelting(BlocksArcadia.oreCopper.blockID, 0, new ItemStack(ItemsArcadia.ingotCopper), 0.1F);
		FurnaceRecipes.smelting().addSmelting(BlocksArcadia.oreTin.blockID, 0, new ItemStack(ItemsArcadia.ingotTin), 0.1F);
		FurnaceRecipes.smelting().addSmelting(BlocksArcadia.oreLead.blockID, 0, new ItemStack(ItemsArcadia.ingotLead), 0.1F);
		FurnaceRecipes.smelting().addSmelting(ItemsArcadia.blankBronze.itemID, 0, new ItemStack(ItemsArcadia.ingotBronze), 0.3F);
	    //TODO
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.blankBronze, 1), new Object[]{
			"XX",
			"XY",
			'X' , ItemsArcadia.ingotCopper, 'Y', ItemsArcadia.ingotTin		});
		
		//----Oreblocks----//
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.ingotSilver, 9), new Object[]{
			new ItemStack(arcadia.blockSilver)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockSilver), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotSilver		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.ingotCopper, 9), new Object[]{
			new ItemStack(arcadia.blockCopper)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockCopper), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotCopper		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.ingotTin, 9), new Object[]{
			new ItemStack(arcadia.blockTin)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockTin), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotTin		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.ingotLead, 9), new Object[]{
			new ItemStack(arcadia.blockLead)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockLead), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotLead		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.gemRuby, 9), new Object[]{
			new ItemStack(arcadia.blockRuby)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockRuby), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.gemRuby		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.gemSapphire, 9), new Object[]{
			new ItemStack(arcadia.blockSapphire)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockSapphire), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.gemSapphire		});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsArcadia.ingotBronze, 9), new Object[]{
			new ItemStack(arcadia.blockBronze)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockBronze), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotBronze		});
		
		//----Swords----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.swordSilver), new Object[]{
			"X",
			"X",
			"I",
			'X' , ItemsArcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.swordBronze), new Object[]{
			"X",
			"X",
			"I",
			'X' , ItemsArcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.swordRuby), new Object[]{
			"X",
			"X",
			"I",
			'X' , ItemsArcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.swordSapphire), new Object[]{
			"X",
			"X",
			"I",
			'X' , ItemsArcadia.gemSapphire, 'I', Item.stick		});
		
		//----Pickaxe----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.pickaxeSilver), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , ItemsArcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.pickaxeBronze), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , ItemsArcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.pickaxeRuby), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , ItemsArcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.pickaxeSapphire), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , ItemsArcadia.gemSapphire, 'I', Item.stick		});
		
		//----Shovel----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.shovelSilver), new Object[]{
			"X",
			"I",
			"I",
			'X' , ItemsArcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.shovelBronze), new Object[]{
			"X",
			"I",
			"I",
			'X' , ItemsArcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.shovelRuby), new Object[]{
			"X",
			"I",
			"I",
			'X' , ItemsArcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.shovelSapphire), new Object[]{
			"X",
			"I",
			"I",
			'X' , ItemsArcadia.gemSapphire, 'I', Item.stick		});
		
		//----Axe----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.axeSilver), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , ItemsArcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.axeBronze), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , ItemsArcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.axeRuby), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , ItemsArcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.axeSapphire), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , ItemsArcadia.gemSapphire, 'I', Item.stick		});
		
		//----Hoe----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.hoeSilver), new Object[]{
			"XX",
			" I",
			" I",
			'X' , ItemsArcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.hoeBronze), new Object[]{
			"XX",
			" I",
			" I",
			'X' , ItemsArcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.hoeRuby), new Object[]{
			"XX",
			" I",
			" I",
			'X' , ItemsArcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.hoeSapphire), new Object[]{
			"XX",
			" I",
			" I",
			'X' , ItemsArcadia.gemSapphire, 'I', Item.stick		});
		
		//----Helmet----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.helmetSilver), new Object[]{
			"XXX",
			"X X",
			'X' , ItemsArcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.helmetBronze), new Object[]{
			"XXX",
			"X X",
			'X' , ItemsArcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.helmetRuby), new Object[]{
			"XXX",
			"X X",
			'X' , ItemsArcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.helmetSapphire), new Object[]{
			"XXX",
			"X X",
			'X' , ItemsArcadia.gemSapphire		});
		
		//----Chestplate----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.chestplateSilver), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.chestplateBronze), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.chestplateRuby), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.chestplateSapphire), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , ItemsArcadia.gemSapphire		});
		
		//----Leggings----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.leggingsSilver), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , ItemsArcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.leggingsBronze), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , ItemsArcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.leggingsRuby), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , ItemsArcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.leggingsSapphire), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , ItemsArcadia.gemSapphire		});
		
		//----Boots----//
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.bootsSilver), new Object[]{
			"X X",
			"X X",
			'X' , ItemsArcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.bootsBronze), new Object[]{
			"X X",
			"X X",
			'X' , ItemsArcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.bootsRuby), new Object[]{
			"X X",
			"X X",
			'X' , ItemsArcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.bootsSapphire), new Object[]{
			"X X",
			"X X",
			'X' , ItemsArcadia.gemSapphire		});
		
		
		GameRegistry.addRecipe(new ItemStack(ItemsArcadia.potionArcadia, 1, 0), new Object[] {
			"X", 'X', new ItemStack(Item.potion,1,16)
		});
		FurnaceRecipes.smelting().addSmelting(Item.egg.itemID, new ItemStack(ItemsArcadia.friedEgg), 0.3F);
		
		//----RedRock----//
		FurnaceRecipes.smelting().addSmelting(BlocksArcadia.redRock.blockID, 1, new ItemStack(BlocksArcadia.redRock, 1, 0), 0.1F);
		GameRegistry.addRecipe(new ItemStack(BlocksArcadia.redRock, 4, 2), new Object[]{
			"XX",
			"XX",
			'X' , new ItemStack(BlocksArcadia.redRock, 1, 0)		});
		GameRegistry.addRecipe(new ItemStack(BlocksArcadia.redRock, 4, 3), new Object[]{
			"XX",
			"XX",
			'X' , new ItemStack(BlocksArcadia.redRock, 1, 2)		});
		
    }
	
}
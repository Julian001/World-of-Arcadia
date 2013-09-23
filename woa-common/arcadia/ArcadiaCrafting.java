package arcadia;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArcadiaCrafting {
	
	public static void addRecipes()
    {
		//----Ores----//
		FurnaceRecipes.smelting().addSmelting(arcadia.oreSilver.blockID, 0, new ItemStack(arcadia.ingotSilver), 0.5F);
		FurnaceRecipes.smelting().addSmelting(arcadia.oreCopper.blockID, 0, new ItemStack(arcadia.ingotCopper), 0.1F);
		FurnaceRecipes.smelting().addSmelting(arcadia.oreTin.blockID, 0, new ItemStack(arcadia.ingotTin), 0.1F);
		FurnaceRecipes.smelting().addSmelting(arcadia.oreLead.blockID, 0, new ItemStack(arcadia.ingotLead), 0.1F);
		FurnaceRecipes.smelting().addSmelting(arcadia.blankBronze.itemID, 0, new ItemStack(arcadia.ingotBronze), 0.3F);
	    //TODO
		GameRegistry.addRecipe(new ItemStack(arcadia.blankBronze, 1), new Object[]{
			"XX",
			"XY",
			'X' , arcadia.ingotCopper, 'Y', arcadia.ingotTin		});
		
		//----Oreblocks----//
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.ingotSilver, 9), new Object[]{
			new ItemStack(arcadia.blockSilver)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockSilver), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.ingotSilver		});
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.ingotCopper, 9), new Object[]{
			new ItemStack(arcadia.blockCopper)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockCopper), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.ingotCopper		});
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.ingotTin, 9), new Object[]{
			new ItemStack(arcadia.blockTin)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockTin), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.ingotTin		});
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.ingotLead, 9), new Object[]{
			new ItemStack(arcadia.blockLead)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockLead), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.ingotLead		});
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.gemRuby, 9), new Object[]{
			new ItemStack(arcadia.blockRuby)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockRuby), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.gemRuby		});
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.gemSapphire, 9), new Object[]{
			new ItemStack(arcadia.blockSapphire)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockSapphire), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.gemSapphire		});
		GameRegistry.addShapelessRecipe(new ItemStack(arcadia.ingotBronze, 9), new Object[]{
			new ItemStack(arcadia.blockBronze)		});		
		GameRegistry.addRecipe(new ItemStack(arcadia.blockBronze), new Object[]{
			"XXX",
			"XXX",
			"XXX",
			'X' , arcadia.ingotBronze		});
		
		//----Swords----//
		GameRegistry.addRecipe(new ItemStack(arcadia.swordSilver), new Object[]{
			"X",
			"X",
			"I",
			'X' , arcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.swordBronze), new Object[]{
			"X",
			"X",
			"I",
			'X' , arcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.swordRuby), new Object[]{
			"X",
			"X",
			"I",
			'X' , arcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.swordSapphire), new Object[]{
			"X",
			"X",
			"I",
			'X' , arcadia.gemSapphire, 'I', Item.stick		});
		
		//----Pickaxe----//
		GameRegistry.addRecipe(new ItemStack(arcadia.pickaxeSilver), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , arcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.pickaxeBronze), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , arcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.pickaxeRuby), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , arcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.pickaxeSapphire), new Object[]{
			"XXX",
			" I ",
			" I ",
			'X' , arcadia.gemSapphire, 'I', Item.stick		});
		
		//----Shovel----//
		GameRegistry.addRecipe(new ItemStack(arcadia.shovelSilver), new Object[]{
			"X",
			"I",
			"I",
			'X' , arcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.shovelBronze), new Object[]{
			"X",
			"I",
			"I",
			'X' , arcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.shovelRuby), new Object[]{
			"X",
			"I",
			"I",
			'X' , arcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.shovelSapphire), new Object[]{
			"X",
			"I",
			"I",
			'X' , arcadia.gemSapphire, 'I', Item.stick		});
		
		//----Axe----//
		GameRegistry.addRecipe(new ItemStack(arcadia.axeSilver), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , arcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.axeBronze), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , arcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.axeRuby), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , arcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.axeSapphire), new Object[]{
			"XX",
			"XI",
			" I",
			'X' , arcadia.gemSapphire, 'I', Item.stick		});
		
		//----Hoe----//
		GameRegistry.addRecipe(new ItemStack(arcadia.hoeSilver), new Object[]{
			"XX",
			" I",
			" I",
			'X' , arcadia.ingotSilver, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.hoeBronze), new Object[]{
			"XX",
			" I",
			" I",
			'X' , arcadia.ingotBronze, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.hoeRuby), new Object[]{
			"XX",
			" I",
			" I",
			'X' , arcadia.gemRuby, 'I', Item.stick		});
		GameRegistry.addRecipe(new ItemStack(arcadia.hoeSapphire), new Object[]{
			"XX",
			" I",
			" I",
			'X' , arcadia.gemSapphire, 'I', Item.stick		});
		
		//----Helmet----//
		GameRegistry.addRecipe(new ItemStack(arcadia.helmetSilver), new Object[]{
			"XXX",
			"X X",
			'X' , arcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(arcadia.helmetBronze), new Object[]{
			"XXX",
			"X X",
			'X' , arcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(arcadia.helmetRuby), new Object[]{
			"XXX",
			"X X",
			'X' , arcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(arcadia.helmetSapphire), new Object[]{
			"XXX",
			"X X",
			'X' , arcadia.gemSapphire		});
		
		//----Chestplate----//
		GameRegistry.addRecipe(new ItemStack(arcadia.chestplateSilver), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , arcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(arcadia.chestplateBronze), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , arcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(arcadia.chestplateRuby), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , arcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(arcadia.chestplateSapphire), new Object[]{
			"X X",
			"XXX",
			"XXX",
			'X' , arcadia.gemSapphire		});
		
		//----Leggings----//
		GameRegistry.addRecipe(new ItemStack(arcadia.leggingsSilver), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , arcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(arcadia.leggingsBronze), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , arcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(arcadia.leggingsRuby), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , arcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(arcadia.leggingsSapphire), new Object[]{
			"XXX",
			"X X",
			"X X",
			'X' , arcadia.gemSapphire		});
		
		//----Boots----//
		GameRegistry.addRecipe(new ItemStack(arcadia.bootsSilver), new Object[]{
			"X X",
			"X X",
			'X' , arcadia.ingotSilver		});
		GameRegistry.addRecipe(new ItemStack(arcadia.bootsBronze), new Object[]{
			"X X",
			"X X",
			'X' , arcadia.ingotBronze		});
		GameRegistry.addRecipe(new ItemStack(arcadia.bootsRuby), new Object[]{
			"X X",
			"X X",
			'X' , arcadia.gemRuby		});
		GameRegistry.addRecipe(new ItemStack(arcadia.bootsSapphire), new Object[]{
			"X X",
			"X X",
			'X' , arcadia.gemSapphire		});
		
		
		GameRegistry.addRecipe(new ItemStack(arcadia.potionHaste), new Object[] {
			"X", 'X', new ItemStack(Item.potion,1,16)
		});
		GameRegistry.addSmelting(Item.egg.itemID, new ItemStack(arcadia.friedEgg), 0.3F);
		
		//----RedRock----//
		FurnaceRecipes.smelting().addSmelting(arcadia.redRock.blockID, 1, new ItemStack(arcadia.redRock, 1, 0), 0.1F);
		GameRegistry.addRecipe(new ItemStack(arcadia.redRock, 4, 2), new Object[]{
			"XX",
			"XX",
			'X' , new ItemStack(arcadia.redRock, 1, 0)		});
		GameRegistry.addRecipe(new ItemStack(arcadia.redRock, 4, 3), new Object[]{
			"XX",
			"XX",
			'X' , new ItemStack(arcadia.redRock, 1, 2)		});
		
    }
	/*GameRegistry.addShapelessRecipe(new ItemStack(Tutorial.tutorialBlock), new Object[]{
        new ItemStack(Item.diamond), new ItemStack(Block.stone), new ItemStack(Item.dyePowder, 1, 15)
 });

 GameRegistry.addRecipe(new ItemStack(Tutorial.tutorialBlock), new Object[]{
        "XZX",
        "CXC",
        'X', Item.ingotGold, 'C', Block.stone, 'Z', new ItemStack(Item.dyePowder, 1, 15)
 });

 ItemStack enchanted = new ItemStack(Item.pickaxeStone);
 enchanted.addEnchantment(Enchantment.sharpness, 2);

 GameRegistry.addShapelessRecipe(enchanted, new Object[]{
               new ItemStack(Item.pickaxeStone), new ItemStack(Item.flint), new ItemStack(Tutorial.tutorialBlock)
 });

 FurnaceRecipes.smelting().addSmelting(Item.beefCooked.itemID, 0, new ItemStack(Tutorial.tutorialItem), 0.1F);
}*/
}
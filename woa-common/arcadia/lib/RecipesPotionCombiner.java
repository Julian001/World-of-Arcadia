package arcadia.lib;

import arcadia.items.ItemsArcadia;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesPotionCombiner
{
	public RecipesPotionCombiner()
	{
		
	}
	
	public static ItemStack getSmeltingResult(int i, int j)
	{
	         return getOutput(i, j);
	}
	
	private static ItemStack getOutput(int i, int j)
	{
	         if (i == Item.coal.itemID && j == Item.ingotIron.itemID || i == Item.ingotIron.itemID && j == Item.coal.itemID)
	         {
	                 return new ItemStack(Item.ingotGold, 1);
	         }
	         if (i == new ItemStack(ItemsArcadia.potionArcadia, 1, 7).itemID && j == new ItemStack(ItemsArcadia.potionArcadia, 1, 22).itemID  )
	         {
	        	 	return new ItemStack(ItemsArcadia.potionArcadia, 1, 23);
	         }
	         
	return null;
	}
}
package arcadia.lib;

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
	         
	return null;
	}
}
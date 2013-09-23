package arcadia;

import java.util.Comparator;
import net.minecraft.item.crafting.IRecipe;

public class RecipeSorterAnvilArcadia implements Comparator
{
	final CraftingManagerAnvilArcadia craftingManager;
	
	public RecipeSorterAnvilArcadia(CraftingManagerAnvilArcadia par1)
	{
	         this.craftingManager = par1;
	}
	
	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
	{
	         return par1IRecipe instanceof ShapelessRecipesAnvilArcadia && par2IRecipe instanceof ShapedRecipesAnvilArcadia ? 1 : (par2IRecipe instanceof ShapelessRecipesAnvilArcadia && par1IRecipe instanceof ShapedRecipesAnvilArcadia ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object par1Obj, Object par2Obj)
	{
	         return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
	}
}
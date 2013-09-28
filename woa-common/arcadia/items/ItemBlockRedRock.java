package arcadia.items;

import net.minecraft.item.ItemStack;

public class ItemBlockRedRock extends ItemBlockArcadia {

	public ItemBlockRedRock(int id) {
		super(id);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
   		String name = "";
   		switch(itemstack.getItemDamage())
   		{
   			case 0:
   			{
   				name = "";
   				break;
   			}
   			case 1:
   			{
   				name = "Cobble";
   				break;
   			}
   			case 2:
   			{
   				name = "Brick";
   				break;
   			}
   			case 3:
   			{
   				name = "BrickCarved";
   				break;
   			}
   			case 4:
   			{
   				name = "BrickCracked";
   				break;
   			}
   			default: name = "Broken";
       }
   		return getUnlocalizedName() + "." + name;
	}
	
	public int getMetadata(int par1)
	{
	      return par1;
	}
}

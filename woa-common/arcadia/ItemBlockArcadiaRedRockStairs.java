package arcadia;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockArcadiaRedRockStairs extends ItemBlock {

	public ItemBlockArcadiaRedRockStairs(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
	       String name = "";
	       switch(itemstack.getItemDamage())
	       {
	       case 0:
           {
                  name = "RedRockCobble";
                  break;
           }
           case 1:
           {
                  name = "RedRockBrick";
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

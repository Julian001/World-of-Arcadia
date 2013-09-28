package arcadia.items;

import net.minecraft.item.ItemBlock;
import arcadia.arcadia;

public class ItemBlockArcadia extends ItemBlock 
{
    public ItemBlockArcadia(int id) {
	    super(id);
	    this.setCreativeTab(arcadia.tabArcadiaBlocks);
    }
}
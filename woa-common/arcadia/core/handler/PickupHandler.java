package arcadia.core.handler;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import arcadia.arcadia;
import arcadia.blocks.BlocksArcadia;
import arcadia.items.ItemsArcadia;
import cpw.mods.fml.common.IPickupNotifier;

public class PickupHandler implements IPickupNotifier 
{
	@Override
	public void notifyPickup(EntityItem item, EntityPlayer player) 
	{
		if (item.getEntityItem().itemID == BlocksArcadia.oreSilver.blockID) 
		{
			player.addStat(arcadia.achievementNewOreArcadia, 1);
		}
		if (item.getEntityItem().itemID == ItemsArcadia.gemRuby.itemID) 
		{
			player.addStat(arcadia.achievementShinyThingsArcadia, 1);
		}
	}
}

package arcadia;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPickupNotifier;

public class PickupHandler implements IPickupNotifier {

	@Override
	public void notifyPickup(EntityItem item, EntityPlayer player) {
		
		if (item.getEntityItem().itemID == arcadia.oreSilver.blockID) {
			player.addStat(arcadia.achievementNewOreArcadia, 1);
		}
		if (item.getEntityItem().itemID == arcadia.gemRuby.itemID) {
			player.addStat(arcadia.achievementShinyThingsArcadia, 1);
		}

	}

}

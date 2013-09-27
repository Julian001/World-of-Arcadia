package arcadia.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import arcadia.arcadia;
import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcadia extends Item{

	public ItemArcadia(int id) {
		super(id);
		this.setCreativeTab(arcadia.tabArcadiaItems);
		
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(References.ID.toLowerCase() + ":" + (this.getUnlocalizedName().substring(5)));

	}

}

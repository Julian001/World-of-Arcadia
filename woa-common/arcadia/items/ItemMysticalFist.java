package arcadia.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import arcadia.arcadia;
import arcadia.lib.References;

public class ItemMysticalFist extends ItemOmniTool {

	public ItemMysticalFist(int id, EnumToolMaterial material) {
		super(id, 8F, material, blocksEffectiveAgainst);
		this.setMaxStackSize(1);
		this.setCreativeTab(arcadia.tabArcadiaItems);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(References.ID.toLowerCase() + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

package arcadia.items;

import arcadia.arcadia;
import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemPickaxeArcadia extends ItemPickaxe{

	public ItemPickaxeArcadia(int id, EnumToolMaterial par2EnumToolMaterial) {
		super(id, par2EnumToolMaterial);
		this.setCreativeTab(arcadia.tabArcadiaItems);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(References.ID + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

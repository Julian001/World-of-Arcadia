package arcadia.items;

import arcadia.arcadia;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import arcadia.lib.References;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFoodArcadia extends ItemFood
{
	public final int itemUseDuration;    
	@SuppressWarnings("unused")
	private final int healAmount;
    @SuppressWarnings("unused")
	private final float saturationModifier;
    @SuppressWarnings("unused")
	private final boolean isWolfsFavoriteMeat;
    
	public ItemFoodArcadia(int id, int par2, float par3, boolean par4) {
		super(id, par2, par3, par4);
		this.itemUseDuration = 32;
        this.healAmount = par2;
        this.isWolfsFavoriteMeat = par4;
        this.saturationModifier = par3;
		this.setCreativeTab(arcadia.tabArcadiaItems);
	}
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(References.ID + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

package arcadia.bag;

import arcadia.arcadia;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnderBagArcadia extends Item {

	public ItemEnderBagArcadia(int par1) {
		super(par1);
		this.setCreativeTab(arcadia.tabArcadiaItems);
		this.setMaxStackSize(1);
		
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		InventoryEnderChest inventory = par3EntityPlayer.getInventoryEnderChest();
		par3EntityPlayer.displayGUIChest(inventory);
		return par1ItemStack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(arcadia.modid + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

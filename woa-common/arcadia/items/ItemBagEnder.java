package arcadia.items;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import arcadia.arcadia;
import arcadia.bag.ContainerBagEnder;
import arcadia.lib.References;
import arcadia.lib.config.GuiIds;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBagEnder extends ItemArcadia 
{
	public ItemBagEnder(int id) {
		super(id);
		this.setCreativeTab(arcadia.tabArcadiaItems);
		this.setMaxStackSize(1);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	{
		if (!world.isRemote && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
		
			if (FMLClientHandler.instance().getClient().inGameHasFocus
					&& Keyboard.isKeyDown(Keyboard.KEY_I)
					&& player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemBagEnder)
			{
				player.openGui(arcadia.instance, GuiIds.guiBagEnderIndex, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}
		
			if(player.openContainer != null && player.openContainer instanceof ContainerBagEnder
					&& ((ContainerBagEnder) player.openContainer).needsUpdate)
			{
				//((ContainerBagEnder) player.openContainer).writeToNBT();
				((ContainerBagEnder) player.openContainer).needsUpdate = false;
			}
		}
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 1;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			player.openGui(arcadia.instance, GuiIds.guiBagEnderIndex, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		return itemstack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(References.ID + ":" + (this.getUnlocalizedName().substring(5)));

	}
}
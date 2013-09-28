package arcadia.bag;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBagEnder extends Container
{
	public final InventoryEnderChest inventory;
	@SuppressWarnings("unused")
	private final ItemStack containerstack;
	public boolean needsUpdate;
	
	/** Using these will make transferStackInSlot easier to understand and implement
	* INV_START is the index of the first slot in the Player's Inventory, so our
	* InventoryItem's number of slots (e.g. 5 slots is array indices 0-4, so start at 5)
	* Notice how we don't have to remember how many slots we made? We can just use
	* InventoryItem.INV_SIZE and if we ever change it, the Container updates automatically. */
	//private static final int INV_START = InventoryBagMediumArcadia.INV_SIZE, INV_END = INV_START+26,
	//HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;
	
	public ContainerBagEnder(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, InventoryEnderChest inventoryEnderChest)
	{
		this.inventory = inventoryEnderChest;
		this.containerstack = par1Player.getHeldItem();
		
		int i;
		
		for (i = 0; i < 27; ++i)
		{
		// You can make a custom Slot if you need different behavior,
		// such as only certain item types can be put into this slot
		// We made a custom slot to prevent our inventory-storing item
		// from being stored within itself, but if you want to allow that and
		// you followed my advice at the end of the above step, then you
		// could get away with using the vanilla Slot class Block
			this.addSlotToContainer(new Slot(inventoryEnderChest, i, 8 + (18 * (int)(i/3)), 12 + (18*(i%3))));
		}
		/*for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryEnderChest, j + i * 9 + 9, 8 + j * 18, 12 + i * 18));
			}
		}*/
		
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 80 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 138));
		}
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
	return true;
	}
	
	/**
	* Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	* Only real change we make to this is to set needsUpdate to true at the end
	*/
	/*public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
	
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (par2 < INV_START)
			{
	// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true))
				{
					return null;
				}
	
				slot.onSlotChange(itemstack1, itemstack);
			}
			else
			{
	/* If your inventory only stores certain instances of Items,
	* you can implement shift-clicking to your inventory like this:
	// Check that the item is the right type
	if (itemstack1.getItem() instanceof ItemCustom)
	{
	// Try to merge into your custom inventory slots
	// We use 'InventoryItem.INV_SIZE' instead of INV_START just in case
	// you also add armor or other custom slots
	if (!this.mergeItemStack(itemstack1, 0, InventoryItem.INV_SIZE, false))
	{
	return null;
	}
	}
	// If you added armor slots, check them here as well:
	// Item being shift-clicked is armor - try to put in armor slot
	if (itemstack1.getItem() instanceof ItemArmor)
	{
	int type = ((ItemArmor) itemstack1.getItem()).armorType;
	if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
	{
	return null;
	}
	}
	* Otherwise, you have basically 2 choices:
	* 1. shift-clicking between action bar and inventory
	* 2. shift-clicking between player inventory and custom inventory
	* I've implemented number 1:
	*/
	// item is in player's inventory, but not in action bar
				/*if (par2 >= INV_START && par2 < HOTBAR_START)
				{*/
	// place in action bar
					/*if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END+1, false))
					{
						return null;
					}
				}*/
	// item in action bar - place in player inventory
				/*else if (par2 >= HOTBAR_START && par2 < HOTBAR_END+1)
				{
					if (!this.mergeItemStack(itemstack1, INV_START, INV_END+1, false))
					{
						return null;
					}
				}
			}*/
	
			/*if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
	
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
	
			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}*/
	        
	/* This flag tells our custom Item to call ContainerItem's writeToNBT method
	this.needsUpdate = true;
	        
	return itemstack;
	}*/
	
	/**
	* We only override this so that we can tell our InventoryItem to update
	*/
	/*public ItemStack slotClick(int slotID, int buttonPressed, int flag, EntityPlayer player)
	{
		this.needsUpdate = true;
		return super.slotClick(slotID, buttonPressed, flag, player);
	}*/
}
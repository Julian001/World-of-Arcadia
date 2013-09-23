package arcadia;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryBagArcadia implements IInventory
{
	private String name = "Inventory Item";
	
	/** Defining your inventory size this way is handy */
	public static final int INV_SIZE = 8;
	
	/** Inventory's size must be same as number of slots you add to the Container class */
	ItemStack[] inventory = new ItemStack[INV_SIZE];
	
	/**
	* @param itemstack - the ItemStack to which this inventory belongs
	*/
	public InventoryBagArcadia(ItemStack itemstack)
	{
	// Just in case the itemstack doesn't yet have an NBT Tag Compound:
	if (!itemstack.hasTagCompound())
	{
	itemstack.setTagCompound(new NBTTagCompound());
	}
	// Read the inventory contents from NBT
	readFromNBT(itemstack.getTagCompound());
	}
	
	@Override
	public int getSizeInventory()
	{
	return inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot)
	{
	return inventory[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
	ItemStack stack = getStackInSlot(slot);
	if(stack != null)
	{
	if(stack.stackSize > amount)
	{
	stack = stack.splitStack(amount);
	if(stack.stackSize == 0)
	{
	setInventorySlotContents(slot, null);
	}
	}
	else
	{
	setInventorySlotContents(slot, null);
	}
	
	this.onInventoryChanged();
	}
	return stack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
	ItemStack stack = getStackInSlot(slot);
	if(stack != null)
	{
	setInventorySlotContents(slot, null);
	}
	return stack;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
	this.inventory[slot] = itemstack;
	
	if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
	{
	itemstack.stackSize = this.getInventoryStackLimit();
	}
	
	this.onInventoryChanged();
	}
	
	@Override
	public String getInvName()
	{
	return name;
	}
	
	@Override
	public boolean isInvNameLocalized()
	{
	return name.length() > 0;
	}
	
	@Override
	public int getInventoryStackLimit()
	{
	return 64;
	}
	
	@Override
	public void onInventoryChanged()
	{
	for (int i = 0; i < this.getSizeInventory(); ++i)
	{
	if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)
	this.setInventorySlotContents(i, null);
	}
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
	return true;
	}
	
	@Override
	public void openChest() {}
	
	@Override
	public void closeChest() {}
	
	/**
	* This method doesn't seem to do what it claims to do, as
	* items can still be left-clicked and placed in the inventory
	* even when this returns false
	*/
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
	// Don't want to be able to store the inventory item within itself
	// Bad things will happen, like losing your inventory
	// Actually, this needs a custom Slot to work
	return !(itemstack.getItem() instanceof ItemArcadiaBag);
	}
	
	/**
	* A custom method to read our inventory from an ItemStack's NBT compound
	*/
	public void readFromNBT(NBTTagCompound tagcompound)
	{
	// Gets the custom taglist we wrote to this compound, if any
	NBTTagList nbttaglist = tagcompound.getTagList("ItemInventory");
	
	for (int i = 0; i < nbttaglist.tagCount(); ++i)
	{
	NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
	int b0 = nbttagcompound1.getInteger("Slot");
	
	// Just double-checking that the saved slot index is within our inventory array bounds
	if (b0 >= 0 && b0 < this.getSizeInventory())
	{
	this.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
	}
	}
	}
	
	/**
	* A custom method to write our inventory to an ItemStack's NBT compound
	*/
	public void writeToNBT(NBTTagCompound tagcompound)
	{
	// Create a new NBT Tag List to store itemstacks as NBT Tags
	NBTTagList nbttaglist = new NBTTagList();
	
	for (int i = 0; i < this.getSizeInventory(); ++i)
	{
	// Only write stacks that contain items
	if (this.getStackInSlot(i) != null)
	{
	// Make a new NBT Tag Compound to write the itemstack and slot index to
	NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	nbttagcompound1.setInteger("Slot", i);
	// Writes the itemstack in slot(i) to the Tag Compound we just made
	this.getStackInSlot(i).writeToNBT(nbttagcompound1);
	
	// add the tag compound to our tag list
	nbttaglist.appendTag(nbttagcompound1);
	}
	}
	// Add the TagList to the ItemStack's Tag Compound with the name "ItemInventory"
	tagcompound.setTag("ItemInventory", nbttaglist);
	}
}
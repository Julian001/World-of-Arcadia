package arcadia;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrossbowArcadia extends Item
{
	public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	private int fireRateTicks = 3;
	private boolean firing = false;
	
	private int firingTimer = 0;
	
	private World lastWorld;
	public ItemCrossbowArcadia(int par1)
	{
	         super(par1);
	         this.maxStackSize = 1;
	         this.setMaxDamage(384);
	         this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	/**
	         * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
	         */
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
	         firingTimer = 0;
	}
	
	public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count)
	{
	         firingTimer--;
	         if( firingTimer <= 0 )
	         {
	                firingTimer = fireRateTicks;
	                fireBullet( stack, lastWorld, player );
	         }
	}
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
	         return par1ItemStack;
	}
	/**
	         * How long it takes to use or consume an item
	         */
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
	         return 75000;
	}
	/**
	         * returns the action that specifies what animation to play when the items is being used
	         */
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
	         return EnumAction.none;
	}
	/**
	         * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	         */
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
	         lastWorld = par2World;
	                
	         ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
	         MinecraftForge.EVENT_BUS.post(event);
	         if (event.isCanceled())
	         {
	                 return event.result;
	         }
	         if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItem(arcadia.bolt.itemID))
	         {
	                 par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	                
	         }
	         return par1ItemStack;
	}
	
	public void fireBullet(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
	         float j = 200f;
	        
	         boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
	         if (flag || par3EntityPlayer.inventory.hasItem(arcadia.bolt.itemID))
	         {
	                 float f = (float)j / 20.0F;
	                 f = (f * f + f * 2.0F) / 3.0F;
	                 if ((double)f < 0.1D)
	                 {
	                         return;
	                 }
	                 if (f > 1.0F)
	                 {
	                         f = 1.0F;
	                 }
	                 EntityBolt entityarrow = new EntityBolt(par2World, par3EntityPlayer, f * 2.0F);
	                 //if (f == 1.0F)
	                 //{
	                         // entityarrow.setIsCritical(true);
	                 //}
	                 int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
	                 if (k > 0)
	                 {
	                         entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
	                 }
	                 @SuppressWarnings("unused")
	                 int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
	                
	                 // bullets shouldn't cause knockback
	                 //if (l > 0)
	                 //{
	                         // entityarrow.setKnockbackStrength(l);
	                 // }
	                 // hehe, incendiary ammo!
	                 if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
	                 {
	                         entityarrow.setFire(100);
	                 }
	                 // par1ItemStack.damageItem(1, par3EntityPlayer);
	                 //par2World.playSoundAtEntity(par3EntityPlayer, "generic:machinegun", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	                 if (flag)
	                 {
	                         entityarrow.canBePickedUp = 2;
	                 }
	                 else
	                 {
	                         par3EntityPlayer.inventory.consumeInventoryItem(arcadia.bolt.itemID);
	                 }
	                 if (!par2World.isRemote)
	                 {
	                         par2World.spawnEntityInWorld(entityarrow);
	                 }
	         }
	}
	
	public int getFireRate()
	{
	         return fireRateTicks;
	}
	
	public void setFireRate( int val )
	{
	         fireRateTicks = val;
	}
	
	public boolean getIsFiring()
	{
	         return firing;
	}
	
	public void setIsFiring( boolean val )
	{
	         firing = val;
	}
	/**
	         * Return the enchantability factor of the item, most of the time is based on material.
	         */
	public int getItemEnchantability()
	{
	         return 1;
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	         this.itemIcon = par1IconRegister.registerIcon(this.getUnlocalizedName() + "_standby");
	         this.iconArray = new Icon[bowPullIconNameArray.length];
	         for (int i = 0; i < this.iconArray.length; ++i)
	         {
	                 this.iconArray[i] = par1IconRegister.registerIcon(this.getUnlocalizedName() + "_" + bowPullIconNameArray[i]);
	         }
	}
	@SideOnly(Side.CLIENT)
	/**
	         * used to cycle through icons based on their used duration, i.e. for the bow
	         */
	public Icon getItemIconForUseDuration(int par1)
	{
	         return this.iconArray[par1];
	}
}
package arcadia;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashMultimap;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcadiaPotion extends ItemFood{

	private int potionId;
	private float potionEffectProbability;
	private int potionDuration;
    private int potionAmplifier;
    private static int par2 = 0;
    private static boolean par3 = false;
	
	public ItemArcadiaPotion(int par1, int id, int dur, int amp) {
		super(par1, par2, par3);
		this.setMaxStackSize(1);
		this.setAlwaysEdible();
		this.setCreativeTab(arcadia.tabArcadiaPotions);	
		potionId = id;
		potionDuration = dur;
		potionAmplifier = amp;
		potionEffectProbability = 1F;		
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }
        if (!par2World.isRemote && this.potionId > 0 && par2World.rand.nextFloat() < this.potionEffectProbability)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
        }
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            if (par1ItemStack.stackSize <= 0)
            {
                return new ItemStack(Item.glassBottle);
            }

            par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
        }

        return par1ItemStack;
    }
	
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
		}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
		if (stack.itemID == new ItemStack(arcadia.potionHaste).itemID) {
			list.add("Haste (3:00)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A79+20% Digging Speed");
		}
		if (stack.itemID == new ItemStack(arcadia.potionMiningFatigue).itemID) {
			list.add("Mining Fatigue (3:00)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A7c-20% Digging Speed");
		}
		if (stack.itemID == new ItemStack(arcadia.potionJumpBoost).itemID) {
			list.add("Jump Boost (3:00)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A79+1 Block Jump Hight");
		}
		if (stack.itemID == new ItemStack(arcadia.potionNausea).itemID) {
			list.add("Nausea (3:00)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A7cYou feel sick!");
		}
		if (stack.itemID == new ItemStack(arcadia.potionWaterBreathing).itemID) {
			list.add("Water Breathing (3:00)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A79+100% Air Regeneration");
		}
		if (stack.itemID == new ItemStack(arcadia.potionBlindness).itemID) {
			list.add("Blindness (3:00)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A7cYou can't see anymore!");
		}
		if (stack.itemID == new ItemStack(arcadia.potionWither).itemID) {
			list.add("Wither (0:45)");
			list.add("");
			list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("potion.effects.whenDrank"));
			list.add("\u00A7c-0.5 Hearts per Second");
		}
	
	}
		
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(arcadia.modid + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

package arcadia;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcadiaSword extends ItemSword
{
	private float weaponDamage;
    private final EnumToolMaterial toolMaterial;
    
	public ItemArcadiaSword(int par1, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(par1, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(arcadia.tabArcadiaItems);
        this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
	}

	
    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
    	par1ItemStack.damageItem(1, par3EntityLiving);
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.knockup.effectId, par1ItemStack) == 1)
        	par2EntityLiving.motionY+=0.5;//Auf Level 1
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.knockup.effectId, par1ItemStack) == 2)
        	par2EntityLiving.motionY+=0.6;
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.stun.effectId, par1ItemStack) == 1)
        	par2EntityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 0));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.stun.effectId, par1ItemStack) == 2)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 1));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.stun.effectId, par1ItemStack) == 3)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 2));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.poison.effectId, par1ItemStack) == 1)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 0));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.poison.effectId, par1ItemStack) == 2)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 1));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.poison.effectId, par1ItemStack) == 3)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 2));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.wither.effectId, par1ItemStack) == 1)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 600, 0));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.wither.effectId, par1ItemStack) == 2)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 600, 1));
        if (EnchantmentHelper.getEnchantmentLevel(arcadia.wither.effectId, par1ItemStack) == 3)
            par2EntityLiving.addPotionEffect(new PotionEffect(Potion.wither.id, 600, 2));
        return true;
    	
    }

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(arcadia.modid + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

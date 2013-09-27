package arcadia.items;

import arcadia.arcadia;
import arcadia.lib.References;
import net.minecraft.item.ItemSword;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSwordArcadia extends ItemSword
{
	@SuppressWarnings("unused")
	private float weaponDamage;
    @SuppressWarnings("unused")
	private final EnumToolMaterial toolMaterial;
    
	public ItemSwordArcadia(int id, EnumToolMaterial par2EnumToolMaterial) 
	{
		super(id, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(arcadia.tabArcadiaItems);
        this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
	}

    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
    	par1ItemStack.damageItem(1, par2EntityLiving);
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
	    this.itemIcon = par1IconRegister.registerIcon(References.ID + ":" + (this.getUnlocalizedName().substring(5)));

	}
}

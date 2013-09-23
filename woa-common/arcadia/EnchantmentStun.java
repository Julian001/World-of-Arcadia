package arcadia;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class EnchantmentStun extends Enchantment {
	public EnchantmentStun(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.weapon);        
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 20;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 3;
    }

    /**
     * Return the name of key in translation table of this enchantment.
     */
    public String getTranslatedName(int par1)
	{
		String enchantmentName = "Stun";
		return enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + par1);
	}

    public boolean canApply(ItemStack par1ItemStack)
    {
    	//return this.type.canEnchantItem(par1ItemStack.getItem());
        return par1ItemStack.getItem() instanceof ItemAxe ? true : this.type.canEnchantItem(par1ItemStack.getItem());
    }
    
}

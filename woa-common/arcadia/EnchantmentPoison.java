package arcadia;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.StatCollector;

public class EnchantmentPoison extends Enchantment {
	public EnchantmentPoison(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.weapon);        
    }

    public int getMinEnchantability(int par1)
    {
        return 20;
    }

    public int getMaxEnchantability(int par1)
    {
        return 50;
    }

    public int getMaxLevel()
    {
        return 3;
    }

    public String getTranslatedName(int par1)
	{
		String enchantmentName = "Posion";
		return enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + par1);
	}
}

package arcadia;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.StatCollector;

public class EnchantmentKnockup extends Enchantment {

	protected EnchantmentKnockup(int par1, int par2) {
		super(par1, par2, EnumEnchantmentType.weapon);
		this.setName("knockup");
	}
	
	//Returns the minimal value of enchantability needed on the enchantment level passed.
	public int getMinEnchantability(int par1)
	{
		return 20;
	}
	
	//Returns the maximum value of enchantability needed on the enchantment level passed.
	public int getMaxEnchantability(int par1)
	{
		return 50;
	}
	
	//Returns the maximum level that the enchantment can have.
	public int getMaxLevel()
	{
		return 2;
	}
	
	public String getTranslatedName(int par1)
	{
		String enchantmentName = "Knockup";
		return enchantmentName + " " + StatCollector.translateToLocal("enchantment.level." + par1);
	}
}

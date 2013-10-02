package arcadia.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import arcadia.bag.ItemArcadiaBag;
import arcadia.bag.ItemArcadiaBagMedium;
import arcadia.bag.ItemArcadiaBagSmall;
import arcadia.lib.config.Ids;

public class ItemsArcadia 
{
	//----Food----//
	public static Item friedEgg;
	//----Ingots----//
    public static Item ingotSilver;
    public static Item ingotCopper;
    public static Item ingotTin;
    public static Item ingotLead;
    public static Item ingotBronze;
    public static Item blankBronze;
    public static Item gemRuby;
    public static Item gemSapphire;
    //----Matrials----//
    static EnumToolMaterial toolSILVER = EnumHelper.addToolMaterial("Silver", 2, 80, 10F, 3F, 18);
    static EnumToolMaterial toolBRONZE = EnumHelper.addToolMaterial("Bronze", 2, 500, 6.5F, 2F, 15);
    static EnumToolMaterial toolRUBY = EnumHelper.addToolMaterial("Ruby", 2, 800, 11F, 4, 18);
    static EnumToolMaterial toolSAPPHIRE= EnumHelper.addToolMaterial("Sapphire", 2, 2000, 8F, 2, 16);
    static EnumArmorMaterial armorSILVER = EnumHelper.addArmorMaterial("Silver", 10, new int[]{2, 5, 4, 1}, 18);
    static EnumArmorMaterial armorBRONZE = EnumHelper.addArmorMaterial("Bronze", 18, new int[]{2, 6, 5, 2}, 15);
    static EnumArmorMaterial armorRUBY = EnumHelper.addArmorMaterial("Ruby", 22, new int[]{3, 8, 6, 3}, 18);
    static EnumArmorMaterial armorSAPPHIRE = EnumHelper.addArmorMaterial("Sapphire", 44, new int[]{3, 7, 5, 3}, 16);
	/*WOOD(0, 59, 2.0F, 0.0F, 15),
	STONE(1, 131, 4.0F, 1.0F, 5),
	IRON(2, 250, 6.0F, 2.0F, 14),
	EMERALD(3, 1561, 8.0F, 3.0F, 10),
	GOLD(0, 32, 12.0F, 0.0F, 22);
    CLOTH(5, new int[]{1, 3, 2, 1}, 15),
    CHAIN(15, new int[]{2, 5, 4, 1}, 12),
    IRON(15, new int[]{2, 6, 5, 2}, 9),
    GOLD(7, new int[]{2, 5, 3, 1}, 25),
    DIAMOND(33, new int[]{3, 8, 6, 3}, 10);*/
    //----Swords----//
    public static Item swordSilver;
    public static Item swordBronze;
    public static Item swordRuby;
    public static Item swordSapphire;
    //----Pickaxe----//
    public static Item pickaxeSilver;
    public static Item pickaxeBronze;
    public static Item pickaxeRuby;
    public static Item pickaxeSapphire;
    //----Shovel----//
    public static Item shovelSilver;
    public static Item shovelBronze;
    public static Item shovelRuby;
    public static Item shovelSapphire;
    //----Axe----//
    public static Item axeSilver;
    public static Item axeBronze;
    public static Item axeRuby;
    public static Item axeSapphire;
    //----Hoe----//
    public static Item hoeSilver;
    public static Item hoeBronze;
    public static Item hoeRuby;
    public static Item hoeSapphire;
    //----Helmet----//
    public static Item helmetSilver;
    public static Item helmetBronze;
    public static Item helmetRuby;
    public static Item helmetSapphire;
    //----Chestplate----//
    public static Item chestplateSilver;
    public static Item chestplateBronze;
    public static Item chestplateRuby;
    public static Item chestplateSapphire;
    //----Leggings----//
    public static Item leggingsSilver;
    public static Item leggingsBronze;
    public static Item leggingsRuby;
    public static Item leggingsSapphire;
    //----Boots----//
    public static Item bootsSilver;
    public static Item bootsBronze;
    public static Item bootsRuby;
    public static Item bootsSapphire;
    //----Potions----//
    public static Item potionArcadia;
    //----MysticalFist----//
	public static Item mysticalFist;
	//----Bags----//
	public static Item bagEnder;
    public static Item bagSmall;
    public static Item bagMedium;
    public static Item bagHuge;
    //----Crossbows----//
    public static Item crossbowIron;
	
	public static void init() {
		//----Food----//
		friedEgg = new ItemFoodArcadia(Ids.friedEgg, 6, 2F, false).setUnlocalizedName("friedEgg");
		//----Ingots----//
 	    ingotSilver = new ItemArcadia(Ids.ingotSilver).setUnlocalizedName("ingotSilver");
		ingotCopper = new ItemArcadia(Ids.ingotCopper).setUnlocalizedName("ingotCopper");
		ingotTin = new ItemArcadia(Ids.ingotTin).setUnlocalizedName("ingotTin");
		ingotLead = new ItemArcadia(Ids.ingotLead).setUnlocalizedName("ingotLead");
		ingotBronze = new ItemArcadia(Ids.ingotBronze).setUnlocalizedName("ingotBronze");
		blankBronze = new ItemArcadia(Ids.blankBronze).setUnlocalizedName("blankBronze");
		gemRuby = new ItemArcadia(Ids.gemRuby).setUnlocalizedName("gemRuby");
		gemSapphire = new ItemArcadia(Ids.gemSapphire).setUnlocalizedName("gemSapphire");
		//----Swords----//
 	   	swordSilver = new ItemSwordArcadia(Ids.swordSilver, toolSILVER).setUnlocalizedName("swordSilver");
 	   	swordBronze = new ItemSwordArcadia(Ids.swordBronze, toolBRONZE).setUnlocalizedName("swordBronze");
 	   	swordRuby = new ItemSwordArcadia(Ids.swordRuby, toolRUBY).setUnlocalizedName("swordRuby");
 	   	swordSapphire = new ItemSwordArcadia(Ids.swordSapphire, toolSAPPHIRE).setUnlocalizedName("swordSapphire");
 	   	//----Pickaxe----//
 	   	pickaxeSilver = new ItemPickaxeArcadia(Ids.pickaxeSilver, toolSILVER).setUnlocalizedName("pickaxeSilver");
 	    pickaxeBronze = new ItemPickaxeArcadia(Ids.pickaxeBronze, toolBRONZE).setUnlocalizedName("pickaxeBronze");
 	    pickaxeRuby = new ItemPickaxeArcadia(Ids.pickaxeRuby, toolRUBY).setUnlocalizedName("pickaxeRuby");
 	    pickaxeSapphire = new ItemPickaxeArcadia(Ids.pickaxeSapphire, toolSAPPHIRE).setUnlocalizedName("pickaxeSapphire");
 	    //----Shovel----//
 	    shovelSilver = new ItemShovelArcadia(Ids.shovelSilver, toolSILVER).setUnlocalizedName("shovelSilver");
 	    shovelBronze = new ItemShovelArcadia(Ids.shovelBronze, toolBRONZE).setUnlocalizedName("shovelBronze");
 	    shovelRuby = new ItemShovelArcadia(Ids.shovelRuby, toolRUBY).setUnlocalizedName("shovelRuby");
 	    shovelSapphire = new ItemShovelArcadia(Ids.shovelSapphire, toolSAPPHIRE).setUnlocalizedName("shovelSapphire");
 	    //----Axe----//
 	    axeSilver = new ItemAxeArcadia(Ids.axeSilver, toolSILVER).setUnlocalizedName("axeSilver");
 	    axeBronze = new ItemAxeArcadia(Ids.axeBronze, toolBRONZE).setUnlocalizedName("axeBronze");
 	    axeRuby = new ItemAxeArcadia(Ids.axeRuby, toolRUBY).setUnlocalizedName("axeRuby");
 	    axeSapphire = new ItemAxeArcadia(Ids.axeSapphire, toolSAPPHIRE).setUnlocalizedName("axeSapphire");
 	    //----Hoe----//
 	    hoeSilver = new ItemHoeArcadia(Ids.hoeSilver, toolSILVER).setUnlocalizedName("hoeSilver");
 	    hoeBronze = new ItemHoeArcadia(Ids.hoeBronze, toolBRONZE).setUnlocalizedName("hoeBronze");
 	    hoeRuby = new ItemHoeArcadia(Ids.hoeRuby, toolRUBY).setUnlocalizedName("hoeRuby");
 	    hoeSapphire = new ItemHoeArcadia(Ids.hoeSapphire, toolSAPPHIRE).setUnlocalizedName("hoeSapphire");
 	    //----Helmet----//
 	    helmetSilver = new ItemArmorArcadia(Ids.helmetSilver, armorSILVER, ModLoader.addArmor("Silver"), 0).setUnlocalizedName("helmetSilver");
 	    helmetBronze = new ItemArmorArcadia(Ids.helmetBronze, armorBRONZE, ModLoader.addArmor("Bronze"), 0).setUnlocalizedName("helmetBronze");
 	    helmetRuby = new ItemArmorArcadia(Ids.helmetRuby, armorRUBY, ModLoader.addArmor("Ruby"), 0).setUnlocalizedName("helmetRuby");
 	    helmetSapphire = new ItemArmorArcadia(Ids.helmetSapphire, armorSAPPHIRE, ModLoader.addArmor("Sapphire"), 0).setUnlocalizedName("helmetSapphire");
 	    //----Chestplate----//
 	    chestplateSilver = new ItemArmorArcadia(Ids.chestplateSilver, armorSILVER, ModLoader.addArmor("Silver"), 1).setUnlocalizedName("chestplateSilver");
 	    chestplateBronze = new ItemArmorArcadia(Ids.chestplateBronze, armorBRONZE, ModLoader.addArmor("Bronze"), 1).setUnlocalizedName("chestplateBronze");
 	    chestplateRuby = new ItemArmorArcadia(Ids.chestplateRuby, armorRUBY, ModLoader.addArmor("Ruby"), 1).setUnlocalizedName("chestplateRuby");
 	    chestplateSapphire = new ItemArmorArcadia(Ids.chestplateSapphire, armorSAPPHIRE, ModLoader.addArmor("Sapphire"), 1).setUnlocalizedName("chestplateSapphire");
 	    //----Leggings----//
 	    leggingsSilver = new ItemArmorArcadia(Ids.leggingsSilver, armorSILVER, ModLoader.addArmor("Silver"), 2).setUnlocalizedName("leggingsSilver");
 	    leggingsBronze = new ItemArmorArcadia(Ids.leggingsBronze, armorBRONZE, ModLoader.addArmor("Bronze"), 2).setUnlocalizedName("leggingsBronze");
 	    leggingsRuby = new ItemArmorArcadia(Ids.leggingsRuby, armorRUBY, ModLoader.addArmor("Ruby"), 2).setUnlocalizedName("leggingsRuby");
 	    leggingsSapphire = new ItemArmorArcadia(Ids.leggingsSapphire, armorSAPPHIRE, ModLoader.addArmor("Sapphire"), 2).setUnlocalizedName("leggingsSapphire");
 	    //----Boots----//
 	    bootsSilver = new ItemArmorArcadia(Ids.bootsSilver, armorSILVER, ModLoader.addArmor("Silver"), 3).setUnlocalizedName("bootsSilver");
 	    bootsBronze = new ItemArmorArcadia(Ids.bootsBronze, armorBRONZE, ModLoader.addArmor("Bronze"), 3).setUnlocalizedName("bootsBronze");
 	    bootsRuby = new ItemArmorArcadia(Ids.bootsRuby, armorRUBY, ModLoader.addArmor("Ruby"), 3).setUnlocalizedName("bootsRuby");
 	    bootsSapphire = new ItemArmorArcadia(Ids.bootsSapphire, armorSAPPHIRE, ModLoader.addArmor("Sapphire"), 3).setUnlocalizedName("bootsSapphire");
 	    //----Potions----//
 	    potionArcadia = new ItemPotionsArcadia(Ids.potionArcadia).setUnlocalizedName("potion");
 	    //----MysticalFist----//
 	    mysticalFist = new ItemMysticalFist(Ids.mysticalFist, toolRUBY).setUnlocalizedName("mysticalFist");
 	    //----Bags----//
 	    bagEnder = new ItemBagEnder(Ids.bagEnder).setUnlocalizedName("bagEnder");
 	    bagSmall = new ItemArcadiaBagSmall(Ids.bagSmall).setUnlocalizedName("bagSmall");
 	    bagMedium = new ItemArcadiaBagMedium(Ids.bagMedium).setUnlocalizedName("bagMedium");
 	    bagHuge = new ItemArcadiaBag(Ids.bagHuge).setUnlocalizedName("bagHuge");
 	    //----Crossbows----//
 	    crossbowIron = new ItemCrossbow(Ids.crossbowIron).setUnlocalizedName("crossbowIron");
 	   
	}
	
	public static void addNames() {
		//----Food----//
		LanguageRegistry.addName(friedEgg, "Fried Egg");
		//----Items-----//
 	   	LanguageRegistry.addName(ingotSilver, "Silver Ingot");
 	   	LanguageRegistry.addName(ingotCopper, "Copper Ingot");
 	   	LanguageRegistry.addName(ingotTin, "Tin Ingot");
 	   	LanguageRegistry.addName(ingotLead, "Lead Ingot");
 	   	LanguageRegistry.addName(ingotBronze, "Bronze Ingot");
 	   	LanguageRegistry.addName(blankBronze, "Blank Bronze");
 	   	LanguageRegistry.addName(gemRuby, "\u00a7cRuby");
 	   	LanguageRegistry.addName(gemSapphire, "\u00a7bSapphire");
 	   	//----Swords----//
 	   	LanguageRegistry.addName(swordSilver, "Silver Sword");
 	   	LanguageRegistry.addName(swordBronze, "Bronze Sword");
 	   	LanguageRegistry.addName(swordRuby, "\u00a7cRuby Sword");
 	   	LanguageRegistry.addName(swordSapphire, "\u00a7bSapphire Sword");
 	   	//----Pickaxes----//
 	   	LanguageRegistry.addName(pickaxeSilver, "Silver Pickaxe");
 	   	LanguageRegistry.addName(pickaxeBronze, "Bronze Pickaxe");
 	   	LanguageRegistry.addName(pickaxeRuby, "\u00a7cRuby Pickaxe");
 	   	LanguageRegistry.addName(pickaxeSapphire, "\u00a7bSapphire Pickaxe");
 	   	//----Shovels----//
 	   	LanguageRegistry.addName(shovelSilver, "Silver Shovel");
 	   	LanguageRegistry.addName(shovelBronze, "Bronze Shovel");
 	   	LanguageRegistry.addName(shovelRuby, "\u00a7cRuby Shovel");
 	   	LanguageRegistry.addName(shovelSapphire, "\u00a7bSapphire Shovel");
 	   	//----Axes----//
 	   	LanguageRegistry.addName(axeSilver, "Silver Axe");
 	   	LanguageRegistry.addName(axeBronze, "Bronze Axe");
 	   	LanguageRegistry.addName(axeRuby, "\u00a7cRuby Axe");
 	   	LanguageRegistry.addName(axeSapphire, "\u00a7bSapphire Axe");
 	   	//----Hoes----//
 	   	LanguageRegistry.addName(hoeSilver, "Silver Hoe");
 	   	LanguageRegistry.addName(hoeBronze, "Bronze Hoe");
 	   	LanguageRegistry.addName(hoeRuby, "\u00a7cRuby Hoe");
 	   	LanguageRegistry.addName(hoeSapphire, "\u00a7bSapphire Hoe");
 	   	//----Helmets----//
 	   	LanguageRegistry.addName(helmetSilver, "Silver Helmet");
 	   	LanguageRegistry.addName(helmetBronze, "Bronze Helmet");
 	   	LanguageRegistry.addName(helmetRuby, "\u00a7cRuby Helmet");
 	   	LanguageRegistry.addName(helmetSapphire, "\u00a7bSapphire Helmet");
 	   	//----Chesplates----//
 	   	LanguageRegistry.addName(chestplateSilver, "Silver Chestplate");
 	   	LanguageRegistry.addName(chestplateBronze, "Bronze Chestplate");
 	   	LanguageRegistry.addName(chestplateRuby, "\u00a7cRuby Chestplate");
 	   	LanguageRegistry.addName(chestplateSapphire, "\u00a7bSapphire Chestplate");
 	   	//----Leggings----//
 	   	LanguageRegistry.addName(leggingsSilver, "Silver Leggings");
 	   	LanguageRegistry.addName(leggingsBronze, "Bronze Leggings");
 	   	LanguageRegistry.addName(leggingsRuby, "\u00a7cRuby Leggings");
 	   	LanguageRegistry.addName(leggingsSapphire, "\u00a7bSapphire Leggings");
 	   	//----Boots----//
 	   	LanguageRegistry.addName(bootsSilver, "Silver Boots");
 	   	LanguageRegistry.addName(bootsBronze, "Bronze Boots");
 	   	LanguageRegistry.addName(bootsRuby, "\u00a7cRuby Boots");
 	   	LanguageRegistry.addName(bootsSapphire, "\u00a7bSapphire Boots");
 	   	//----Potions----//
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  0), "Potion of Haste");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  1), "Potion of Haste");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  2), "Potion of Haste");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  3), "Potion of Dullness");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  4), "Potion of Dullness");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  5), "Potion of Dullness");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  6), "Potion of Leaping");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  7), "Potion of Leaping");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  8), "Potion of Leaping");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1,  9), "Potion of Nausea");
 	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 10), "Potion of Nausea");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 11), "Potion of Water Breathing");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 12), "Potion of Water Breathing");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 13), "Potion of Blindness");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 14), "Potion of Blindness");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 15), "Potion of Hunger");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 16), "Potion of Hunger");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 17), "Potion of Hunger");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 18), "Potion of Wither");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 19), "Potion of Wither");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 20), "Potion of Wither");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 21), "Potion of Health");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 22), "Potion of Speed");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 23), "Potion of Movement");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 24), "Potion of Ninja");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 25), "Potion of Attack and Defence");
	   	LanguageRegistry.addName(new ItemStack(potionArcadia, 1, 26), "Potion of Sight");
	   	//----MysticalFist----//
	   	LanguageRegistry.addName(mysticalFist, "Mystical Fist");
		//----Bags----//
	   	LanguageRegistry.addName(bagEnder, "Ender Bag");
	   	LanguageRegistry.addName(bagSmall, "Small Bag");
	   	LanguageRegistry.addName(bagMedium, "Medium Bag");
	   	LanguageRegistry.addName(bagHuge, "Huge Bag");
	   	//----Crossbows----//
	   	LanguageRegistry.addName(crossbowIron, "Iron Crossbow");
	   	
	}
}

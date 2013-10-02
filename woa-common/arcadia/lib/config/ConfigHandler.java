package arcadia.lib.config;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {
	@SuppressWarnings("static-access")
	public static void init(File configFile) {
		Configuration config = new Configuration(configFile);
		
		final String BOOLEANS = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "booleans";
		
		config.load();
		
		Ids.friedEgg = config.getItem("Fried Egg", Ids.friedEgg_default).getInt() - 256;
		Ids.mysticalFist = config.getItem("Mystical Fist", Ids.mysticalFist_default).getInt() - 256;
		//----Ingots----//
		Ids.ingotSilver = config.getItem("Silver Ingot", Ids.ingotSilver_default).getInt() - 256;
		Ids.ingotCopper = config.getItem("Copper Ingot", Ids.ingotCopper_default).getInt() - 256;
		Ids.ingotTin = config.getItem("Tin Ingot", Ids.ingotTin_default).getInt() - 256;
		Ids.ingotLead = config.getItem("Lead Ingot", Ids.ingotLead_default).getInt() - 256;
		Ids.ingotBronze = config.getItem("Bronze Ingot", Ids.ingotBronze_default).getInt() - 256;
		Ids.blankBronze = config.getItem("Blank Bronze", Ids.blankBronze_default).getInt() - 256;
		Ids.gemRuby = config.getItem("Ruby", Ids.gemRuby_default).getInt() - 256;
		Ids.gemSapphire = config.getItem("Sapphire", Ids.gemSapphire_default).getInt() - 256;
		//----Swords----//
		Ids.swordSilver = config.getItem("Silver Sword", Ids.swordSilver_default).getInt() - 256;
		Ids.swordBronze = config.getItem("Bronze Sword", Ids.swordBronze_default).getInt() - 256;
		Ids.swordRuby = config.getItem("Ruby Sword", Ids.swordRuby_default).getInt() - 256;
		Ids.swordSapphire = config.getItem("Sapphire Sword", Ids.swordSapphire_default).getInt() - 256;
		//----Pickaxes----//
		Ids.pickaxeSilver = config.getItem("Silver Pickaxe", Ids.pickaxeSilver_default).getInt() - 256;
		Ids.pickaxeBronze = config.getItem("Bronze Pickaxe", Ids.pickaxeBronze_default).getInt() - 256;
		Ids.pickaxeRuby = config.getItem("Ruby Pickaxe", Ids.pickaxeRuby_default).getInt() - 256;
		Ids.pickaxeSapphire = config.getItem("Sapphire Pickaxe", Ids.pickaxeSapphire_default).getInt() - 256;
		//----Shovels----//
		Ids.shovelSilver = config.getItem("Silver Shovel", Ids.shovelSilver_default).getInt() - 256;
		Ids.shovelBronze = config.getItem("Bronze Shovel", Ids.shovelBronze_default).getInt() - 256;
		Ids.shovelRuby = config.getItem("Ruby Shovel", Ids.shovelRuby_default).getInt() - 256;
		Ids.shovelSapphire = config.getItem("Sapphire Shovel", Ids.shovelSapphire_default).getInt() - 256;
		//----Axes----//
		Ids.axeSilver = config.getItem("Silver Axe", Ids.axeSilver_default).getInt() - 256;
		Ids.axeBronze = config.getItem("Bronze Axe", Ids.axeBronze_default).getInt() - 256;
		Ids.axeRuby = config.getItem("Ruby Axe", Ids.axeRuby_default).getInt() - 256;
		Ids.axeSapphire = config.getItem("Sapphire Axe", Ids.axeSapphire_default).getInt() - 256;
		//----Hoes----//
		Ids.hoeSilver = config.getItem("Silver Hoe", Ids.hoeSilver_default).getInt() - 256;
		Ids.hoeBronze = config.getItem("Bronze Hoe", Ids.hoeBronze_default).getInt() - 256;
		Ids.hoeRuby = config.getItem("Ruby Hoe", Ids.hoeRuby_default).getInt() - 256;
		Ids.hoeSapphire = config.getItem("Sapphire Hoe", Ids.hoeSapphire_default).getInt() - 256;
		//----Helmets----//
		Ids.helmetSilver = config.getItem("Silver Helmet", Ids.helmetSilver_default).getInt() - 256;
		Ids.helmetBronze = config.getItem("Bronze Helmet", Ids.helmetBronze_default).getInt() - 256;
		Ids.helmetRuby = config.getItem("Ruby Helmet", Ids.helmetRuby_default).getInt() - 256;
		Ids.helmetSapphire = config.getItem("Sapphire Helmet", Ids.helmetSapphire_default).getInt() - 256;
		//----Chestplates----//
		Ids.chestplateSilver = config.getItem("Silver Chestplate", Ids.chestplateSilver_default).getInt() - 256;
		Ids.chestplateBronze = config.getItem("Bronze Chestplate", Ids.chestplateBronze_default).getInt() - 256;
		Ids.chestplateRuby = config.getItem("Ruby Chestplate", Ids.chestplateRuby_default).getInt() - 256;
		Ids.chestplateSapphire = config.getItem("Sapphire Chestplate", Ids.chestplateSapphire_default).getInt() - 256;
		//----Leggings----//
		Ids.leggingsSilver = config.getItem("Silver Leggings", Ids.leggingsSilver_default).getInt() - 256;
		Ids.leggingsBronze = config.getItem("Bronze Leggings", Ids.leggingsBronze_default).getInt() - 256;
		Ids.leggingsRuby = config.getItem("Ruby Leggings", Ids.leggingsRuby_default).getInt() - 256;
		Ids.leggingsSapphire = config.getItem("Sapphire Leggings", Ids.leggingsSapphire_default).getInt() - 256;
		//----Boots----//
		Ids.bootsSilver = config.getItem("Silver Boots", Ids.bootsSilver_default).getInt() - 256;
		Ids.bootsBronze = config.getItem("Bronze Boots", Ids.bootsBronze_default).getInt() - 256;
		Ids.bootsRuby = config.getItem("Ruby Boots", Ids.bootsRuby_default).getInt() - 256;
		Ids.bootsSapphire = config.getItem("Sapphire Boots", Ids.bootsSapphire_default).getInt() - 256;
		//----Potions----//
		Ids.potionArcadia = config.getItem("Potions", Ids.potionArcadia_default).getInt() - 256;
		//----Bags----//
		Ids.bagEnder = config.getItem("Ender Bag", Ids.bagEnder_default).getInt() - 256;
		Ids.bagSmall = config.getItem("Small Bag", Ids.bagSmall_default).getInt() - 256;
		Ids.bagMedium = config.getItem("Medium Bag", Ids.bagMedium_default).getInt() - 256;
		Ids.bagHuge = config.getItem("Huge Bag", Ids.bagHuge_default).getInt() - 256;
		//----Crossbows----//
		Ids.crossbowIron = config.getItem("Iron Crossbow", Ids.crossbowIron_default).getInt() - 256;
		
		//----Ores----//
		Ids.oreSilver = config.getBlock("Silver Ore", Ids.oreSilver_default).getInt();
		Ids.oreCopper = config.getBlock("Copper Ore", Ids.oreCopper_default).getInt();
		Ids.oreTin = config.getBlock("Tin Ore", Ids.oreTin_default).getInt();
		Ids.oreLead = config.getBlock("Lead Ore", Ids.oreLead_default).getInt();
		Ids.oreRuby = config.getBlock("Ruby Ore", Ids.oreRuby_default).getInt();
		Ids.oreSapphire = config.getBlock("Sapphire Ore", Ids.oreSapphire_default).getInt();
		//----OreBlocks----//
		Ids.blockSilver = config.getBlock("Block of Silver", Ids.blockSilver_default).getInt();
		Ids.blockCopper = config.getBlock("Block of Copper", Ids.blockCopper_default).getInt();
		Ids.blockTin = config.getBlock("Block of Tin", Ids.blockTin_default).getInt();
		Ids.blockLead = config.getBlock("Block of Lead", Ids.blockLead_default).getInt();
		Ids.blockRuby = config.getBlock("Block of Ruby", Ids.blockRuby_default).getInt();
		Ids.blockSapphire = config.getBlock("Block of Sapphire", Ids.blockSapphire_default).getInt();
		Ids.blockBronze = config.getBlock("Block of Bronze", Ids.blockBronze_default).getInt();
		
		//----Anvil----//
		Ids.anvilArcadia = config.getBlock("Anvil Arcadia", Ids.anvilArcadia_default).getInt();
		//----RedRock----//
		Ids.redRock = config.getBlock("Red Rock Blocks", Ids.redRock_default).getInt();
		//----PotionCombiner----//
		Ids.potionCombiner = config.getBlock("Potion Combiner", Ids.potionCombiner_default).getInt();
		Ids.potionCombiner_active = config.getBlock("Potion Combiner Active", Ids.potionCombiner_active_default).getInt();
		
		
		Booleans.enableCommandBlockInCreativeTab = config.get(BOOLEANS, "Enable Commandblock in Redstone Creative Tab", Booleans.enableCommandBlockInCreativeTab_dedault).getBoolean(Booleans.enableCommandBlockInCreativeTab_dedault);
		
		config.save();
	}

}

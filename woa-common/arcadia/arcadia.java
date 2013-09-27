package arcadia;

import java.util.logging.Level;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import arcadia.bag.ItemArcadiaBag;
import arcadia.bag.ItemArcadiaBagMedium;
import arcadia.bag.ItemArcadiaBagSmall;
import arcadia.blocks.BlockArcadia;
import arcadia.blocks.BlocksArcadia;
import arcadia.items.ItemsArcadia;
import arcadia.lib.LogHelper;
import arcadia.lib.Recipes;
import arcadia.lib.References;
import arcadia.lib.config.ConfigHandler;
import arcadia.proxies.CommonProxyArcadia;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = arcadia.modid, name = References.NAME, version = References.VERSION)
@NetworkMod( channels = {References.CHANNEL}, clientSideRequired = true, serverSideRequired = true)
public class arcadia
{
	   @Instance(arcadia.modid)
	   public static arcadia instance;
	   public static final String modid = "arcadia";
       
	   @SidedProxy(clientSide = References.PROXY_LOCATION + ".ClientProxyArcadia", serverSide = References.PROXY_LOCATION + ".CommonProxyArcadia")
       public static CommonProxyArcadia proxy;
	   
	   public static CreativeTabs tabArcadiaBlocks;
	   public static CreativeTabs tabArcadiaItems;
       public static CreativeTabs tabArcadiaPotions;
       
       private GuiHandlerArcadia guiHandlerArcadia = new GuiHandlerArcadia();
	   
       //----Crossbows----//
       public static Item crossbowWood;
       
       //----Bags----//
       public static Item bagSmall;
       public static Item bagMedium;
       public static Item bagHuge;
       public static Item bagEnder;
              
       //----Oreblocks----//       
       public static Block blockSilver;
       public static Block blockCopper;
       public static Block blockTin;
       public static Block blockLead;
       public static Block blockRuby;
       public static Block blockSapphire;
       public static Block blockBronze;
       
       
       public static Block stairRedRockCobble;
       public static Block stairRedRockBrick;
       
       //----Enchantments----//
       public static final Enchantment knockup = new EnchantmentKnockup(52, 1);
	   public static final Enchantment stun = new EnchantmentStun(53, 1);
	   public static final Enchantment poison = new EnchantmentPoison(54, 1);
	   public static final Enchantment wither = new EnchantmentWither(55, 1);
	  	   
	   //----Achievements----//
	   public static AchievementPage pageArcadia;
	   public static Achievement achievementNewOreArcadia;
	   public static Achievement achievementShinyThingsArcadia;
	   
	   //----Commands----/
	   public static final ICommand commandHeal = new CommandHealArcadia();
	   public static final ICommand commandEnderchest = new CommandEnderChest();
	   public static final ICommand commandDay = new CommandDayArcadia();
	   
	   public static final String waterBreathing = "-0+1-2-3&4-4+13";  
	      
       EventManager eventmanager = new EventManager();
      
       @EventHandler
       public static void preInit( FMLPreInitializationEvent event ) {
    	   LogHelper.init();
    	   ConfigHandler.init(event.getSuggestedConfigurationFile());
       }
       
       @EventHandler
       public void load(FMLInitializationEvent event)
       {
    	   tabArcadiaBlocks = new CreativeTabs("tabArcadiaBlocks") { public ItemStack getIconItemStack() {
    		   return new ItemStack(blockSilver, 1, 0);}};
    	   tabArcadiaItems = new CreativeTabs("tabArcadiaItems") { public ItemStack getIconItemStack() {
    		   return new ItemStack(ItemsArcadia.ingotSilver, 1, 0);}};
    	   tabArcadiaPotions = new CreativeTabs("tabArcadiaPotions") { public ItemStack getIconItemStack() {
    		   return new ItemStack(ItemsArcadia.potionArcadia, 1, 0);}};
                  
		   LogHelper.log(Level.INFO, "Preparing items");
		   ItemsArcadia.init();
    	   ItemsArcadia.addNames();
    	   LogHelper.log(Level.INFO, "Items loaded");
    	   
    	   LogHelper.log(Level.INFO, "Preparing blocks");
    	   BlocksArcadia.init();
    	   BlocksArcadia.addNames();
    	   LogHelper.log(Level.INFO, "Blocks loaded");
    	   
    	   NetworkRegistry.instance().registerGuiHandler(this, guiHandlerArcadia);
    	   
    	   //----Achievement----//
    	   achievementNewOreArcadia = new Achievement(1000, "NewOre", 0, 0, BlocksArcadia.oreSilver, AchievementList.mineWood).registerAchievement();
    	   achievementShinyThingsArcadia = new Achievement(1001, "ShinyThings", -1, 2, ItemsArcadia.gemRuby, achievementNewOreArcadia).setSpecial().registerAchievement();
    	   
    	   pageArcadia = new AchievementPage("World of Arcadia", achievementNewOreArcadia, achievementShinyThingsArcadia);
    	   AchievementPage.registerAchievementPage(pageArcadia);
    	      	   
    	   //----Crossbows----//
    	   crossbowWood = new ItemCrossbowArcadia(1110).setUnlocalizedName("crossbow");
    	       	   
    	   //----Bags----//
    	   bagEnder = new ItemEnderBagArcadia(1121).setUnlocalizedName("bagEnder");
    	   bagSmall = new ItemArcadiaBagSmall(1122).setUnlocalizedName("bagSmall");
    	   bagMedium = new ItemArcadiaBagMedium(1123).setUnlocalizedName("bagMedium");
    	   bagHuge = new ItemArcadiaBag(1124).setUnlocalizedName("bagHuge");
    	   
    	   
    	   //----Oreblocks----//
    	   blockSilver = new BlockArcadia(510, Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockSilver");
    	   blockCopper = new BlockArcadia(511, Material.iron).setHardness(2.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockCopper");
    	   blockTin = new BlockArcadia(512, Material.iron).setHardness(2.5F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockTin");
    	   blockLead = new BlockArcadia(513, Material.iron).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockLead");
    	   blockRuby = new BlockArcadia(514, Material.iron).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockRuby");
    	   blockSapphire = new BlockArcadia(515, Material.iron).setHardness(6.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockSapphire");
    	   blockBronze = new BlockArcadia(516, Material.iron).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("blockBronze");
    	   
    	   //stairRedRockCobble = new BlockArcadiaStairs(531, redRock, 1).setUnlocalizedName("stairRedRockCobble");
    	   //stairRedRockBrick = new BlockArcadiaStairs(532, redRock, 2).setUnlocalizedName("stairRedRockBrick");
    	   
    	   GameRegistry.registerWorldGenerator(eventmanager);
    	   GameRegistry.registerCraftingHandler(new CraftingHandler());
    	   GameRegistry.registerPickupHandler(new PickupHandler());
    	   
    	   LanguageRegistry.instance().addStringLocalization("itemGroup.tabArcadiaBlocks", "en_US", "\u00a79World of Arcadia Blocks");
    	   LanguageRegistry.instance().addStringLocalization("itemGroup.tabArcadiaItems", "en_US", "\u00a79World of Arcadia Items");
    	   LanguageRegistry.instance().addStringLocalization("itemGroup.tabArcadiaPotions", "en_US", "\u00a79World of Arcadia Potions");
    	   
    	   
    	   registerBlocks();
    	   registerLanguage();
    	   AchievementLocalizations();
    	   
    	   
       }
       
       @EventHandler
       public static void postInit( FMLPostInitializationEvent event ) {

       }
       
       @ServerStarting
       public void serverLoad(FMLServerStartingEvent event) {
    	   event.registerServerCommand(new CommandHealArcadia());
    	   event.registerServerCommand(new CommandEnderChest());
    	   event.registerServerCommand(new CommandDayArcadia());
       }
       
       private void registerBlocks(){
    	   //----Oreblock----//
    	   GameRegistry.registerBlock(blockSilver, modid + blockSilver.getUnlocalizedName().substring(5));
    	   GameRegistry.registerBlock(blockCopper, modid + blockCopper.getUnlocalizedName().substring(5));
    	   GameRegistry.registerBlock(blockTin, modid + blockTin.getUnlocalizedName().substring(5));
    	   GameRegistry.registerBlock(blockLead, modid + blockLead.getUnlocalizedName().substring(5));
    	   GameRegistry.registerBlock(blockRuby, modid + blockRuby.getUnlocalizedName().substring(5));
    	   GameRegistry.registerBlock(blockSapphire, modid + blockSapphire.getUnlocalizedName().substring(5));
    	   GameRegistry.registerBlock(blockBronze, modid + blockBronze.getUnlocalizedName().substring(5));
    	       	   
    	   //GameRegistry.registerBlock(stairRedRockCobble, modid + stairRedRockCobble.getUnlocalizedName().substring(5));
    	   //GameRegistry.registerBlock(stairRedRockBrick, modid + stairRedRockBrick.getUnlocalizedName().substring(5));
    	   
    	   LogHelper.log(Level.INFO, "Preparing recipes");
    	   Recipes.addRecipes();
    	   LogHelper.log(Level.INFO, "Recipes loaded");
       }
       
       private void registerLanguage(){
    	   LanguageRegistry.addName(crossbowWood, "Wood Crossbow");
		   
		   LanguageRegistry.addName(bagEnder, "Ender Bag");
		   LanguageRegistry.addName(bagSmall, "Small Bag");
		   LanguageRegistry.addName(bagMedium, "Medium Bag");
		   LanguageRegistry.addName(bagHuge, "Huge Bag");
		   
    	   LanguageRegistry.addName(blockSilver, "Block of Silver");
    	   LanguageRegistry.addName(blockCopper, "Block of Copper");
    	   LanguageRegistry.addName(blockTin, "Block of Tin");
    	   LanguageRegistry.addName(blockLead, "Block of Lead");
    	   LanguageRegistry.addName(blockRuby, "\u00a7cBlock of Ruby");
    	   LanguageRegistry.addName(blockSapphire, "\u00a7bBlock of Sapphire");
    	   LanguageRegistry.addName(blockBronze, "Block of Bronze");
    	   
	   	   //LanguageRegistry.addName(stairRedRockCobble, "Red Rock Cobble Stair");
	   	   //LanguageRegistry.addName(stairRedRockBrick, "Red Rock Brick Stair");
   	   }
       
       public void AchievementLocalizations(){
    	   LanguageRegistry.instance().addStringLocalization("achievement.NewOre", "en_US", "Search for new Ores");
           LanguageRegistry.instance().addStringLocalization("achievement.NewOre.desc", "en_US", "You found new Ores!");
           LanguageRegistry.instance().addStringLocalization("achievement.ShinyThings", "en_US", "Look for new stuff");
           LanguageRegistry.instance().addStringLocalization("achievement.ShinyThings.desc", "en_US", "You found Shiny Things!");
           
       }
}
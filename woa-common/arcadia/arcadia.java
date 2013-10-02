package arcadia;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.command.ICommand;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import arcadia.blocks.BlocksArcadia;
import arcadia.commands.CommandDayArcadia;
import arcadia.commands.CommandEnderChest;
import arcadia.commands.CommandHealArcadia;
import arcadia.commands.CommandSpeedArcadia;
import arcadia.core.handler.CraftingHandler;
import arcadia.core.handler.PickupHandler;
import arcadia.entity.EntityShark;
import arcadia.items.ItemArcadia;
import arcadia.items.ItemsArcadia;
import arcadia.lib.LogHelper;
import arcadia.lib.Recipes;
import arcadia.lib.References;
import arcadia.lib.config.BiomeIds;
import arcadia.lib.config.Booleans;
import arcadia.lib.config.ConfigHandler;
import arcadia.proxies.CommonProxyArcadia;
import arcadia.world.biome.BiomeGenWasteland;
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
import cpw.mods.fml.common.registry.EntityRegistry;
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
       public static Item bolt;
       
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
	   public static final ICommand commandSpeed = new CommandSpeedArcadia();
	   
	   public static final String waterBreathing = "-0+1-2-3&4-4+13";
	   public static double rand; 
	   public static BiomeGenBase wastelandBiome;
	   static int startEntityId = 300;
	      
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
    		   return new ItemStack(BlocksArcadia.blockSilver, 1, 0);}};
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
    	   bolt  = new ItemArcadia(12227).setUnlocalizedName("bolt");
    	       	   
    	   if(Booleans.enableCommandBlockInCreativeTab) {
    	   Block.commandBlock.setCreativeTab(CreativeTabs.tabRedstone); }
    	   
    	   //stairRedRockCobble = new BlockArcadiaStairs(531, redRock, 1).setUnlocalizedName("stairRedRockCobble");
    	   //stairRedRockBrick = new BlockArcadiaStairs(532, redRock, 2).setUnlocalizedName("stairRedRockBrick");
    	   
    	   wastelandBiome = new BiomeGenWasteland(BiomeIds.wastelandIndex).setColor(522674).func_76733_a(9154376).setBiomeName("Wasteland").setTemperatureRainfall(1F, 0.2F).setMinMaxHeight(0.0F, 0.2F);
    	   ModLoader.addBiome(wastelandBiome);
    	   
    	   EntityRegistry.registerModEntity(EntityShark.class, "Shark", 5, this, 40, 1, true);
		   EntityRegistry.addSpawn(EntityShark.class, 8, 1, 2, EnumCreatureType.waterCreature, wastelandBiome);
		   LanguageRegistry.instance().addStringLocalization("entity.arcadia.Shark.name", "Shark");
    	   
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
    	   event.registerServerCommand(new CommandSpeedArcadia());
       }
       
              
       private void registerBlocks(){
    	   //GameRegistry.registerBlock(stairRedRockCobble, modid + stairRedRockCobble.getUnlocalizedName().substring(5));
    	   //GameRegistry.registerBlock(stairRedRockBrick, modid + stairRedRockBrick.getUnlocalizedName().substring(5));
    	   
    	   LogHelper.log(Level.INFO, "Preparing recipes");
    	   Recipes.addRecipes();
    	   LogHelper.log(Level.INFO, "Recipes loaded");
       }
       
       private void registerLanguage(){
    	   LanguageRegistry.addName(crossbowWood, "Wood Crossbow");
		   
	   	   //LanguageRegistry.addName(stairRedRockCobble, "Red Rock Cobble Stair");
	   	   //LanguageRegistry.addName(stairRedRockBrick, "Red Rock Brick Stair");
   	   }
       
       public void AchievementLocalizations(){
    	   LanguageRegistry.instance().addStringLocalization("achievement.NewOre", "en_US", "Search for new Ores");
           LanguageRegistry.instance().addStringLocalization("achievement.NewOre.desc", "en_US", "You found new Ores!");
           LanguageRegistry.instance().addStringLocalization("achievement.ShinyThings", "en_US", "Look for new stuff");
           LanguageRegistry.instance().addStringLocalization("achievement.ShinyThings.desc", "en_US", "You found Shiny Things!");
           
       }
       
       @ForgeSubscribe
       public void onEntityDrop(LivingDropsEvent event) {
               if (event.source.getDamageType().equals("player")) {
                      
            	   rand = Math.random();
                       System.out.println("Killed something.");
                       if (event.entityLiving instanceof EntitySheep) {
                               System.out.println("Killed a sheep.");
                               if (rand < 1) { //Makes drop 100% drop chance. Example: (0.25D = 25%, 1D = 100%, etc.);
                                       event.entityLiving.dropItem(ItemsArcadia.gemRuby.itemID, 1);
                                       System.out.println("No errors if you can see this message in console");
                               }
                       }
               }
       }
       
       public static int getUniqueEntityId(){
 		  do {startEntityId++;} 
 		  while (EntityList.getStringFromID(startEntityId) != null);
 	
 		   return startEntityId;
       }
       
       public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor){
 		  int id = getUniqueEntityId();
 		  EntityList.IDtoClassMapping.put(id, entity);
 		  EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
       }
       
}